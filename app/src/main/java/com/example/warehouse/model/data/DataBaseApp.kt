package com.example.warehouse.model.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Employee::class], version = 1)
abstract class DataBaseApp : RoomDatabase() {
    abstract val employeeDao: EmployeeDao

    companion object {
        @Volatile
        private var INSTANCE: DataBaseApp? = null
        fun getInstance(context: Context): DataBaseApp {
            synchronized(this) {
                var instance: DataBaseApp? = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataBaseApp::class.java,
                        "APP_DATABASE"
                    ).build()
                }
                return instance
            }
        }
    }
}