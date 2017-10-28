package com.codefish.sandbox.retrofit;

import java.util.List;
import java.util.Objects;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by abedch on 10/22/2017.
 */


public interface SandBoxService {

    @GET("users/{user}/repos")
    Observable<List<Object>> listRepos(@Path("user") String user);

}
