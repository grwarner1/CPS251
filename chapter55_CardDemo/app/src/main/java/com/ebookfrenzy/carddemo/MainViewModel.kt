package com.ebookfrenzy.carddemo

import androidx.lifecycle.ViewModel

var detailsList: Array<String>? = null
var titlesList: Array<String>? = null
var imagesList: IntArray? = null

class MainViewModel: ViewModel() {

    companion object {
        fun scrambleData() {
            titlesList = Data.getTitles()
            detailsList = Data.getDetails()
            imagesList = Data.getImages()
        }

        fun getImagesList(): IntArray{
            return imagesList!!
        }

        fun getTitlesList(): Array<String>{
            return titlesList!!
        }

        fun getDetailsList(): Array<String>{
            return detailsList!!
        }

        fun isNull(): Boolean{
            return detailsList.isNullOrEmpty()
        }
    }
}