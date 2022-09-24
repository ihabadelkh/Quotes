package com.ihabakh.projects.quotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ihabakh.projects.quotes.databinding.QuoteItemBinding

class QuoteAdapter(
    private val quoteList: ArrayList<Result>
) : RecyclerView.Adapter<QuoteAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = QuoteItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.quote_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quoteList = quoteList[position]
        with(holder) {
            binding.tvQuoteContent.text = quoteList.content
            binding.tvQuoteAuthor.text = quoteList.author
        }
    }

    override fun getItemCount(): Int {
        return quoteList.size
    }
}