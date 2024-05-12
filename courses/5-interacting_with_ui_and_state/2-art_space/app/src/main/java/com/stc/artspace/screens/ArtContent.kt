package com.stc.artspace.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.stc.artspace.R
import com.stc.artspace.ui.theme.ArtSpaceTheme

class ArtContent {

    @Composable
    fun ShowImage(painterArt: Painter, contentDescription: String, title: String, artist: String) {
        Column() {
            Box() {
                Image(
                    painter = painterArt,
                    contentDescription = stringResource(R.string.hello)
                )
            }
            Column() {
                Text(
                    text = title
                )
                Text(
                    text = artist
                )
            }
        }
    }

    @Composable
    fun MainScreen() {

        var imageIndex by remember { mutableStateOf(0)}

        Column() {
            Box {
                var title = "Title"
                var artist = "Artist"
                var painter = painterResource(id = R.drawable.image_1)
                var contentDescription = "Content Description"

                if(imageIndex > 5) {
                    imageIndex = 1
                } else if(imageIndex<1) {
                    imageIndex = 5
                }

                when(imageIndex) {
                    1 -> {
                        title = stringResource(id = R.string.imageTitle_1)
                        artist = stringResource(id = R.string.contentDescription_1)
                        painter = painterResource(id = R.drawable.image_1)
                        contentDescription = artist
                    }
                    2 -> {
                        title = stringResource(id = R.string.imageTitle_2)
                        artist = stringResource(id = R.string.contentDescription_2)
                        painter = painterResource(id = R.drawable.image_2)
                        contentDescription = artist
                    }
                    3 -> {
                        title = stringResource(id = R.string.imageTitle_3)
                        artist = stringResource(id = R.string.contentDescription_3)
                        painter = painterResource(id = R.drawable.image_3)
                        contentDescription = artist
                    }
                    4 -> {
                        title = stringResource(id = R.string.imageTitle_4)
                        artist = stringResource(id = R.string.contentDescription_4)
                        painter = painterResource(id = R.drawable.image_4)
                        contentDescription = artist
                    }
                    5 -> {
                        title = stringResource(id = R.string.imageTitle_5)
                        artist = stringResource(id = R.string.contentDescription_5)
                        painter = painterResource(id = R.drawable.image_5)
                        contentDescription = artist
                    }
                }

                ShowImage(painterArt = painter, contentDescription = contentDescription, title = title, artist = artist)

            }
            Box() {
                Row() {
                    Button(onClick = { imageIndex-- }) {
                        Text(
                            text = stringResource(id = R.string.btn_previous),
                        )
                    }
                    Button(onClick = { imageIndex++ }) {
                        Text(
                            text = stringResource(id = R.string.btn_next),
                        )
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun Main() {
        ArtSpaceTheme {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                MainScreen()
            }
        }
    }
}