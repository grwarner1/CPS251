package com.example.addnamesavedata.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var resultText = ""

    fun addName(input: String) {
        resultText += input + "\n"
    }

    fun getResult(): String {
        return resultText
    }
}