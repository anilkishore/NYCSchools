package com.example.nycschools.data.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.nycschools.data.api.ApiService;
import com.example.nycschools.data.api.NetworkService;
import com.example.nycschools.data.db.SchoolDatabase;
import com.example.nycschools.data.db.SchoolProfileDao;
import com.example.nycschools.data.db.SchoolSATScoresDao;
import com.example.nycschools.data.model.SchoolProfile;
import com.example.nycschools.data.model.SchoolSATScores;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SchoolRepository {

    private SchoolProfileDao mSchoolProfileDao;
    private SchoolSATScoresDao mSchoolSATScoresDao;
    private ApiService mNetworkService = new NetworkService();
    private LiveData<List<SchoolProfile>> mSchoolProfiles;
    private ExecutorService mBgExecutorService = Executors.newSingleThreadExecutor();

    private static volatile SchoolRepository INSTANCE;

    private SchoolRepository(Context context) {
        SchoolDatabase db = SchoolDatabase.getInstance(context);
        mSchoolProfileDao = db.schoolProfileDao();
        mSchoolSATScoresDao = db.schoolSATScoresDao();
        mSchoolProfiles = mSchoolProfileDao.getSchools();

        fetchSchoolProfiles();
        fetchSchoolSATScores();
    }

    public static SchoolRepository getInstance(Context context) {
        SchoolRepository repository = INSTANCE;
        if (repository == null) {
            synchronized (SchoolRepository.class) {
                repository = INSTANCE;
                if (repository == null) {
                    INSTANCE = new SchoolRepository(context);
                }
            }
        }
        return INSTANCE;
    }

    public LiveData<List<SchoolProfile>> getSchoolProfiles() {
        return mSchoolProfiles;
    }

    public LiveData<SchoolSATScores> getSchoolSATScores(SchoolProfile schoolProfile) {
        return mSchoolSATScoresDao.getScores(schoolProfile.getDbn());
    }

    public void fetchSchoolProfiles() {
        mNetworkService.fetchSchoolProfilesList(new ApiService.ApiCallback<List<SchoolProfile>>() {
            @Override
            public void onLoadSuccess(List<SchoolProfile> result) {
                mBgExecutorService.execute(() -> mSchoolProfileDao.insertAll(result));
            }
        });
    }

    public void fetchSchoolSATScores() {
        mNetworkService.fetchSchoolSATScore(new ApiService.ApiCallback<List<SchoolSATScores>>() {
            @Override
            public void onLoadSuccess(List<SchoolSATScores> result) {
                mBgExecutorService.execute(() -> mSchoolSATScoresDao.insertAll(result));
            }
        });
    }
}
