package com.example.compose.snapshotstatelist.model

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

data class Person(val id: Int, val name: String, val isSelected: Boolean = false)

fun getRandomColor() = Color(
    Random.nextInt(256),
    Random.nextInt(256),
    Random.nextInt(256),
    alpha = 255
)