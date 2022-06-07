package AutomationTests.ClientLombok;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class ClientLombok {

    @Getter
    @ToString
    @Builder
    public static class Client {
        private Long id;
        private String name;
        private String lastName;
        private String address;
        private Long balance;
        private Long rate;
        private String login;
    }
}
