package com.example.navproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navproject.databinding.MainFragmentBinding
import androidx.navigation.Navigation
import com.example.navproject.R

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.button1.setOnClickListener {
            val action: MainFragmentDirections.ActionMainFragmentToFirstPicture =
                MainFragmentDirections.actionMainFragmentToFirstPicture()
            action.image = R.drawable.android_image_1
            action.message = "Image 1"
            Navigation.findNavController(it).navigate(action)
        }
        binding.button2.setOnClickListener {
            val action: MainFragmentDirections.ActionMainFragmentToFirstPicture =
                MainFragmentDirections.actionMainFragmentToFirstPicture()
            action.image = R.drawable.android_image_2
            action.message = "Image 2"
            Navigation.findNavController(it).navigate(action)
        }
        binding.button3.setOnClickListener {
            val action: MainFragmentDirections.ActionMainFragmentToFirstPicture =
                MainFragmentDirections.actionMainFragmentToFirstPicture()
            action.image = R.drawable.android_image_3
            action.message = "Image 3"
            Navigation.findNavController(it).navigate(action)
        }

    }

}