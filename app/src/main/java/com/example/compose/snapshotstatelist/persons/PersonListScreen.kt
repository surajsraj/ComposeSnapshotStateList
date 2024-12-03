package com.example.compose.snapshotstatelist.persons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.snapshotstatelist.model.Person
import com.example.compose.snapshotstatelist.model.getRandomColor

@Composable
fun PersonListScreen(
    people: SnapshotStateList<Person>,
    onItemClick: (Int) -> Unit
) {

    SideEffect {
        println("ListScreen is recomposing...$people")
    }

    Column {
        Text(
            text = "Header",
            modifier = Modifier.border(2.dp, getRandomColor()),
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier
                .fillMaxSize()
                .border(3.dp, getRandomColor(), RoundedCornerShape(8.dp))
        ) {
            items(
                items = people,
                key = { it.hashCode() }
            ) {
                PersonListItem(item = it, onItemClick = onItemClick)
            }
        }
    }
}

@Composable
private fun PersonListItem(item: Person, onItemClick: (Int) -> Unit) {

    SideEffect {
        println("Recomposing ${item.id}, selected: ${item.isSelected}")
    }

    Column(
        modifier = Modifier.border(3.dp, getRandomColor())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onItemClick(item.id)
                }
                .padding(8.dp)
        ) {
            Text("Index: Name ${item.name}", fontSize = 20.sp)
            if (item.isSelected) {
                Icon(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .background(Color.Red, CircleShape),
                    imageVector = Icons.Default.Check,
                    contentDescription = "Selected",
                    tint = Color.Green,
                )
            }
        }
    }
}