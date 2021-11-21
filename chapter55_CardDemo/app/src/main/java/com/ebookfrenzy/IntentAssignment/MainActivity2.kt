package com.ebookfrenzy.IntentAssignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.IntentAssignment.databinding.ActivityMain2Binding

import android.graphics.Canvas

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)

        setContentView(binding.root)

        val extras = intent.extras ?: return

        binding.itemName.text = extras.getString("itemName")
        binding.itemDetails.text = extras.getString("itemDesc")
        binding.imageView.setImageResource(extras.getInt("image"))
    }
}