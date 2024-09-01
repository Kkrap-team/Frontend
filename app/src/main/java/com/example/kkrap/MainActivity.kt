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

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // 모든 인디케이터를 회색으로 초기화
                binding.indicator0IvMain.setImageDrawable(getDrawable(R.drawable.indicater_circle_gray))
                binding.indicator1IvMain.setImageDrawable(getDrawable(R.drawable.indicater_circle_gray))
                binding.indicator2IvMain.setImageDrawable(getDrawable(R.drawable.indicater_circle_gray))
                binding.indicator3IvMain.setImageDrawable(getDrawable(R.drawable.indicater_circle_gray))

                // 현재 페이지 인디케이터를 메인색으로 설정
                when (position) {
                    0 -> binding.indicator0IvMain.setImageDrawable(getDrawable(R.drawable.indicater_circle_main))
                    1 -> binding.indicator1IvMain.setImageDrawable(getDrawable(R.drawable.indicater_circle_main))
                    2 -> binding.indicator2IvMain.setImageDrawable(getDrawable(R.drawable.indicater_circle_main))
                    3 -> binding.indicator3IvMain.setImageDrawable(getDrawable(R.drawable.indicater_circle_main))


                }
            }
        }
        )}}


