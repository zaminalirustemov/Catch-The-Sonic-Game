package com.example.catchthesonic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun startGame(view: View){
        val intent = Intent(this@HomeActivity, MainActivity::class.java)
        startActivity(intent)
    }
}