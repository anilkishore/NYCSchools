package com.example.nycschools.data.api;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.nycschools.data.model.SchoolProfile;
import com.example.nycschools.data.model.SchoolSATScores;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Actual implementation of the network service to load data from server using OkHttp library
 */
public class NetworkService implements ApiService {

    private static final String TAG = "NetworkService";

    @Override
    public void fetchSchoolProfilesList(ApiCallback<List<SchoolProfile>> callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(PROFILES_URL).build();
        try {
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.w(TAG, "Failed to get network result for #fetchSchoolProfilesList");
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    String jsonResponse = response.body().string();
                    Gson gson = new GsonBuilder().create();
                    Type schoolListType = new TypeToken<List<SchoolProfile>>() {
                    }.getType();
                    List<SchoolProfile> schoolProfiles = gson.fromJson(jsonResponse,
                            schoolListType);
                    callback.onLoadSuccess(schoolProfiles);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fetchSchoolSATScore(ApiCallback<List<SchoolSATScores>> callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(SCORES_URL).build();
        try {
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.w(TAG, "Failed to get network result for #fetchSchoolSATScore");
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    String jsonResponse = response.body().string();
                    Gson gson = new GsonBuilder().create();
                    Type scoresType = new TypeToken<List<SchoolSATScores>>() {
                    }.getType();
                    List<SchoolSATScores> scores = gson.fromJson(jsonResponse, scoresType);
                    callback.onLoadSuccess(scores);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
