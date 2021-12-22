package com.example.lab2fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel: ViewModel() {
    val result: MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }
}