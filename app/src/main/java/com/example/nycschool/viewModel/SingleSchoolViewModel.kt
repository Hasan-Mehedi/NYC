package com.example.nycschool.viewModel

import androidx.lifecycle.ViewModel
import com.example.nycschool.`object`.ToeflScore

/**
 * Created by mhasan2 on 5/10/20.
 */
class SingleSchoolViewModel(toeflScore: ToeflScore) : ViewModel() {
    var mathScore: String? = null
    var readingScore: String? = null
    var writingScore: String? = null

    init {
        mathScore = toeflScore.sat_math_avg_score
        readingScore = toeflScore.sat_critical_reading_avg_score
        writingScore = toeflScore.sat_writing_avg_score
    }

}