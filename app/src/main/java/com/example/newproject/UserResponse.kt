package com.example.newproject


import com.google.gson.annotations.SerializedName

class UserResponse : ArrayList<UserResponseItem>()

    data class UserResponseItem(
        @SerializedName("email")
        val email: String = "",
        @SerializedName("gender")
        val gender: String = "",
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("name")
        val name: String = "",
        @SerializedName("status")
        val status: String = ""
    )
