package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(){
    lateinit var myRecyclerView: RecyclerView
    lateinit var newsArrayList : ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myRecyclerView = findViewById(R.id.recyclerView)
        val newsImageArray = arrayOf(
            R.drawable.baldman,
            R.drawable.church,
            R.drawable.covid,
            R.drawable.fire,
            R.drawable.mamta,
            R.drawable.operation,
            R.drawable.railway,

        )
        val newsHeadingArray = arrayOf(
            "What do they say about bald guys.Bald guys are good but not smart as they think thats the truth.",
            "Church celebrate the Christmas on Dec every year.LDS Church buys Kirtland temple.",
            "After four years of pandemic, Covid virus to be seasonal flu in young.",
            "Ukrainian drones have targeted Russia, causing explosions and fires at fuel refineries.",
            "Think Before You Apply Mamata Banerjee's Citizenship Law Warning.xpress.",
            "Bengaluru doctors remove bullet stuck in man's head for 18 years.",
            "Maruti Suzuki's in-plant railway siding, India's first such project, inaugurated."
        )
        val newsContent = arrayOf( getString(R.string.news_content),getString(R.string.news_content),getString(R.string.news_content),getString(R.string.news_content),getString(R.string.news_content),getString(R.string.news_content),getString(R.string.news_content))



        // to set hau bhau of items inside recyclerview , vertically scrolling,horizontally,uniform grid
        myRecyclerView.layoutManager =LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()
        for (index in newsImageArray.indices){
            val news = News(newsHeadingArray[index],newsImageArray[index], newsContent[index])
            newsArrayList.add(news)
        }
        var myAdapter =MyAdapter(newsArrayList,this)
        myRecyclerView.adapter = myAdapter

        myAdapter.setOnItemClickListener(object:MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                //on clicking each item , what action do you want to perform
                val intent = Intent(this@MainActivity,NewsDetailActivity::class.java)
                intent.putExtra("heading",newsArrayList[position].newsHeading)
                intent.putExtra("imageId",newsArrayList[position].newsImage)
                intent.putExtra("newscontent",newsArrayList[position].newsContent)
                startActivity(intent)
            }

        }

        )

    }

}