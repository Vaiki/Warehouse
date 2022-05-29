package com.example.warehouse.presentation.viewModels

import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.warehouse.model.data.Employee
import com.example.warehouse.model.data.EmployeeRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class EmployeeViewModel(private val employeeRepository: EmployeeRepository) : ViewModel(),
    Observable {


    private lateinit var employeeToUpdateOrDelete: Employee
    val employees = employeeRepository.employees


    @Bindable
    val inputName = MutableLiveData<String?>()

    @Bindable
    val inputLastName = MutableLiveData<String?>()

    @Bindable
    val inputDepartment = MutableLiveData<String?>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()

    



    private fun insert(employee: Employee): Job =
        viewModelScope.launch { employeeRepository.insert(employee) }


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    fun initUpdateOrSave(employee: Employee) {
        inputName.value = employee.name
        inputLastName.value = employee.lastName
        inputDepartment.value = employee.department

        employeeToUpdateOrDelete = employee
        saveOrUpdateButtonText.value = "Update"

    }


}