package com.example.catchthesonic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.catchthesonic.databinding.ActivityMainBinding
import com.example.catchthesonic.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val score = intent.getIntExtra("score", 0)
        binding.textViewScoreEnd.text = "Xal: $score"


        val sp = getSharedPreferences("highScore", MODE_PRIVATE)
        val highScore = sp.getInt("highScore", 0)
        if (score > highScore) {
            sp.edit().putInt("highScore", score).apply()
            binding.textViewHighScoreEnd.text = "Ən yüksək xal: $score"
            binding.textViewCongs.visibility = View.VISIBLE
        } else {
            binding.textViewHighScoreEnd.text = "Ən yüksək xal: $highScore"
            binding.textViewCongs.visibility = View.INVISIBLE
        }

        binding.buttonHomePage.setOnClickListener {
            val intent = Intent(this@ScoreActivity, HomeActivity::class.java)
            finish()
            startActivity(intent)
        }

        binding.buttonAgainGame.setOnClickListener {
            val intent = Intent(this@ScoreActivity, MainActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}