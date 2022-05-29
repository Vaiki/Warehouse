package com.example.warehouse.model.data

class EmployeeRepository(private val employeeDao: EmployeeDao) {

    val employees = employeeDao.getAllEmployee()

    suspend fun insert(employee: Employee) {
        employeeDao.insertEmployee(employee)
    }

    suspend fun update(employee: Employee) {
        employeeDao.updateEmployee(employee)
    }

    suspend fun delete(employee: Employee) {
        employeeDao.deleteEmployee(employee)
    }
}