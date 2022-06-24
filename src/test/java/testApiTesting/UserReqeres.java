package testApiTesting;

import AutomationTests.UsersModel.ModelClient;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface UserReqeres {
        @GET("/api/users/{id}")
        Call<UsersReaqresTestClient> getUser(@Path("id") String id,
                                  @Header("Authorization") String token);
    }

