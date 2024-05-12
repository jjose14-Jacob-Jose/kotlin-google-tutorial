package com.stc.artspace.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = artist
                )
            }
        }
    }


    @Composable
    fun ToggleButton(
        onClick: () -> Unit,
        text: String,
        modifier: Modifier = Modifier
    ) {
        Button(
            onClick = { onClick() },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(0xFFcce0e0)
            ),
            shape = RectangleShape,
            contentPadding = PaddingValues(
                horizontal = 50.dp,
                vertical = 5.dp
            ),
            ) {
            Text(
                text = text,
            )
        }
    }

    @Composable
    fun MainScreen() {

        var imageIndex by remember { mutableStateOf(0)}

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

        ) {
            Box (
                modifier = Modifier
                    .padding(
                        horizontal = 25.dp
                    )
            ) {
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

            Spacer(modifier = Modifier.height(30.dp))

            Box() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ToggleButton(
                        onClick = { imageIndex-- },
                        text = stringResource(id = R.string.btn_previous),
                        modifier = Modifier
                    )
                    ToggleButton(
                        onClick = { imageIndex++ },
                        text = stringResource(id = R.string.btn_next),
                        modifier = Modifier
                    )
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