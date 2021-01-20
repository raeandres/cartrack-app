package com.raeandres.cartrackapp.common.data.real.persistence.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_country")
data class Country(
	@NonNull
	@ColumnInfo(name = "flag")
	val flag: String,
	@ColumnInfo(name = "code")
	val code: String,
	@PrimaryKey
	@NonNull
	@ColumnInfo(name = "dialCode")
	val dialCode: String,
	@NonNull
	@ColumnInfo(name = "name")
	val name: String
)


