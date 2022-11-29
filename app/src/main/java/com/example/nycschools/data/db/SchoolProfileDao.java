package com.example.nycschools.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.nycschools.data.model.SchoolProfile;

import java.util.List;

/**
 * Data access object for school profiles DB table based on the AndroidX Room architecture component
 */
@Dao
public interface SchoolProfileDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(List<SchoolProfile> schoolProfile);

    @Transaction
    @Query("SELECT * from school_profiles_table ORDER BY school_name ASC")
    LiveData<List<SchoolProfile>> getSchools();
}
