package com.projek.aplikasi_ali_namahewan

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HasilQuizActivity : AppCompatActivity() {
    lateinit var tvNama : TextView
    lateinit var tvTotalBenar : TextView
    lateinit var tvTotalScore : TextView
    lateinit var tvTotalSalah : TextView
    lateinit var btnMenu : Button
    lateinit var mediaPlayer : MediaPlayer

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tampilan_hasil_kuiz)
        supportActionBar!!.hide()
        tvTotalBenar = findViewById(R.id.tvTotalBenar)
        tvTotalScore = findViewById(R.id.tvScore)
        tvTotalSalah = findViewById(R.id.tvTotalSalah)
        btnMenu = findViewById(R.id.btnmenu)
//        var song : MediaPlayer = MediaPlayer.create(this,R.raw.victory)
//        song.start()

        val score = intent.getStringExtra("score")
        val totalBenar = intent.getStringExtra("benar")
        val totalSalah = intent.getStringExtra("salah")
        tvTotalScore.text = score
        tvTotalBenar.text = totalBenar
        tvTotalSalah.text = totalSalah
        btnMenu.setOnClickListener{
            mediaPlayer = MediaPlayer.create(this,R.raw.klik)
            mediaPlayer.start()
            btnMenu.animate()
                .scaleX(0.85f)
                .scaleY(0.85f)
                .setDuration(200)
                .withEndAction {
                    btnMenu.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .duration = 200
                }
            val intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}