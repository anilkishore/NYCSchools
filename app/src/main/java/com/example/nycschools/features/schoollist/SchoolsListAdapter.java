package com.example.nycschools.features.schoollist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nycschools.R;
import com.example.nycschools.data.model.SchoolProfile;

import java.util.ArrayList;
import java.util.List;

public class SchoolsListAdapter extends RecyclerView.Adapter<SchoolProfileViewHolder> {

    private List<SchoolProfile> mSchoolProfiles = new ArrayList<>();

    public void setSchoolProfiles(List<SchoolProfile> schoolProfiles) {
        mSchoolProfiles.clear();
        mSchoolProfiles = schoolProfiles;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SchoolProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SchoolProfileViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.school_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolProfileViewHolder holder, int position) {
        holder.bind(mSchoolProfiles.get(position));
    }

    @Override
    public int getItemCount() {
        return mSchoolProfiles.size();
    }
}
