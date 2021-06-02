package com.example.intentdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_secondactivity.*

class Secondactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondactivity)
//        val name=intent.getStringExtra("EXTRA_NAME")
//        val age=intent.getIntExtra("EXTRA_AGE",9)
//        val country=intent.getStringExtra("EXTRA_COUNTRY")


        //Passing classes between activity
        val person=intent.getSerializableExtra("EXTRA_PERSON") as Person
        tvPerson.text=person.toString()
    }
}