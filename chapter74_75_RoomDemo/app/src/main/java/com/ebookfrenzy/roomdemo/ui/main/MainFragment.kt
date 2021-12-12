package com.ebookfrenzy.roomdemo.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.roomdemo.R
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebookfrenzy.roomdemo.Contact
import androidx.fragment.app.viewModels
import com.ebookfrenzy.roomdemo.MainActivity
import android.widget.Toast;
import java.util.*
import com.ebookfrenzy.roomdemo.databinding.MainFragmentBinding
import java.lang.Integer.parseInt

class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listenerSetup()
        observerSetup()
        recyclerSetup()

    }

    private fun listenerSetup() {

        binding.addButton.setOnClickListener {
            val name = binding.name.text.toString()
            val phoneNumber = binding.phone.text.toString()

            if (name != "" && phoneNumber != "") {
                val contact = Contact(name, phoneNumber)
                viewModel.insertContact(contact)
                clearFields()
            } else {
                Toast.makeText((activity as MainActivity?)!!, "Please Enter the Name and Phone Number", Toast.LENGTH_SHORT).show()
            }
        }

        binding.findButton.setOnClickListener {
            viewModel.findContact(binding.name.text.toString())
        }

        binding.ascButton.setOnClickListener {
            viewModel.contactsAsc()
            clearFields()
        }

        binding.descButton.setOnClickListener {
            viewModel.contactsDesc()
            clearFields()
        }
    }

    private fun observerSetup() {

        viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let  {
                adapter?.setContactList(it)
            }
        })

        viewModel.getSearchResults().observe(viewLifecycleOwner, Observer { contacts ->

            contacts?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                } else {
                    Toast.makeText((activity as MainActivity?)!!, "No Records Match Your Search", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.card_layout)
        binding.productListItems.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.productListItems.recyclerView.adapter = adapter

        adapter!!.settingListener(object: ContactListAdapter.OnItemClickListener{
            override fun onClick(id: String) {
                var contactId: Int = parseInt(id)
                viewModel.deleteContact(contactId)
            }
        })
    }

    private fun clearFields() {
        binding.name.setText("")
        binding.phone.setText("")
    }
}