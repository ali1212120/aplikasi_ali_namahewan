package com.projek.aplikasi_ali_namahewan

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    object musikBg{
        var mediaPlayer : MediaPlayer? = null
        var kondisi : String = "nyala"
        fun start(context: Context){
            if (mediaPlayer == null){
                mediaPlayer = MediaPlayer.create(context,R.raw.bgmusik)
                mediaPlayer?.isLooping = true
                mediaPlayer?.start()
            }
        }

        fun stop() {
            if (mediaPlayer != null) {
                mediaPlayer!!.stop()
                mediaPlayer!!.release()
                mediaPlayer = null
            }
        }


    }

    private lateinit var buttonMusik: Button
    private lateinit var mediaPlayer: MediaPlayer


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tampilan_menu)
        supportActionBar!!.hide()


        val btnBelajar: Button = findViewById(R.id.buttonBelajar)
        val btnQuiz: Button = findViewById(R.id.buttonKuis)

//        btn musik
        buttonMusik = findViewById(R.id.buttonMusik)
        mediaPlayer = MediaPlayer.create(this, R.raw.klik) // ganti sesuai file kamu

        musikBg.kondisi = ambilKondisiMusik()

        if (musikBg.kondisi == "nyala") {
            musikBg.start(this@MenuActivity)
            buttonMusik.setBackgroundResource(R.drawable.volume)
        } else {
            buttonMusik.setBackgroundResource(R.drawable.silent)
        }

        buttonMusik.setOnClickListener {
            mediaPlayer.start() // kalau tidak perlu, bisa hapus baris ini
            if (musikBg.kondisi == "nyala") {
                musikBg.stop()
                musikBg.kondisi = "mati"
                buttonMusik.setBackgroundResource(R.drawable.silent)
                simpanKondisiMusik("mati")
            } else {
                musikBg.start(this@MenuActivity)
                musikBg.kondisi = "nyala"
                buttonMusik.setBackgroundResource(R.drawable.volume)
                simpanKondisiMusik("nyala")
            }
        }


        btnBelajar.setOnClickListener {
            mediaPlayer.start()
            val intent = Intent(this, BelajarActivity::class.java)
            startActivity(intent)
        }

        btnQuiz.setOnClickListener {
            mediaPlayer.start()
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }

    }

    private fun simpanKondisiMusik(kondisi: String) {
        val pref = getSharedPreferences("mypref", MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("kondisiMusik", kondisi)
        editor.apply()
    }

    private fun ambilKondisiMusik(): String {
        val pref = getSharedPreferences("mypref", MODE_PRIVATE)
        return pref.getString("kondisiMusik", "nyala") ?: "nyala"
    }
}