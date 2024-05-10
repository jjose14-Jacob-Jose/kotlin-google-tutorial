package com.stc.composepreview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stc.composepreview.ui.theme.ComposePreviewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePreviewTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JetpackComposeText(
                        textRow1 = stringResource(R.string.text_row_1),
                        textRow2 = stringResource(R.string.text_row_2),
                        textRow3 = stringResource(R.string.text_row_3)
                    )
                }
            }
        }
    }
}

@Composable
fun JetpackComposeText(
    textRow1: String,
    textRow2: String,
    textRow3: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column (
        verticalArrangement = Arrangement.Top,
        modifier = modifier
    ) {
        Image (
            painter = painterResource(R.drawable.bg_compose_background),
            contentDescription = "Background image"
        )
        Text (
            text = textRow1,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)

        )
        Text (
            text = textRow2,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp
            ),
            textAlign = TextAlign.Justify
        )
        Text (
            text = textRow3,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePreviewTheme {
        JetpackComposeText(
            textRow1 = stringResource(R.string.text_row_1),
            textRow2 = stringResource(R.string.text_row_2),
            textRow3 = stringResource(R.string.text_row_3)
        )
    }
}