package com.example.nycschool.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nycschool.R
import com.example.nycschool.`object`.ToeflScore
import com.example.nycschool.viewModel.SingleSchoolViewModel
import kotlinx.android.synthetic.main.single_toefl_score.*

/**
 * Created by mhasan2 on 5/10/20.
 */
class SingleSchoolFragment : Fragment() {
    var singleSchoolViewModel: SingleSchoolViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(R.layout.single_toefl_score, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mathScoreTv.text = "Math Score: " + singleSchoolViewModel?.mathScore
        readingTv.text = "Reading Score: " + singleSchoolViewModel?.readingScore
        writingTv.text = "Writing Score: " + singleSchoolViewModel?.writingScore
    }

    companion object {
        fun getInstance(toeflScore: ToeflScore): SingleSchoolFragment {
            val fragment = SingleSchoolFragment()
            fragment.singleSchoolViewModel = SingleSchoolViewModel(toeflScore)
            return fragment
        }
    }
}

