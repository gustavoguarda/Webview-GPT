package com.example.gpt

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.gpt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding .root)

        val webView = binding.webView
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://chat.openai.com")
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true

        /*
        Error 403: disallowed_useragent on Google Auth Page in Android App
        https://github.com/j0j00/flutter_user_agent/issues/11

        For example- if I am getting a user agent- 'Mozilla/5.0 (Linux; Android 10; RMX1851 Build/QKQ1.190918.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/81.0.4044.138 Mobile Safari/537.36';
        Then using it in webview plugin, for page of Google Oauth(it must required some user agent), google is giving is error Error 403: disallowed_useragent .

        Temporary Solution I found is that- when I replace ; wv with `` (blank string) in the user agent, it is working (this idea came by seeing- other user agent example on web).
        Resultant user_agent- Mozilla/5.0 (Linux; Android 10; RMX1851 Build/QKQ1.190918.001) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/81.0.4044.138 Mobile Safari/537.36'
        */
        webView.settings.userAgentString = "Mozilla/5.0 (Linux; Android 10; RMX1851 Build/QKQ1.190918.001) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/81.0.4044.138 Mobile Safari/537.36"
    }
}