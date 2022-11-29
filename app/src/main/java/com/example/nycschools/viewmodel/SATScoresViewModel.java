package com.example.nycschools.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.nycschools.data.model.SchoolProfile;
import com.example.nycschools.data.model.SchoolSATScores;
import com.example.nycschools.data.repository.SchoolRepository;

/**
 * ViewModel for SAT scores of a particular school. This is the bridge between
 * ui components and data sources and has longer life as compared to app components. Eg. this
 * is retained through screen rotations.
 */
public class SATScoresViewModel extends AndroidViewModel {

    private final SchoolRepository mSchoolRepository;

    public SATScoresViewModel(@NonNull Application application) {
        super(application);
        mSchoolRepository = SchoolRepository.getInstance(application.getApplicationContext());
    }

    public LiveData<SchoolSATScores> getSATScores(SchoolProfile schoolProfile) {
        return mSchoolRepository.getSchoolSATScores(schoolProfile);
    }
}
