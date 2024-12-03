package com.example.compose.snapshotstatelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.compose.snapshotstatelist.persons.PersonMainScreen
import com.example.compose.snapshotstatelist.persons.PersonViewModel
import com.example.compose.snapshotstatelist.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<PersonViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PersonMainScreen(mainViewModel)
                }
            }
        }
    }
}

