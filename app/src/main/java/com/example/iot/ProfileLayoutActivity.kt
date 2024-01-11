package com.example.iot


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ProfileLayoutActivity : AppCompatActivity() {
    lateinit var binding: ProfileLayoutActivity
    lateinit var auth : FirebaseAuth
    private lateinit var tvData1: TextView
    private lateinit var tvData2: TextView
    private lateinit var tvData3: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_layout)

        val CRUD: Button = findViewById(R.id.CRUD)
        // Menambahkan onClickListener ke TextView
        CRUD.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
        // Inisialisasi TextView
        tvData1 = findViewById(R.id.profile_name)
        tvData2 = findViewById(R.id.profile_height)
        tvData3 = findViewById(R.id.profile_weight)

        // Periksa apakah ada extras pada intent
        if (intent.extras != null) {
            val bundle = intent.extras

            // Periksa dan set nilai jika bundle tidak null
            if (bundle != null) {
                tvData1.text = bundle.getString("Deklan Malik Akbar")
            }
            if (bundle != null) {
                tvData2.text = "${bundle.getString("180")} cm"
            }
            if (bundle != null) {
                tvData3.text = "${bundle.getString("60")} kg"
            }
        } else {
            // Jika tidak ada extras, set nilai dari intent langsung
            tvData1.text = intent.getStringExtra("Deklan Malik Akbar")
            tvData2.text = "${intent.getStringExtra("180")} cm"
            tvData3.text = "${intent.getStringExtra("60")} kg"
        }
        auth = FirebaseAuth.getInstance()

        val logoutImageView: Button = findViewById(R.id.logout_button)

        logoutImageView.setOnClickListener {
            // Lakukan logout dari Firebase
            auth.signOut()

            // Redirect ke halaman login (atau halaman awal setelah logout)
            // Ganti LoginActivity::class.java dengan kelas aktivitas yang sesuai
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            this?.finish()
        }

    }
}