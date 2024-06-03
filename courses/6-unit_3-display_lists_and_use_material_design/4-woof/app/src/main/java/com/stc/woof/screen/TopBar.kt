package com.stc.woof.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
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
import com.stc.woof.ui.theme.WoofTheme
import com.stc.woof.ui.theme.md_theme_dark_background
import com.stc.woof.ui.theme.md_theme_light_background

class TopBar {

    @Composable
    fun Show(modifier: Modifier = Modifier) {
        val backgroundColor = if (isSystemInDarkTheme()) {
            md_theme_dark_background
        } else {
            md_theme_light_background
        }
        Row(
            modifier = modifier
                .padding(top = 13.dp)
                .fillMaxWidth()
                .background(backgroundColor),
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                modifier = modifier
                    .height(dimensionResource(id = R.dimen.image_size))
                    .padding(dimensionResource(id = R.dimen.padding_small)),
                painter = painterResource(R.drawable.ic_woof_logo),
                contentDescription = null
            )
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    WoofTheme {
        val modifier = Modifier
        Surface(

        ) {
            TopBar().Show(modifier)
        }
    }
}