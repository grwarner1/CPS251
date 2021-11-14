package com.ebookfrenzy.carddemo

val titles = arrayOf("Chapter One",
    "Chapter Two", "Chapter Three", "Chapter Four",
    "Chapter Five", "Chapter Six", "Chapter Seven",
    "Chapter Eight")

val details = arrayOf("Item one details", "Item two details",
    "Item three details", "Item four details",
    "Item five details", "Item six details",
    "Item seven details", "Item eight details")

val images = intArrayOf(R.drawable.android_image_1,
    R.drawable.android_image_2, R.drawable.android_image_3,
    R.drawable.android_image_4, R.drawable.android_image_5,
    R.drawable.android_image_6, R.drawable.android_image_7,
    R.drawable.android_image_8)

class Data {

    companion object{
        fun getTitles(): Array<String>{
            val size = titles.size-1

            var out: ArrayList<String> = ArrayList<String>()

            for(i in 0..size) {
                out.add(titles[(0..size).random()])
            }

            return out.toTypedArray()
        }

        fun getDetails(): Array<String>{
            val size = details.size-1

            var out: ArrayList<String> = ArrayList<String>()

            for(i in 0..size) {
                out.add(details[(0..size).random()])
            }

            return out.toTypedArray()
        }

        fun getImages(): IntArray{
            val size = images.size

            var out: ArrayList<Int> = ArrayList<Int>()

            for(i in 0..size) {
                out.add(images[(0..size).random()])
            }

            return out.toIntArray()
        }
    }

}