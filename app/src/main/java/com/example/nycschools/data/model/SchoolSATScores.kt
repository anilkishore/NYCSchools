package com.example.nycschools.data.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "school_scores_table")
data class SchoolSATScores(

    @PrimaryKey @NonNull @ColumnInfo(name = "dbn") @SerializedName("dbn") val dbn: String,

    @SerializedName("num_of_sat_test_takers") val numOfSatTestTakers: String?,

    @SerializedName("sat_critical_reading_avg_score") val satCriticalReadingAvgScore: String?,

    @SerializedName("sat_math_avg_score") val satMathAvgScore: String?,

    @SerializedName("sat_writing_avg_score") val satWritingAvgScore: String?,

    @SerializedName("school_name") val schoolName: String
)