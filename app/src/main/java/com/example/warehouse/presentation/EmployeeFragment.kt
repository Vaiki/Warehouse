package com.example.warehouse.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.warehouse.DataBinderMapperImpl
import com.example.warehouse.R
import com.example.warehouse.databinding.FragmentPersonBinding
import com.example.warehouse.model.data.DataBaseApp
import com.example.warehouse.model.data.EmployeeRepository
import com.example.warehouse.presentation.viewModels.EmployeeViewModel
import com.example.warehouse.presentation.viewModels.EmployeeViewModelFactory


class EmployeeFragment : Fragment() {
    lateinit var binding: FragmentPersonBinding
    lateinit var employeeViewModel: EmployeeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_person, container, false)
        // Inflate the layout for this fragment
        initMenus()
        val dao = DataBaseApp.getInstance((context as FragmentActivity).application).employeeDao
        val repository = EmployeeRepository(dao)
        val factory = EmployeeViewModelFactory(repository)
        employeeViewModel = ViewModelProvider(this, factory)[EmployeeViewModel::class.java]
        binding.employeeViewModel = employeeViewModel
        binding.lifecycleOwner = this
        initMenus()



        return binding.root
    }

    private fun initMenus() {
        val items = listOf("УМТО", "Рудник", "УКС", "УГМ")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item_menus, items)
        binding.autoCompleteTextView.setAdapter(adapter)


    }
}