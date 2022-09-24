package com.ihabakh.projects.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ihabakh.projects.quotes.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: QuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        val result = quotesApi.getQuotes()
        result.enqueue(object : Callback<QuoteList> {
            override fun onResponse(call: Call<QuoteList>, response: Response<QuoteList>) {
                val quotes = response.body()?.results
                adapter = QuoteAdapter(quotes!!)
                binding.recyclerView.adapter = adapter
                binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<QuoteList>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}