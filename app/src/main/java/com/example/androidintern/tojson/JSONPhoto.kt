package com.example.androidintern.tojson

import com.google.gson.annotations.SerializedName

data class JSONPhoto(
    @SerializedName("photos")
    val photos: Photos,
    val stat: String
) {
    data class Photos(
        val page: Int,
        val pages: Int,
        val perpage: Int,
        @SerializedName("photo")
        val photo: List<Photo>,
        val total: Int
    )

    data class Photo(
        @SerializedName("farm")
        val farm: Int,
        @SerializedName("id")
        val id: String,
        val isfamily: Int,
        val isfriend: Int,
        val ispublic: Int,
        val owner: String,
        @SerializedName("secret")
        val secret: String,
        @SerializedName("server")
        val server: String,
        val title: String
    )
}
