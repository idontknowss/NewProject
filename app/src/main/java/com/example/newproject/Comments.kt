package com.example.newproject


import com.google.gson.annotations.SerializedName

class Comments : ArrayList<CommentsItem>()
    data class CommentsItem(
        @SerializedName("body")
        val body: String = "",
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("title")
        val title: String = "",
        @SerializedName("user_id")
        val userId: Int = 0
    )
