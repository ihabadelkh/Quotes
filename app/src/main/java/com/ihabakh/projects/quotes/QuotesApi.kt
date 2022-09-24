package com.ihabakh.projects.quotes

import retrofit2.Call
import retrofit2.http.GET

interface QuotesApi {

    @GET("/quotes")
    fun getQuotes() : Call<QuoteList>


}