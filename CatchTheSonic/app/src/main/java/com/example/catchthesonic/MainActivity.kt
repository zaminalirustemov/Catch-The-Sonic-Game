package com.example.catchthesonic

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.catchthesonic.databinding.ActivityMainBinding
import java.util.Random


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var score = 0
    var imageArray = ArrayList<ImageView>()
    var runnable = Runnable {}
    var handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)
        imageArray.add(binding.imageView10)

        hideImage()

        object : CountDownTimer(15900, 1000) {
            override fun onTick(p0: Long) {
                binding.textViewTime.text = "Zaman: ${p0 / 1000} saniyə"
            }

            override fun onFinish() {
                binding.textViewTime.text = "Zaman: 0 saniyə"
                handler.removeCallbacks(runnable)

                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                val intent = Intent(this@MainActivity, ScoreActivity::class.java)
                finish()
                intent.putExtra("score",score)
                startActivity(intent)
            }

        }.start()
    }

    fun increaseScore(view: View) {
        for (image in imageArray) {
            image.visibility = View.INVISIBLE
        }
        score += 1
        binding.textViewScore.text = "Xal: ${score}"
    }

    fun hideImage() {
        runnable = object : Runnable {
            override fun run() {
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                val random = Random()
                val randomIndex = random.nextInt(9)
                imageArray[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable, 300)
            }
        }
        handler.post(runnable)
    }
}