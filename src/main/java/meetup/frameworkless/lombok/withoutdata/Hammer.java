package meetup.frameworkless.lombok.withoutdata;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Hammer {
    public int size;
    public int weight;
}
