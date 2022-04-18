package com.example.newproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.newproject.databinding.ActivityMain2Binding
import com.example.newproject.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {
    lateinit var retrofit:Retrofit
    lateinit var emails:String
    lateinit var names:String
    lateinit var gender:String
    lateinit var status:String
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main2)
        retrofit= Retrofit()
        emails=binding.email.toString().trim()
        names=binding.name.toString().trim()
        gender=binding.gender.toString().trim()
        status=binding.status.toString().trim()

    }
    fun CreateUser(view: View) {
        if (TextUtils.isEmpty(binding.email.toString())&&TextUtils.isEmpty(binding.name.toString())&&TextUtils.isEmpty(binding.gender.toString())&&TextUtils.isEmpty(binding.status.toString())){
            Toast.makeText(this,"All Fields are Required",Toast.LENGTH_LONG).show()
        }
        else {
            retrofit.retroInterface.createUser(
                "Bearer 3ee949f72c6f36c0d90a9cb2b4cbcb91176626fcbf387a2daa2894750686de9e",
                mapOf(
                    "email" to
                            emails, "name" to names, "gender" to gender, "status" to status
                )
            ).enqueue(
                object : Callback<UserResponseItem> {
                    override fun onResponse(
                        call: Call<UserResponseItem>,
                        response: Response<UserResponseItem>
                    ) {
                        Log.e("TAG", " in success")
                        Toast.makeText(
                            this@MainActivity2,
                            " User created successfully",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    override fun onFailure(call: Call<UserResponseItem>, t: Throwable) {
                        Toast.makeText(
                            this@MainActivity2,
                            "in error ${t.toString()}",
                            Toast.LENGTH_LONG
                        ).show()
                        Log.e("TAG", " in error")

                    }
                }
            )
        }
    }

}