package com.raeandres.cartrackapp.common.data.real.persistence.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
	@ColumnInfo(name = "website")
	val website: String?,
	@ColumnInfo(name = "address")
	val address: String?,
	@ColumnInfo(name = "phone")
	val phone: String?,
	@ColumnInfo(name = "name")
	val name: String?,
	@ColumnInfo(name = "user_company")
	val company: String?,
	@ColumnInfo(name = "email")
	val email: String?,
//	@ForeignKey
	@NonNull
	@ColumnInfo(name = "user_name")
	val username: String?,
	@PrimaryKey
	@NonNull
	@ColumnInfo(name = "id")
	val id: Int
)

@Entity(tableName = "user_address")
data class Address(
    @ColumnInfo(name = "zip_code")
	val zipcode: String?,
    @ColumnInfo(name = "geo")
	val geo: Geo?,
    @ColumnInfo(name = "suite")
	val suite: String?,
    @ColumnInfo(name = "city")
	val city: String?,
    @ColumnInfo(name = "street")
	val street: String?
)

@Entity(tableName = "user_location")
data class Geo(
	@ColumnInfo(name = "lng")
	val lng: String?,
	@ColumnInfo(name = "lat")
	val lat: String?
)

@Entity(tableName = "user_company")
data class Company(
	@ColumnInfo(name ="bs")
	val bs: String?,
	@ColumnInfo(name = "catch_phrase")
	val catchPhrase: String?,
	@ColumnInfo(name ="name")
	val name: String?
)

