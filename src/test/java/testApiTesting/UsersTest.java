package testApiTesting;

import AutomationTests.UsersModel.ModelClient;

import AutomationTests.UsersModel.UsersInterface;
import AutomationTests.UsersModel.UsersModel;
import com.google.gson.internal.GsonBuildConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.mapper.factory.GsonObjectMapperFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import okhttp3.OkHttpClient;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

@Slf4j
public class UsersTest  {
    //private static final Logger log = LoggerFactory.getLogger(UsersTest.class);

    public static final String BASE_URI = "https://gorest.co.in/public/v1";

    @Test
    public void checkGetAllUsersEndpoint() {

        log.info("Start : getAllUsers {}");
        given()
                .baseUri(BASE_URI)
                .when()
                .get("/users")
                .then()
                .statusCode(HttpStatus.SC_OK);
        log.info("END : getAllUsers");


        log.info("Start : getAllUsers");
        Response response = given()
                .baseUri(BASE_URI)
                .when()
                .get("/users");
        response.prettyPrint();
        response.then().statusCode(200);
        response.then().statusLine("HTTP/1.1 200 OK");
        response.then().body(Matchers.not(Matchers.empty()));

        response.then().header("Content-type", "application/json; charset=utf-8");

        List<Object> firstPageClients = response.jsonPath().getList("data");
        Assertions.assertThat(firstPageClients.size()).isEqualTo(20);
        String firstClientName = response.jsonPath().getString("data[0].name");
        Assertions.assertThat(firstClientName).isEqualTo("Jo Jo");
        log.info("END : getAllUsers");
    }

    //}
    @Test
    void checkAddNewUserEndpoint_returns401_not_authorized() {
        Response postResponse = given().baseUri(BASE_URI)
                .when()
                .post("/users");
        postResponse.then().statusCode(401);
    }

    @Test
    void checkAddNewUserEndpoint() {
        String uniqueEmailGenerated = RandomString.make(5) + "@test.com";
        String name = "Jo_Jo_Test";

        ModelClient modelClient = new ModelClient();
        modelClient.setName(name);
        modelClient.setEmail(uniqueEmailGenerated);
        modelClient.setGender("male");
        modelClient.setStatus("active");

        Response postResponse = given().baseUri(BASE_URI)
                .when()
                .header("Authorization", "Bearer 6a2e66915f5232398603c71eda843f6076c46a853840ec5046ae6b7190db7f36")
                .header("Content-type", ContentType.JSON)
                .body(modelClient)
                .post("/users");
        postResponse.prettyPrint();
        postResponse.then().statusCode(201);

        postResponse.then().body("data", Matchers.hasEntry("email",uniqueEmailGenerated));
        postResponse.then().body("data", Matchers.hasEntry("name","Jo_Jo_Test"));
        postResponse.then().body("data", Matchers.hasEntry("gender","male"));
        postResponse.then().body("data", Matchers.hasEntry("status","active"));
        postResponse.then().body("data", Matchers.hasKey("id"));

        /*
        UsersModel actualModel = postResponse.body().as(UsersModel.class);

        Assertions.assertThat(actualModel.getData().getName()).isEqualTo(name);
        Assertions.assertThat(actualModel.getData().getEmail()).isEqualTo(uniqueEmailGenerated);
        Assertions.assertThat(actualModel.getData().getGender()).isEqualTo(modelClient.getGender());
        Assertions.assertThat(actualModel.getData().getStatus()).isEqualTo("active");
        //  Assertions.assertThat(actualModel.getData().getId()).isEqualTo("id");

        String actualName = postResponse.jsonPath().getString("data.name");
        Assertions.assertThat(actualName).isEqualTo(modelClient.getName());
*/
    }

    @Test
    void checkUpdateNewUserEndpoint() {
        String randomEmailGenerated = RandomString.make(4) + "@test.com";

        String name = "Jo_Jo_Test";
        Long id = 17951L;

        ModelClient testClient = new ModelClient();
        testClient.setName(name);
        testClient.setEmail(randomEmailGenerated);
        testClient.setStatus("active");
        testClient.setGender("female");
        testClient.setId(17951L);

        Response postResponse = given().baseUri(BASE_URI)
                .when()
                .header("Authorization", "Bearer 6a2e66915f5232398603c71eda843f6076c46a853840ec5046ae6b7190db7f36")
                .header("Content-type", ContentType.JSON)
                .body(testClient)
                .put(String.format("/users/%s", id));
        postResponse.prettyPrint();
        postResponse.then().statusCode(200);
        UsersModel actualModel = postResponse.body().as(UsersModel.class);

        Assertions.assertThat(actualModel.getData().getId()).isEqualTo(testClient.getId());
        Assertions.assertThat(actualModel.getData().getName()).isEqualTo(testClient.getName());
        Assertions.assertThat(actualModel.getData().getEmail()).isEqualTo(testClient.getEmail());
        Assertions.assertThat(actualModel.getData().getStatus()).isEqualTo(testClient.getStatus());
        Assertions.assertThat(actualModel.getData().getGender()).isEqualTo(testClient.getGender());


    }

    @Test
    void checkDeleteUserEndpoint_success(){
        Long id = 17679L;
        Response postResponse = given().baseUri(BASE_URI)
                .when()
                .header("Authorization", "Bearer 6a2e66915f5232398603c71eda843f6076c46a853840ec5046ae6b7190db7f36")
                .header("Content-type", ContentType.JSON)
                .delete(String.format("/users/%s", id));
        postResponse.prettyPrint();
        postResponse.then().statusCode(204);

    }
    @Test
    void getOneUser() throws IOException {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Retrofit client = new Retrofit.Builder()
                .baseUrl("http://gorest.co.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        UsersInterface usersInterface = client.create(UsersInterface.class);

        //WHEN
        retrofit2.Response<ModelClient> result =
                usersInterface.getUser("7757", "Bearer 6a2e66915f5232398603c71eda843f6076c46a853840ec5046ae6b7190db7f36").execute();
        //THEN
        Assertions.assertThat(result.code()).isEqualTo(200);
    }

}


