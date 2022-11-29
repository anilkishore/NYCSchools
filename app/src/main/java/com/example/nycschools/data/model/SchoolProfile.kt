package com.example.nycschools.data.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Simple data model for a school profile
 *
 * Similar to a POJO but in Kotlin to keep it concise and easy to understand. Each of the fields
 * corresponding to JSON fields and also columns in the local DB cache.
 */
@Entity(tableName = "school_profiles_table")
data class SchoolProfile(

    @PrimaryKey
    @NonNull
    @SerializedName("dbn") val dbn: String,

    @SerializedName("city") val city: String?,

    @SerializedName("latitude") val latitude: String?,

    @SerializedName("location") val location: String?,

    @SerializedName("longitude") val longitude: String?,

    @SerializedName("neighborhood") val neighborhood: String?,

    @SerializedName("overview_paragraph") val overviewParagraph: String?,

    @SerializedName("phone_number") val phoneNumber: String?,

    @SerializedName("school_email") val schoolEmail: String?,

    @ColumnInfo(name = "school_name")
    @SerializedName("school_name") val schoolName: String,

    @SerializedName("total_students") val totalStudents: Int?,

    @SerializedName("website") val website: String?,

    @SerializedName("zip") val zip: String
) : Serializable