package AutomationTests.UsersModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface UsersInterface {
    @GET("/public/v1/users/{id}")
    Call<ModelClient> getUser(@Path("id") String id,
                              @Header("Authorization") String token);
}
