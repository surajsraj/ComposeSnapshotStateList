package com.example.compose.snapshotstatelist.persons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PersonMainScreen(
    viewModel: PersonViewModel
) {

    var counter by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier.padding(8.dp),

        ) {
        val people = viewModel.people

        Text(text = "Counter $counter")

        Button(onClick = { counter++ }) {
            Text(text = "Increase Counter")
        }

        Spacer(modifier = Modifier.height(40.dp))

        PersonListScreen(
            people = people,
            onItemClick = {
                viewModel.toggleSelection(it)
            }
        )
    }
}