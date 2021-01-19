package com.raeandres.cartrackapp.common.data.persistence.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_login")
data class User(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "user_name")
    val username: String,

    @NonNull
    @ColumnInfo(name = "password")
    val password: String
)