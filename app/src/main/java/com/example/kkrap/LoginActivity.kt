package com.example.kkrap

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity  : AppCompatActivity() {

    private lateinit var webView: WebView

    //    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activtiy_login)

        // 버튼 및 다른 UI 요소 초기화
        val btn: Button = findViewById(R.id.btn_kakao)
        val imageView1: ImageView = findViewById(R.id.imageView7)
        val imageView2: ImageView = findViewById(R.id.imageView6)
        val textView1: TextView = findViewById(R.id.text1)
        val textView2: TextView = findViewById(R.id.textView8)
        val textView3: TextView = findViewById(R.id.textView9)
        val textView4: TextView = findViewById(R.id.textView10)

        // CustomWebView 인스턴스 초기화
        webView = findViewById<WebView>(R.id.webview)

        // 버튼 클릭 리스너 설정
        btn.setOnClickListener {
            // 앞선 화면 위젯들 제거
            btn.visibility = View.INVISIBLE
            imageView1.visibility = View.INVISIBLE
            imageView2.visibility = View.INVISIBLE
            textView1.visibility = View.INVISIBLE
            textView2.visibility = View.INVISIBLE
            textView3.visibility = View.INVISIBLE
            textView4.visibility = View.INVISIBLE

            webView.settings.javaScriptEnabled = true
            webView.settings.mixedContentMode = android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            val customWebViewClient = CustomWebviewClient(this@LoginActivity, this@LoginActivity)
            webView.webViewClient = customWebViewClient
            webView.loadUrl("https://github.com/JaeYoonJung08/where42Android/blob/main/app/src/main/java/com/seoul/where42android/WebView/CustomWebViewClient.kt")


            // 웹뷰를 보이게 하고 URL 로드
            webView.visibility = View.VISIBLE

//            customWebView.loadCustomUrl(" ")  // *여기에 원하는 url 입력

            // 쿠키 가져오기
//            val cookies = customWebView.getCookies(" ") // *여기에 원하는 url 입력
//            Log.d("Cookies", "Cookies: $cookies")
        }
    }
}
