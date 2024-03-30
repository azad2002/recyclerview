package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
         val heading = intent.getStringExtra("heading")
        val newsContent = intent.getStringExtra("newscontent")
        val imageId = intent.getIntExtra("imageId",R.drawable.baldman)

        val headingTV = findViewById<TextView>(R.id.newsHeading)
        val headingIV = findViewById<ImageView>(R.id.imageView)
        val newsContentTV = findViewById<TextView>(R.id.newsContent)

        headingTV.text = heading
        newsContentTV.text = newsContent
        headingIV.setImageResource(imageId)

    }
}