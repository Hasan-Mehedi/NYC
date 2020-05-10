package com.example.nycschool.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nycschool.`object`.School
import com.example.nycschool.`object`.ToeflScore
import com.example.nycschool.api.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by mhasan2 on 5/9/20.
 */
class ListOfSchoolViewModel : ViewModel() {
    var schoolList = MutableLiveData<List<School>>()
    var toeflList: List<ToeflScore>? = null

    init {
        val apiService = ApiService()
        apiService.getSearchResultService().enqueue(
            object : Callback<ArrayList<School>> {
                override fun onFailure(call: Call<ArrayList<School>>, t: Throwable) {
                    Log.d(
                        "ListOfSchoolViewModel",
                        "list of school retrieval failure. message:" + t.message
                    )
                }

                override fun onResponse(
                    call: Call<ArrayList<School>>,
                    response: Response<ArrayList<School>>
                ) {
                    schoolList.value = response.body()
                }

            }
        )

        apiService.api.getToeflScore().enqueue(
            object : Callback<ArrayList<ToeflScore>> {
                override fun onFailure(call: Call<ArrayList<ToeflScore>>, t: Throwable) {
                    Log.d(
                        "ListOfSchoolViewModel",
                        "toefl score retrieval failure. message:" + t.message
                    )
                }

                override fun onResponse(
                    call: Call<ArrayList<ToeflScore>>,
                    response: Response<ArrayList<ToeflScore>>
                ) {
                    toeflList = response.body()
                }

            }
        )
    }

    fun getToeflScore(dbn: String): ToeflScore? {
        return toeflList?.find { it.dbn == dbn }
    }
}