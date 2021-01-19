package com.raeandres.cartrackapp.common.data.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.raeandres.cartrackapp.common.data.persistence.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class CarTrackDatabase() : RoomDatabase() {

    abstract fun userDao(): UserDao

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
                        "cartrack_db")
                        .build()
                instance = roomInstance
                return roomInstance
            }
        }
    }
}