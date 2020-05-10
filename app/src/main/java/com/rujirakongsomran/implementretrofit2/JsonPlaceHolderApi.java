package com.rujirakongsomran.implementretrofit2;

import com.rujirakongsomran.implementretrofit2.Model.People;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    @FormUrlEncoded
    @POST("api/users")
    Call<People> createPeople(@FieldMap Map<String, String> fields);

    @FormUrlEncoded
    @POST("api/users")
    Call<People> createPeople(
            @Field("name") String name,
            @Field("job") String job
    );
}
