package com.stc.superheroes.screen

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.stc.superheroes.ui.theme.SuperheroesTheme

class ScreenHome {

    @Composable
    fun Show(
        modifier: Modifier = Modifier
    ) {
        ScreenHeroes().Show(modifier)
    }

    @Preview
    @Composable
    fun PreviewDark() {
        SuperheroesTheme(
            darkTheme = true
        ) {
            val modifier = Modifier
            Surface() {
                Show(modifier)
            }
        }
    }

    @Preview
    @Composable
    fun PreviewLight() {
        SuperheroesTheme(
            darkTheme = false
        ) {
            val modifier = Modifier
            Surface {
                Show(modifier)
            }
        }
    }
}