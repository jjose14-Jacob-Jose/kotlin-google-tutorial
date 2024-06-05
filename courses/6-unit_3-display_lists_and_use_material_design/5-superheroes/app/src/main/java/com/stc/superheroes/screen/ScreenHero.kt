package com.stc.superheroes.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stc.superheroes.R
import com.stc.superheroes.datasource.HeroesRepository
import com.stc.superheroes.model.Hero
import com.stc.superheroes.ui.theme.SuperheroesTheme

class ScreenHero {

    @Composable
    fun Show(
        hero: Hero,
        modifier: Modifier = Modifier
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = modifier
        ) {
            Row(
                modifier = modifier
                    .sizeIn(minHeight = 72.dp)
                    .fillMaxWidth()
                    .padding(16.dp)
            ){
                val name = stringResource(id = hero.nameRes)
                Column(
                    modifier = modifier
                        .weight(1f)
                ) {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.displaySmall
                    )
                    Text(
                        text = stringResource(id = hero.descriptionRes),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Spacer(
                    modifier = Modifier
                        .width(16.dp)
                )
                Image(
                    painter = painterResource(id = hero.imageRes),
                    contentDescription = stringResource(R.string.content_description_picture) + name,
                    modifier = Modifier
                        .size(72.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }

        }

    }

    @Preview
    @Composable
    fun PreviewHeroSingleDark() {
        SuperheroesTheme(
            darkTheme = true
        ) {
            val modifier = Modifier
            Surface(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Show(
                    HeroesRepository.heroes.get(0),
                    modifier
                )
            }
        }
    }

    @Preview
    @Composable
    fun PreviewHeroSingleLight() {
        SuperheroesTheme(
            darkTheme = false
        ) {
            val modifier = Modifier
            Surface(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Show(
                    HeroesRepository.heroes.get(0),
                    modifier
                )
            }
        }

    }

}