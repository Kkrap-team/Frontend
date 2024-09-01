package com.example.kkrap

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.os.Build
import android.net.http.SslError
import android.webkit.WebResourceError
import android.webkit.WebResourceResponse
import android.webkit.SslErrorHandler
import android.webkit.CookieManager

import android.webkit.WebViewClient

class CustomWebviewClient(private val context: Context, private val activtiy : Activity) : WebViewClient() {


    override fun onPageStarted(view: WebView?, url: String?, favicon: android.graphics.Bitmap?) {
        super.onPageStarted(view, url, favicon)
        Log.d("CustomWebView", "Page started loading: $url")
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        Log.d("CustomWebView", "Page finished loading: $url")


        //쿠키 설정
        if (url == " ")  //*여기 'http://172.20.10.12:8080 넣기
        {
            val cookieManager = CookieManager.getInstance()
            val cookies = cookieManager.getCookie(url)

            if (cookies != null) {
                val cookieMap = parseCookies(cookies)

                // 원하는 쿠키 값만 추출하기 (email,id,nickname,profileimage)
                val email = cookieMap["email"]
                val id = cookieMap["id"]
                val nickname = cookieMap["nickname"]
                val profileImage = cookieMap["profileimage"]

                Log.d("Cookies", "Email: $email")
                Log.d("Cookies", "ID: $id")
                Log.d("Cookies", "Nickname: $nickname")
                Log.d("Cookies", "Profile Image: $profileImage")
            } else {
                Log.d("CustomWebView", "No cookies found for $url")
            }
        }
    }

        // 쿠키 가져오기?
//            val cookies = customWebView.getCookies(" ") // *여기에 원하는 url 입력
//            Log.d("Cookies", "Cookies: $cookies")

    override fun onLoadResource(view: WebView?, url: String?) {
        super.onLoadResource(view, url)
    }

    @TargetApi(Build.VERSION_CODES.M)
    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        super.onReceivedError(view, request, error)
        Log.e("CustomWebView", "Error: ${error?.description}")
    }

    override fun onReceivedHttpError(
        view: WebView?,
        request: WebResourceRequest?,
        errorResponse: WebResourceResponse?
    ) {
        super.onReceivedHttpError(view, request, errorResponse)
    }

    override fun onReceivedSslError(
        view: WebView?, handler: SslErrorHandler,
        error: SslError?
    ) {
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun shouldInterceptRequest(
        view: WebView?,
        request: WebResourceRequest?
    ): WebResourceResponse? {
        return super.shouldInterceptRequest(view, request)
    }

    @TargetApi(Build.VERSION_CODES.N)
    override fun shouldOverrideUrlLoading(
        view: WebView?,
        request: WebResourceRequest?
    ): Boolean {
        val url = request?.url?.toString()
        Log.d("CustomWebView", "url : ${url}")
        return super.shouldOverrideUrlLoading(view, request)
    }

    //특정 쿠키 값 추출하는 함수
        private fun parseCookies(cookieString: String): Map<String, String> {
            val cookieMap = mutableMapOf<String, String>()
            val cookiePairs = cookieString.split(";")

            for (pair in cookiePairs) {
                val keyValue = pair.split("=")
                if (keyValue.size == 2) {
                    val key = keyValue[0].trim()
                    val value = keyValue[1].trim()
                    cookieMap[key] = value
                }
            }

            return cookieMap

        // 특정 URL로의 로딩을 막기 위한 조건을 설정합니다??
//        if (url != null && url.startsWith("https://where42.kr/"))
////        if (url != null && url.startsWith("https://test.where42.kr:3000"))
//        {
////            Log.d("WebView", "url : ${url}")
//            // 해당 URL로의 로딩을 막습니다??
//            return true
//        }
    }


}