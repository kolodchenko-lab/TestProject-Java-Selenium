package AutomationTests.TableTest;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class TableTest {

    private Long id;
    private String name;
    private Float price;
    private String date;
}
