package br.com.academy.repository.api;

import br.com.academy.model.Department;
import br.com.academy.repository.settings.ApiUrls;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IDepartmentRepository {

    @GET(ApiUrls.DEPARTAMENT + "?expand=users")
    Call<List<Department>> list(@Query("user_not_in") Integer user);

    @GET(ApiUrls.DEPARTAMENT + "{id}/")
    Call<Department> retrieve(@Path("id") Integer id);

}
