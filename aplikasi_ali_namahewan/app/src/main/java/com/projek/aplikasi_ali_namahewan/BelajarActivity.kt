package com.projek.aplikasi_ali_namahewan

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BelajarActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var tvNama: TextView
    private lateinit var tvJenis: TextView
    private lateinit var tvPenjelasan: TextView

    private var cIndex = 0
    private var mediaPlayer: MediaPlayer? = null

    private val images = listOf(
        R.drawable.anjing,
        R.drawable.ayam,
        R.drawable.badak,
        R.drawable.berangberang,
    )

    private val txtName = listOf(
        "Anjing كلب (kalb)",
        "Ayam دجاج (dajāj)",
        "Badak وحيد القرن (Waḥīd al-Qarn)",
        "Berang-Berang قندس (qundus)",
    )

    private val txtJenis = listOf(
        "Karnivora لاحم (Lāḥim)",
        "Omnivora قارت (Qārit)",
        "Herbivora عاشب (ʿĀshib)",
        "Karnivora لاحم (Lāḥim)"
    )

    private val txtPenjelasan = listOf(
        "Anjing adalah hewan peliharaan yang setia. Dia suka makan daging, makanya disebut karnivora. Dalam bahasa Arab, anjing disebut kalb.\n" +
                "➤ Kalimat contoh: Anjing suka menjaga rumah. كلب يحب حراسة البيت.",
        "Ayam adalah hewan yang bisa makan segalanya, mulai dari biji-bijian sampai serangga. Itu sebabnya dia termasuk omnivora. Dalam bahasa Arab, ayam disebut dajāj.\n" +
                "➤ Kalimat contoh: Ayam bertelur setiap hari. الدجاج يبيض كل يوم.",
        "Badak adalah hewan besar yang suka makan tumbuh-tumbuhan. Dia termasuk herbivora. Dalam bahasa Arab, badak disebut Waḥīd al-Qarn, yang artinya \"bercula satu.\"\n" +
                "➤ Kalimat contoh: Badak hidup di hutan. وحيد القرن يعيش في الغابة.",
        "Berang-berang adalah hewan yang suka tinggal di dekat air dan membangun bendungan. Dia makan ikan, jadi termasuk karnivora. Dalam bahasa Arab disebut qundus.\n" +
                "➤ Kalimat contoh: Berang-berang pandai membuat rumah. القندس ماهر في بناء البيوت.",

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tampilan_belajar)
        supportActionBar!!.hide()


        // Inisialisasi view
        imageView = findViewById(R.id.imageView2)
        tvNama = findViewById(R.id.tvNamaHewan)
        tvJenis = findViewById(R.id.tvJenisHewan)
        tvPenjelasan = findViewById(R.id.tvNamaHewanArab)

        val btnRight: Button = findViewById(R.id.buttonRight)
        val btnLeft: Button = findViewById(R.id.buttonLeft)
        val btnMenu: Button = findViewById(R.id.buttonMenu)

        // Tombol Menu - Kembali ke MainActivity
        btnMenu.setOnClickListener {
            playSound(R.raw.klik)
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }

        // Tombol kanan
        btnRight.setOnClickListener {
            playSound(R.raw.klik)
            cIndex = (cIndex + 1) % images.size
            updateContent(withFade = true)
        }

        // Tombol kiri
        btnLeft.setOnClickListener {
            playSound(R.raw.klik)
            cIndex = if (cIndex - 1 < 0) images.size - 1 else cIndex - 1
            updateContent(withFade = true)
        }

        // Tampilkan pertama kali
        updateContent(withFade = false)
    }

    private fun updateContent(withFade: Boolean) {
        if (withFade) {
            val fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            imageView.startAnimation(fadeOut)
            imageView.postDelayed({
                imageView.setImageResource(images[cIndex])
                imageView.startAnimation(fadeIn)
            }, 300)
        } else {
            imageView.setImageResource(images[cIndex])
        }

        tvNama.text = txtName[cIndex]
        tvJenis.text = "Jenis : ${txtJenis[cIndex]}"
        tvPenjelasan.text = txtPenjelasan[cIndex]
    }

    private fun playSound(resId: Int) {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(this, resId)
        mediaPlayer?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}