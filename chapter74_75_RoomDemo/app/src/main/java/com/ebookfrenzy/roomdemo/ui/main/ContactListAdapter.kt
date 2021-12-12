package com.ebookfrenzy.roomdemo.ui.main

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.roomdemo.Contact
import com.ebookfrenzy.roomdemo.R

class ContactListAdapter(private val ContactItemLayout: Int) :
    RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null

    var listener: OnItemClickListener? = null

    fun settingListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    interface OnItemClickListener{
        fun onClick(str: String)
    }

    override fun onBindViewHolder(viewHolder: ContactListAdapter.ViewHolder, listPosition: Int) {

        val contactName = viewHolder.contactName
        val contactPhone = viewHolder.contactPhone
        val contactId = viewHolder.contactId
        var deleteButton: ImageButton = viewHolder.deleteButton

        contactList.let {
            contactName!!.text = it!![listPosition].contactName
            contactPhone!!.text = it[listPosition].phoneNumber
            contactId!!.text = it[listPosition].id.toString()
        }

        deleteButton.setOnClickListener( View.OnClickListener {
            var id = contactId.text.toString()
            listener?.onClick(id)
        })

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(ContactItemLayout, parent, false)
        return ViewHolder(view)
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var contactName: TextView = itemView.findViewById(R.id.ContactNameText)
        var contactPhone: TextView = itemView.findViewById(R.id.textView2)
        var contactId: TextView = itemView.findViewById(R.id.id)
        var deleteButton: ImageButton = itemView.findViewById(R.id.deleteButton)

    }
}