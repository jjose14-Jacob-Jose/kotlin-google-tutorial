package com.stc.woof.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stc.woof.data.DataSourceDog
import com.stc.woof.ui.theme.WoofTheme

class Home {

    @Composable
    fun MainScreen() {
        val listDogs = DataSourceDog.listDogs
        
        Scaffold(
            topBar = {
                TopBar().Show()
            }
        ) {
            it ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .statusBarsPadding()) {
                items(listDogs.size) {
                        index -> ScreenDog().Show(dog = listDogs[index])
                }

            }
        }
        

    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewDogItem() {
        WoofTheme {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                MainScreen()
            }
        }
    }
}