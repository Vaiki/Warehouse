package com.example.warehouse.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.warehouse.DataBinderMapperImpl
import com.example.warehouse.R
import com.example.warehouse.databinding.FragmentPersonBinding



class PersonFragment : Fragment() {
    lateinit var binding: FragmentPersonBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_person,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }


}