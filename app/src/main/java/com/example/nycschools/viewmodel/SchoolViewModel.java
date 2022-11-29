package com.example.nycschools.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.nycschools.data.model.SchoolProfile;
import com.example.nycschools.data.repository.SchoolRepository;

import java.util.List;

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
