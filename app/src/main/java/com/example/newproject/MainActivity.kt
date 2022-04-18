package com.example.newproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newproject.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private  val TAG = "MainActivity"
    lateinit var retrofit: Retrofit
    lateinit var reccyclerAdapter: ReccyclerAdapter
    lateinit var arrayList: ArrayList<CommentsItem>
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        retrofit= Retrofit()
        arrayList= ArrayList()
        reccyclerAdapter=ReccyclerAdapter(arrayList)
        linearLayoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recyclerview.adapter=reccyclerAdapter
        binding.recyclerview.layoutManager=linearLayoutManager


    }

    fun gotinextactivity(view: View){
       startActivity(Intent(this,MainActivity2::class.java))
    }

    fun getUsers(view: View) {
        retrofit.retroInterface.getUsers().enqueue(object : Callback<Comments> {
            override fun onResponse(call: Call<Comments>, response: Response<Comments>) {
               Log.e(TAG, "response ${response.body()} ")
                response.body()?.let {
                    var comments : Comments = it
                    arrayList.addAll(comments)
                    reccyclerAdapter.notifyDataSetChanged()
                }

            }

            override fun onFailure(call: Call<Comments>, t: Throwable) {
                Log.e(TAG, "response $t ")
            }
        })

        retrofit.retroInterface.getSingleUserDetails(100).enqueue(object : Callback<UserResponseItem> {
            override fun onResponse(call: Call<UserResponseItem>, response: Response<UserResponseItem>) {
                Log.e(TAG, "response ${response.body()} ")
                response.body()?.let {

                }

            }

            override fun onFailure(call: Call<UserResponseItem>, t: Throwable) {
                Log.e(TAG, "response $t ")
            }
        })
    }
}