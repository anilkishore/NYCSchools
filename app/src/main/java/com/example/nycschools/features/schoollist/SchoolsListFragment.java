package com.example.nycschools.features.schoollist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nycschools.R;
import com.example.nycschools.viewmodel.SchoolViewModel;

/**
 * This fragment hosts the initial list of schools and is shown on App startup and hence is
 * important to keep things light-weight for better startup performance.
 */
public class SchoolsListFragment extends Fragment {

    public static final String TAG = "SchoolListFragment";

    private SchoolViewModel mSchoolValueModel;
    private SchoolsListAdapter mSchoolsListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSchoolsListAdapter = new SchoolsListAdapter();
        mSchoolValueModel = new ViewModelProvider(this).get(SchoolViewModel.class);
        mSchoolValueModel.getSchools().observe(this,
                schoolProfiles -> mSchoolsListAdapter.setSchoolProfiles(schoolProfiles));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mSchoolsListAdapter = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_school_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.list_content);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mSchoolsListAdapter);
        return view;
    }
}
