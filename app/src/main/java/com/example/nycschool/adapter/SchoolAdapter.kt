package com.example.nycschool.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nycschool.R
import com.example.nycschool.`object`.School
import com.example.nycschool.fragment.ListOfSchoolFragment

/**
 * Created by mhasan2 on 5/10/20.
 */
class SchoolAdapter(var listOfSchoolFragment: ListOfSchoolFragment ,var schoolList: List<School>?): RecyclerView.Adapter<SchoolNameViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolNameViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.single_school, parent, false)
        return SchoolNameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return schoolList?.size ?:0
    }

    override fun onBindViewHolder(holder: SchoolNameViewHolder, position: Int) {
        schoolList?.let {
            holder.bind(schoolList!![position])
        }
        holder.textView.setOnClickListener{
            listOfSchoolFragment.showSingleFragment(schoolList!![position].dbn)
        }
    }
}

class SchoolNameViewHolder(view: View): RecyclerView.ViewHolder(view){
    var textView: TextView = view.findViewById(R.id.schoolTV)
    fun bind(school: School){
        textView.text = school.school_name
    }
}