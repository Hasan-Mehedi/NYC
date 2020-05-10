package com.example.nycschool.api

import com.example.nycschool.`object`.School
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by mhasan2 on 5/9/20.
 */
class ApiService {
    var baseUrl = "https://data.cityofnewyork.us/"
    val api =
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
            .build().create(SchoolApi::class.java)

    fun getSearchResultService(): Call<ArrayList<School>> {
        return api.getSchoolList()
    }
}