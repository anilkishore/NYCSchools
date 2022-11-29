package com.example.nycschools.data.api;

import com.example.nycschools.data.model.SchoolProfile;
import com.example.nycschools.data.model.SchoolSATScores;

import java.util.List;

/**
 * Interface for client-server interaction for making network requests and getting back response.
 * This can be used to abstract data sources, but for now used only for network loads.
 */
public interface ApiService {

    String PROFILES_URL = "https://data.cityofnewyork.us/resource/s3k6-pzi2.json";
    String SCORES_URL = "https://data.cityofnewyork.us/resource/f9bf-2cp4.json";

    /**
     * Callback on result of the service
     */
    interface ApiCallback<T> {

        /**
         * @param result parsed response in a format for direct consumption on successful load
         */
        void onLoadSuccess(T result);
    }

    /**
     * Fetch list of school profile and make a callback on the result
     */
    void fetchSchoolProfilesList(ApiCallback<List<SchoolProfile>> callback);

    /**
     * Fetch SAT scores of all the schools and make a callback on the result
     */
    void fetchSchoolSATScore(ApiCallback<List<SchoolSATScores>> callback);
}
