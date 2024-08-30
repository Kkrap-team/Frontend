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

import android.webkit.WebViewClient

class CustomWebviewClient(private val context: Context, private val activtiy : Activity) : WebViewClient() {


    override fun onPageStarted(view: WebView?, url: String?, favicon: android.graphics.Bitmap?) {
        super.onPageStarted(view, url, favicon)
        Log.d("CustomWebView", "Page started loading: $url")
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        Log.d("CustomWebView", "Page finished loading: $url")

        //여기서 쿠키값을 가져와야됨

    }

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
        // 특정 URL로의 로딩을 막기 위한 조건을 설정합니다.
//        if (url != null && url.startsWith("https://where42.kr/"))
////        if (url != null && url.startsWith("https://test.where42.kr:3000"))
//        {
////            Log.d("WebView", "url : ${url}")
//            // 해당 URL로의 로딩을 막습니다.
//            return true
//        }
//        // 그 외의 경우에

        return super.shouldOverrideUrlLoading(view, request)
//        return false
    }


}