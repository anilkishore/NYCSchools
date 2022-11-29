package com.example.nycschools.data.api;

import com.example.nycschools.data.model.SchoolProfile;
import com.example.nycschools.data.model.SchoolSATScores;

import java.util.List;

public interface ApiService {

    String PROFILES_URL = "https://data.cityofnewyork.us/resource/s3k6-pzi2.json";
    String SCORES_URL = "https://data.cityofnewyork.us/resource/f9bf-2cp4.json";

    interface ApiCallback<T> {
        void onLoadSuccess(T result);
    }

    void fetchSchoolProfilesList(ApiCallback<List<SchoolProfile>> callback);

    void fetchSchoolSATScore(ApiCallback<List<SchoolSATScores>> callback);
}
