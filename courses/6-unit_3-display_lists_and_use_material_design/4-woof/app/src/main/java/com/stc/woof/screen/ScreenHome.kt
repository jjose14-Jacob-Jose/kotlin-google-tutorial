package com.stc.woof.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stc.woof.R
import com.stc.woof.data.DataSourceDog
import com.stc.woof.ui.theme.WoofTheme

class ScreenHome {

    @Composable
    fun MainScreen(modifier: Modifier = Modifier) {
        val listDogs = DataSourceDog.listDogs

        Scaffold(
            topBar = {
                TopBar().Show(modifier)
            }
        ) {
            it ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                contentPadding = it,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_small))

            ) {
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
            val modifier = Modifier
            Surface(
                modifier = modifier
                    .fillMaxSize()
            ) {
                MainScreen(modifier)
            }
        }
    }
}