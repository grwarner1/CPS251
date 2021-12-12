package com.ebookfrenzy.roomdemo

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "contactId")
    var id: Int = 0

    @ColumnInfo(name = "contactName")
    var contactName: String? = null

    @ColumnInfo(name = "phoneNumber")
    var phoneNumber: String? = null

    constructor() {}

    constructor(id: Int, contactname: String, phonenumber: String) {
        this.contactName = contactname
        this.phoneNumber = phonenumber
    }
    constructor(contactname: String, phonenumber: String) {
        this.contactName = contactname
        this.phoneNumber = phonenumber
    }
}