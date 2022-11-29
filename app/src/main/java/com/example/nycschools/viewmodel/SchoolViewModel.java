package com.example.nycschools.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.nycschools.data.model.SchoolProfile;
import com.example.nycschools.data.repository.SchoolRepository;

import java.util.List;

/**
 * ViewModel for an item in the list view that shows list of schools. This is the bridge between
 * ui components and data sources and has longer life as compared to app components. Eg. this
 * is retained through screen rotations.
 */
public class SchoolViewModel extends AndroidViewModel {

    private final SchoolRepository mSchoolRepository;
    private final LiveData<List<SchoolProfile>> mSchools;

    public SchoolViewModel(@NonNull Application application) {
        super(application);
        mSchoolRepository = SchoolRepository.getInstance(application.getApplicationContext());
        mSchools = mSchoolRepository.getSchoolProfiles();
    }

    public LiveData<List<SchoolProfile>> getSchools() {
        return mSchools;
    }
}
