package testApiTesting;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class UsersReaqresTestClient {
    @JsonProperty("meta")
    private ReqresTestClient meta;
    @JsonProperty("data")
    private ReqresTestClient data;

}
