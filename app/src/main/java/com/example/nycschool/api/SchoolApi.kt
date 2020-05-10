package com.example.nycschool.api

import com.example.nycschool.`object`.School
import com.example.nycschool.`object`.ToeflScore
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by mhasan2 on 5/9/20.
 */
interface SchoolApi {

    @GET("resource/s3k6-pzi2.json")
    fun getSchoolList(): Call<ArrayList<School>>

    @GET("resource/f9bf-2cp4.json")
    fun getToeflScore(): Call<ArrayList<ToeflScore>>
}