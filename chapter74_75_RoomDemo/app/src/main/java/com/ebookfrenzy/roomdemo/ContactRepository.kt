package com.ebookfrenzy.roomdemo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application) {

    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts: LiveData<List<Contact>>?

    init {
        val db: ContactRoomDatabase? =
            ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContacts()
    }

    fun insertContact(newcontact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newcontact)
        }
    }

    private suspend fun asyncInsert(contact: Contact) {
        contactDao?.insertContact(contact)
    }

    fun deleteContact(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(id)
        }
    }

    private suspend fun asyncDelete(id: Int) {
        contactDao?.deleteContact(id)
    }

    fun findContact(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }

    private suspend fun asyncFind(name: String): Deferred<List<Contact>?> =

        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.findContacts(name)
        }

    fun sortAsc() {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncAsc()?.await()
        }
    }

    private suspend fun asyncAsc(): Deferred<List<Contact>>? =

        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.getContactsASC()!!
        }

    fun sortDesc() {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncDesc()?.await()
        }
    }

    private suspend fun asyncDesc(): Deferred<List<Contact>>? =

        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.getContactsDESC()!!
        }
}