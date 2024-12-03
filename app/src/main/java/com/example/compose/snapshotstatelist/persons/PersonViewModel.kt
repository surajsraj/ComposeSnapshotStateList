package com.example.compose.snapshotstatelist.persons

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.compose.snapshotstatelist.model.Person

class PersonViewModel : ViewModel() {

    private val initialList = List(30) { index: Int ->
        Person(id = index, name = "Name$index")
    }

    val people = mutableStateListOf<Person>().apply {
        addAll(initialList)
    }

    fun toggleSelection(index: Int) {
        val item = people[index]
        val isSelected = item.isSelected
        people[index] = item.copy(isSelected = !isSelected)
    }
}