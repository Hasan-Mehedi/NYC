package com.example.nycschool

import com.example.nycschool.`object`.ToeflScore
import com.example.nycschool.viewModel.ListOfSchoolViewModel
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


/**
 * Created by mhasan2 on 5/10/20.
 */

@RunWith(RobolectricTestRunner::class)
class ListOfSchoolViewModelTest {
    var viewModel: ListOfSchoolViewModel? = null

    @Test
    fun getToeflScoreTest() {
        viewModel = ListOfSchoolViewModel()
        viewModel?.toeflList =
            listOf(
                ToeflScore("1", "100", "101", "102"),
                ToeflScore("2", "200", "201", "202"),
                ToeflScore("3", "300", "301", "302"),
                ToeflScore("4", "400", "401", "402")
            )

        Assert.assertEquals(viewModel?.getToeflScore("2"), ToeflScore("2", "200", "201", "202"))
        Assert.assertEquals(viewModel?.getToeflScore("4"), ToeflScore("4", "400", "401", "402"))
        Assert.assertEquals(viewModel?.getToeflScore("7"), null)

    }

}
