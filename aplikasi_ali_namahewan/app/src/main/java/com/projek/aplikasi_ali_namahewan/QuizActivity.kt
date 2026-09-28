package com.projek.aplikasi_ali_namahewan

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizActivity : AppCompatActivity() {
    private val kumpulanSoal = listOf(
        Quiz(
            ".مَا الْحَيَوَانِ الَّذِي رَيِّقِهِ نَجَسٌ ؟ ١." + "\nHewan apa yang air liurnya najis?",
            listOf(
                "A. قِطَّةٌ (Qittah - Kucing)",
                "B. أَسَدٌّ (Asad - Singa)",
                "C. دَجَاجَةٌ (Dajajah - Ayam)",
                "D. كَلْبٌ (Kalb - Anjing)"

            ),
            3
        ),
        Quiz(
            ". مَا الْحَيَوَانِ الَّذِي يُبَيِّضُ؟ ٢." + "\n Hewan manakah yang bisa bertelur?",
            listOf(
                "A. بَقَرَة (Baqarah - Sapi)",
                "B. دَجَاجَة (Dajajah - Ayam)",
                "C. حِصَانٌ (Hisan - Kuda)",
                "D. عَنَزَةٌ (Anzah - Kambing)"
                        ),
                        1
        ),
        Quiz(
            ".ما الحيوان الكبير ذو قرن أو قرنين ويعيش في الغابة؟ ٣." + "\n Hewan besar, punya satu/dua tanduk, hidup di hutan?",
            listOf(
                "A. وحيد القرن (Wahid al-qarn - Badak)",
                "B. زرافة (Zarafah - Jerapah)",
                "C. فيل (Fil - Gajah)",
                "D. تمساح (Timsah - Buaya)"
            ),
            0
        ),
        Quiz(
            "مَا الْحَيَوَانِ الَّذِي يَطِيرُ عَالِيَا فِي السَّمَاءِ؟ ٤." + "\n Hewan manakah yang bisa terbang tinggi di langit",
            listOf(
                "A. نَسُرُّ (Nasr - Elang)",
                "B. بَبَّغَاءُ (Babagha' - Burung beo)",
                "C. حَمَامَةٌ (Hamamah - Merpati)",
                "D. نَعَامَةٌ (Na'amah - Burung unta)"
            ),
            0
        ),
        Quiz(
            "كَيْفَ نُقُولٍ 'Jerapah' بِاللُّغَةِ الْعَرَبِيَّةِ؟ ٥." + "\n Bagaimana menyebut jerapah dalam bahasa Arab?",
            listOf(
                "A. زَرَافَةٌ (Zarafah - Jerapah)",
                "B. فِيلٌ (Fil - Gajah)",
                "C. غُورِيلَّا (Gorila - Gorila)",
                "D. دُبٌّ (Dubb - Beruang)"
            ),
            0
        ),
        Quiz(
                "مَا الْحَيَوَانِ الَّذِي يُعَيِّشُ فِي الْمَاءِ وَيَتَنَفَّسُ بِالْخَيَاشِيمِ؟ ٦." + "\n Hewan apa yang hidup di air dan bernapas dengan insang?",
            listOf(
                "A.  حِصَانٌ (Hisan - Kuda)",
                "B. سَمَكَةٌ (Samakah - Ikan)",
                "C. نَمِرٌ (Nimr - Macan)",
                "D. فَأْرٌ (Fa’r - Tikus)"
            ),
              1
        ),
       Quiz(
           " مَا مَعْنًىٍ بِاللُّغَةِ الْعَرَبِيَّةِ'Kambing'؟ ٧." + "\n Apa bahasa Arab dari 'Kambing'?",
           listOf(
               "A. كَلْبٌ (Kalb - Anjing)",
               "B. عَنَزَةً (Anzah - Kambing)",
               "C. بَقَرَةٌ (Baqarah - Sapi)",
               "D. نَمِرٌ (Nimr - Macan)"
           ),
           1
       ),
       Quiz(
           "مَا الْحَيَوَانِ الَّذِي يَطِيرُ فِي اللَّيْلِ وَيُعْرَفُ كَبُومَةٍ؟ ٨." + "\n Hewan apa yang bisa terbang di malam hari dan dikenal sebagai burung hantu?",

           listOf(
               "A. بُومَةٌ (Bu’mah - Burung hantu)",
               "B. دَجَاجَةٌ (Dajajah - Ayam)",
               "C. حَمَامَةٌ (Hamamah - Merpati)",
               "D. قِطٌّ، (Qitt - Kucing)"
           ),
           0
       ),
        Quiz(
            " مَا الْحَيَوَانِ الَّذِي يُصْدَرُ صَوْتُ الزَّئيرِ؟ ٩." +"\n Hewan mana yang bersuara 'mengaum'?",
            listOf(
                "A. نَمَرُّ (Nimr - Macan)",
                "B. بَقَرَةٌ (Baqarah - Sapi)",
                "C. عَنَزَةٌ (Anzah - Kambing)",
                "D. قِطَّةٌ (Qittah - Kucing)"
            ),
            1
        ),
        Quiz(
           " مَا مَعْنًى 'Singa' بِاللُّغَةِ الْعَرَبِيَّةِ؟ ١٠." + "\n Apa bahasa Arab dari 'Singa'?",

           listOf(
               "A. أَسَدُّ (Asad - Singa)",
               "B. فِيلُ (Fil - Gajah)",
               "C. نَسُرُّ (Nasr - Elang)",
               "D. حِصَانُ (Hisan - Kuda)"
           ),
           0
       ),

    )

    private var cIndex = 0
    private var score = 0
    private var salah = 0
    private var benar = 0

    private lateinit var tvSoal: TextView
    private lateinit var rbGrup: RadioGroup
    private lateinit var rbOpsi1: RadioButton
    private lateinit var rbOpsi2: RadioButton
    private lateinit var rbOpsi3: RadioButton
    private lateinit var rbOpsi4: RadioButton
    private lateinit var btnNext: Button
    private lateinit var btnBack: Button
    lateinit var mediaPlayer: MediaPlayer

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tampilan_quiz)
        supportActionBar!!.hide()


        tvSoal = findViewById(R.id.tvSoal)
        rbGrup = findViewById(R.id.radioGroup)
        rbOpsi1 = findViewById(R.id.rbOpsi1)
        rbOpsi2 = findViewById(R.id.rbOpsi2)
        rbOpsi3 = findViewById(R.id.rbOpsi3)
        rbOpsi4 = findViewById(R.id.rbOpsi4)
        btnNext = findViewById(R.id.buttonNext)
        btnBack = findViewById(R.id.btnBack)
        mediaPlayer = MediaPlayer.create(this,R.raw.klik)

        tampilkanSoal()

        btnNext.setOnClickListener {
            mediaPlayer.start()
            val pilih = rbGrup.checkedRadioButtonId
            val pilihI = when (pilih) {
                R.id.rbOpsi1 -> 0
                R.id.rbOpsi2 -> 1
                R.id.rbOpsi3 -> 2
                R.id.rbOpsi4 -> 3
                else -> -1
            }

            if (pilihI == -1) {
                Toast.makeText(this, "Pilih salah satu jawaban", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            cekNilai(pilihI)

            if (cIndex == kumpulanSoal.size - 1) {
                val intent = Intent(this, HasilQuizActivity::class.java)
                intent.putExtra("score", score.toString())
                intent.putExtra("salah", salah.toString())
                intent.putExtra("benar", benar.toString())
                startActivity(intent)
                finish()
            } else {
                cIndex++
                tampilkanSoal()
                if (cIndex == kumpulanSoal.size - 1) {
                    btnNext.text = "Selesai"
                }
            }
        }

        btnBack.setOnClickListener {
            mediaPlayer.start()
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun tampilkanSoal() {
        tvSoal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_out))
        rbGrup.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_out))

        tvSoal.postDelayed({
            val question = kumpulanSoal[cIndex]
            tvSoal.text = question.question
            rbOpsi1.text = question.opt[0]
            rbOpsi2.text = question.opt[1]
            rbOpsi3.text = question.opt[2]
            rbOpsi4.text = question.opt[3]
            rbGrup.clearCheck()

            tvSoal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in))
            rbGrup.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in))
        }, 300)
    }

    private fun cekNilai(pilihI: Int) {
        val correctIndex = kumpulanSoal[cIndex].jawabanBenar
        if (pilihI == correctIndex) {
            score += 10
            benar++
            Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show()
        } else {
            salah++
            Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show()
        }
    }

    data class Quiz(val question: String, val opt: List<String>, val jawabanBenar: Int)
}