package com.stc.superheroes.screen

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stc.superheroes.R
import com.stc.superheroes.ui.theme.SuperheroesTheme

class ScreenTopBar {

    @Composable
    fun Show(modifier: Modifier = Modifier) {
        Box(modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = MaterialTheme.colorScheme.background)
            .statusBarsPadding(),
            contentAlignment = Alignment.Center,
        ) {
            Spacer(
                modifier = modifier.height(15.dp)
            )
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayLarge,
            )
        }
    }

    @Preview
    @Composable
    fun PreviewLight() {
        SuperheroesTheme(
            darkTheme = false
        ) {
            Surface() {
                val modifier = Modifier
                Show(modifier)
            }
        }
    }

    @Preview
    @Composable
    fun PreviewDark() {
        SuperheroesTheme(
            darkTheme = true
        ) {
            Surface() {
                val modifier = Modifier
                Show(modifier)
            }

        }
    }



}