package com.raeandres.cartrackapp.common.data.real.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.raeandres.cartrackapp.common.data.fake.persistence.dao.FakeCountryDao
import com.raeandres.cartrackapp.common.data.real.persistence.dao.CountryDao
import com.raeandres.cartrackapp.common.data.real.persistence.dao.LoginDao
import com.raeandres.cartrackapp.common.data.real.persistence.dao.UserDao
import com.raeandres.cartrackapp.common.data.real.persistence.entity.Country
import com.raeandres.cartrackapp.common.data.real.persistence.entity.Login
import com.raeandres.cartrackapp.common.data.real.persistence.entity.User

private const val DB_NAME = "cartrack_db"
private const val DB_VERSION = 1

@Database(entities = [Login::class, User::class, Country::class], version = DB_VERSION, exportSchema = false)
abstract class CarTrackDatabase() : RoomDatabase() {

    abstract fun loginDao(): LoginDao
    abstract fun userDao(): UserDao
    abstract fun countryDao() : CountryDao

    companion object {

        @Volatile
        private var instance: CarTrackDatabase? = null

        fun getDatabase(context: Context) : CarTrackDatabase {

            instance?.let {
                return instance as CarTrackDatabase
            }

            synchronized(this){
                val roomInstance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        CarTrackDatabase::class.java,
                        DB_NAME
                    )
                        .build()
                instance = roomInstance
                return roomInstance
            }
        }
    }

}