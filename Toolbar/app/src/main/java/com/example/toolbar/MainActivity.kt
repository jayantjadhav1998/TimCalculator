package com.example.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.icaddContact->Toast.makeText(this,"You clicked on add contact",Toast.LENGTH_SHORT).show()
            R.id.icFavoriate->Toast.makeText(this,"You clicked on add favoriate",Toast.LENGTH_SHORT).show()
            R.id.icSettings->Toast.makeText(this,"You clicked on settings",Toast.LENGTH_SHORT).show()
            R.id.icFeedback->Toast.makeText(this,"You clicked on feedback",Toast.LENGTH_SHORT).show()
            R.id.icClose->finish()

        }
        return true
    }

}