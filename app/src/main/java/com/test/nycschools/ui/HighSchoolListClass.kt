package com.test.nycschools.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.test.nycschools.data.HighschoolResponse

object HighSchoolListClass {

    @Composable
    fun HighSchoolList(highSchool: List<HighschoolResponse>, onItemClick: (HighschoolResponse) -> Unit){
        LazyColumn{
            items(highSchool) {school ->
                HighSchoolListItem(school= school, onItemClick = onItemClick)
            }
        }
    }

    @Composable
    fun HighSchoolListItem(school: HighschoolResponse, onItemClick: (HighschoolResponse) -> Unit){
        Column(Modifier.clickable { onItemClick(school) }) {
            if(school.schoolName != null && school.dbn!= null) {
                Text(text = school.schoolName!!, fontWeight = FontWeight.Bold)
                Text(text = school.dbn!!)
            }
        }
    }

    @Composable
    fun HighSchoolDetail(school: HighschoolResponse){
        Column() {
            if(school.schoolName != null && school.dbn!= null) {
                Text(text = school.schoolName!!, fontWeight = FontWeight.Bold)
                Text(text = school.dbn!!)
                Text(text = school.overviewParagraph!!)
            }
        }
    }

}