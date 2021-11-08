package com.example.navproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import com.example.navproject.ui.main.MainFragment

class MainActivity : AppCompatActivity(), first_picture.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    override fun onFragmentInteraction(uri: Uri) {
    }
}