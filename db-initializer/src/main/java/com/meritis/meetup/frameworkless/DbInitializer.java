package com.meritis.meetup.frameworkless;

import com.google.common.collect.Lists;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.PreparedBatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class DbInitializer {
    private static final Random random = new Random();

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "postgres", "admin");
        Jdbi jdbi = Jdbi.create(connection);
        List<HammerTradeMarkEntity> tradeMarkEntityList = new ArrayList<>();
        List<HammerEntity> hammers = new ArrayList<>();
        int i = 1;
        do {
            HammerTradeMarkEntity tradeMark = new HammerTradeMarkEntity("TradeMark" + i);
            tradeMarkEntityList.add(tradeMark);
            i++;
            int j = 1;
            do {
                hammers.add(new HammerEntity(tradeMark.id, tradeMark.tradeMarkName() + "-" + j));
                j++;
            } while (j <= 100);
        } while (i <= 50_000);

        Lists.partition(tradeMarkEntityList, 100)
             .forEach(tds -> batchTradeMark(tds, jdbi));
        Lists.partition(hammers, 100)
             .forEach(hams -> batchHammers(hams, jdbi));
    }

    public static void batchTradeMark(List<HammerTradeMarkEntity> tradeMarks, Jdbi jdbi) {
        jdbi.useHandle(handle -> {
            PreparedBatch batch = new PreparedBatch(handle, """
                    insert into trade_mark_hammer (id, trade_mark_name)
                    values (:id, :name)
                    """);
            for (HammerTradeMarkEntity hammerTradeMarkEntity : tradeMarks) {
                batch.bind("id", hammerTradeMarkEntity.id)
                     .bind("name", hammerTradeMarkEntity.tradeMarkName)
                     .add();
            }
            batch.execute();
        });
    }

    public static void batchHammers(List<HammerEntity> hammers, Jdbi jdbi) {
        jdbi.useHandle(handle -> {
            PreparedBatch batch = new PreparedBatch(handle, """
                    insert into hammer (id, name, size, weight, trade_mark_id)
                    values (:id, :name, :size, :weight, :tradeMarkId)
                    """);
            for (HammerEntity hammer : hammers) {
                batch.bindFields(hammer)
                     .add();
            }
            batch.execute();
        });
    }

    public static class HammerEntity {
        public UUID id;
        public String name;
        public int size;
        public int weight;
        public UUID tradeMarkId;

        public HammerEntity(UUID tradeMarkId, String name) {
            this.id = UUID.randomUUID();
            this.name = name;
            this.size = rand();
            this.weight = rand();
            this.tradeMarkId = tradeMarkId;
        }
    }

    public record HammerTradeMarkEntity(UUID id, String tradeMarkName) {
        public HammerTradeMarkEntity(String name) {
            this(UUID.randomUUID(), name);
        }
    }

    private static int rand() {
        return random.nextInt(10) + 1;
    }
}
