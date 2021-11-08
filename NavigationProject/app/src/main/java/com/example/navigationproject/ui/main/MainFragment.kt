    package com.example.navigationproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationproject.R
import com.example.navigationproject.databinding.MainFragmentBinding
import androidx.navigation.Navigation

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
        // TODO: Use the ViewModel
        binding.button1.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_firstPicture)
        }
        binding.button2.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_secondPicture)
        }
        binding.button3.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_thirdPicture)
        }
    }

}