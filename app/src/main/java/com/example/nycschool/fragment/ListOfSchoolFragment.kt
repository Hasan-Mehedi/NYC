package com.example.nycschool.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nycschool.R
import com.example.nycschool.`object`.School
import com.example.nycschool.adapter.SchoolAdapter
import com.example.nycschool.viewModel.ListOfSchoolViewModel

/**
 * Created by mhasan2 on 5/9/20.
 */
class ListOfSchoolFragment : Fragment() {
    var viewModel = ListOfSchoolViewModel()
    var recyclerView: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_of_school, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.adapter = SchoolAdapter(this, viewModel?.schoolList as? List<School>)

        viewModel.schoolList.observe(this, Observer {
            recyclerView?.adapter = SchoolAdapter(this, it)
        })
    }

    fun showSingleFragment(dbn: String?) {
        dbn?.let {
            val toeflScore = viewModel.getToeflScore(dbn)
            toeflScore?.let {
                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(
                    R.id.fragment_container,
                    SingleSchoolFragment.getInstance(toeflScore)
                )?.addToBackStack(null)?.commit()
            } ?: run {
                Toast.makeText(context, "school toefl score not found", Toast.LENGTH_LONG).show()
            }
        }

    }
}