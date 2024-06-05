package com.stc.superheroes.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stc.superheroes.datasource.HeroesRepository
import com.stc.superheroes.model.Hero
import com.stc.superheroes.ui.theme.SuperheroesTheme

class ScreenHeroes {

    @Composable
    fun DisplayList(
        listHeroes: List<Hero>,
        modifier: Modifier = Modifier
    ) {
        Scaffold(
            topBar = {
                ScreenTopBar().Show(modifier
                    .statusBarsPadding())
            }
        ) {
            innerPadding ->
                LazyColumn(
                    modifier = modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxSize()
                        .statusBarsPadding(),
                    contentPadding = innerPadding
                ) {
                    itemsIndexed(listHeroes) {index, item ->
                        ScreenHero().Show(
                            hero = item,
                            modifier = modifier
                                .padding(vertical = 8.dp)
                        )
                    }
            }
        }
    }

    @Composable
    fun Show(
        modifier: Modifier = Modifier
    ) {
        DisplayList(listHeroes = HeroesRepository.heroes, modifier)
    }

    @Preview
    @Composable
    fun PreviewDark() {
        SuperheroesTheme(darkTheme = true) {
            val modifier = Modifier
            Surface(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Show(modifier)
            }
        }
    }

    @Preview
    @Composable
    fun PreviewLight() {
        SuperheroesTheme(darkTheme = false) {
            val modifier = Modifier
            Surface(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Show(modifier)
            }
        }
    }



}