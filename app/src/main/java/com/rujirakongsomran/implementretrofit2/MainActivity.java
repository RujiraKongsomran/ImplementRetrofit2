package com.rujirakongsomran.implementretrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


import com.rujirakongsomran.implementretrofit2.Model.People;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {

        tvResult = (TextView) findViewById(R.id.tvResult);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        createPeople();
    }

    private void createPeople() {
        Map<String, String> fields = new HashMap<>();
        fields.put("name", "Biw");
        fields.put("job", "System Engineer");

        Call<People> call = jsonPlaceHolderApi.createPeople(fields);

        call.enqueue(new Callback<People>() {
            @Override
            public void onResponse(Call<People> call, Response<People> response) {
                if (!response.isSuccessful()) {
                    tvResult.setText("Code: " + response.code());
                    return;
                }

                People postResponse = response.body();

                String content = "";
                content += "ID: " + postResponse.getId() + "\n";
                content += "Name: " + postResponse.getName() + "\n";
                content += "Job: " + postResponse.getJob() + "\n";
                content += "createdAt: " + postResponse.getCreatedAt() + "\n\n";

                tvResult.setText(content);
            }

            @Override
            public void onFailure(Call<People> call, Throwable t) {

            }
        });
    }
}
