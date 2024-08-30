package com.example.kkrap


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.kkrap.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        viewPager.adapter = viewpageradapter(this)

        val btn: Button = binding.btnHome

        //로그인하러 가기 버튼 클릭 설정
        btn.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            finish()
            startActivity(intent)
        }

    }
}


