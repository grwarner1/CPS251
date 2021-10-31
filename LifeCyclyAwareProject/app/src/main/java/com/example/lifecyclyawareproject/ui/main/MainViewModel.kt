package com.example.lifecyclyawareproject.ui.main

import androidx.lifecycle.ViewModel

var currentText = "Nothing to View"

class MainViewModel : ViewModel() {

    companion object {
        fun addData(input: String) {
            if(currentText == "Nothing to View"){
                currentText = ""
            }
            currentText += input
        }
    }

    fun getData(): String {
        return currentText
    }
}