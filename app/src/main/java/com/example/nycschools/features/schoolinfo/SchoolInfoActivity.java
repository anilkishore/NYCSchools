package com.example.nycschools.features.schoolinfo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.nycschools.R;
import com.example.nycschools.data.model.SchoolProfile;
import com.example.nycschools.data.model.SchoolSATScores;
import com.example.nycschools.viewmodel.SATScoresViewModel;

public class SchoolInfoActivity extends AppCompatActivity {

    public final static String EXTRA_SCHOOL_PROFILE = "SCHOOL_PROFILE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.school_info);

        @NonNull final SchoolProfile schoolProfile =
                (SchoolProfile) getIntent().getSerializableExtra(EXTRA_SCHOOL_PROFILE);

        ((TextView) findViewById(R.id.name)).setText(schoolProfile.getSchoolName());
        ((TextView) findViewById(R.id.city)).setText(schoolProfile.getCity());
        ((TextView) findViewById(R.id.email)).setText(schoolProfile.getSchoolEmail());
        ((TextView) findViewById(R.id.description)).setText("<b>About</b>: \n" + schoolProfile.getOverviewParagraph());

        SATScoresViewModel viewModel = new ViewModelProvider(this).get(SATScoresViewModel.class);
        LiveData<SchoolSATScores> satScores = viewModel.getSATScores(schoolProfile);
        satScores.observe(this, new Observer<SchoolSATScores>() {
            @Override
            public void onChanged(@Nullable SchoolSATScores scores) {
                StringBuilder sb = new StringBuilder("");
                if (scores != null) {
                    if (scores.getNumOfSatTestTakers() != null) {
                        sb.append("Number of test takers: " + scores.getNumOfSatTestTakers() +
                                "\n");
                    }
                    if (scores.getSatMathAvgScore() != null) {
                        sb.append("Math avg score: " + scores.getSatMathAvgScore() + "\n");
                    }
                    if (scores.getSatWritingAvgScore() != null) {
                        sb.append("Writing avg score: " + scores.getSatWritingAvgScore() + "\n");
                    }
                    if (scores.getSatCriticalReadingAvgScore() != null) {
                        sb.append("Critical reading avg score: " + scores.getSatCriticalReadingAvgScore() + "\n");
                    }
                }

                ((TextView) findViewById(R.id.scores_text)).setText("\n~~~ SAT scores ~~~ \n" + sb);
            }
        });
    }
}
