package com.example.warehouse.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EMPLOYEE_TABLE")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "employee_id")
    var id: Int,
    @ColumnInfo(name = "employee_name")
    var name: String,
    @ColumnInfo(name = "employee_lastname")
    var lastName: String,
    @ColumnInfo(name = "employee_department")
    var department: String,
)