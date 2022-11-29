package com.example.nycschools.features.schoollist;

import static com.example.nycschools.features.schoolinfo.SchoolInfoActivity.EXTRA_SCHOOL_PROFILE;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nycschools.R;
import com.example.nycschools.data.model.SchoolProfile;
import com.example.nycschools.features.schoolinfo.SchoolInfoActivity;

public class SchoolProfileViewHolder extends RecyclerView.ViewHolder {
    public SchoolProfileViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    void bind(SchoolProfile schoolProfile) {
        ((TextView) itemView.findViewById(R.id.name)).setText(schoolProfile.getSchoolName());
        ((TextView) itemView.findViewById(R.id.city)).setText(schoolProfile.getCity());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, SchoolInfoActivity.class);
                intent.putExtra(EXTRA_SCHOOL_PROFILE, schoolProfile);
                context.startActivity(intent);
            }
        });
    }
}
