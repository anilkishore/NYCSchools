package com.example.nycschools.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.nycschools.data.model.SchoolSATScores;

import java.util.List;

@Dao
public interface SchoolSATScoresDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<SchoolSATScores> scores);

    @Transaction
    @Query("SELECT * FROM school_scores_table where dbn = :schoolDBN")
    LiveData<SchoolSATScores> getScores(String schoolDBN);
}
