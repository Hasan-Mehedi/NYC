package com.example.nycschool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nycschool.fragment.ListOfSchoolFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, ListOfSchoolFragment())
        transaction.commit()
    }
}
