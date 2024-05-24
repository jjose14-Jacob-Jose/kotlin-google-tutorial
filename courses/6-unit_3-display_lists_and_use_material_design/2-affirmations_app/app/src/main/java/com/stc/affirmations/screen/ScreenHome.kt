package com.stc.affirmations.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.stc.affirmations.data.DataSource
import com.stc.affirmations.model.Affirmation


class ScreenHome {


    @Preview(showBackground = true)
    @Composable
    fun Main() {
        val layoutDirection = LocalLayoutDirection.current
        Surface(
            modifier = Modifier
                .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection)
            )
        ) {

            val listAffirmations = DataSource().loadAffirmations()
            LazyColumn(
                modifier = Modifier
                    .padding(15.dp)
            ){
                items(listAffirmations) {
                    affirmation ->
                        DisplayAffirmationItem(affirmation)
                }
            }
         }
    }

    @Composable
    fun DisplayAffirmationItem(affirmation: Affirmation) {
        Card (
            modifier = Modifier
                .padding(15.dp)
        ){
            Image(
                painter = painterResource(id = affirmation.imageResourceId),
                contentDescription = affirmation.imageResourceId.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
//                    text = stringResource(id = affirmation.stringResourceId),
                text = LocalContext.current.getString(affirmation.stringResourceId),
                modifier  = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}


