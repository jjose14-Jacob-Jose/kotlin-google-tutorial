package com.stc.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stc.composequadrant.ui.theme.ComposeQuadrantTheme

@Composable
fun ComposeQuadrants(
    textHeadingQuad00: String,
    textDescriptionQuad00: String,
    textHeadingQuad01: String,
    textDescriptionQuad01: String,
    textHeadingQuad10: String,
    textDescriptionQuad10: String,
    textHeadingQuad11: String,
    textDescriptionQuad11: String,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxSize()

    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 30.dp
                )
        ) {
            Column (
                modifier = Modifier
                    .background(color = Color(0xFFEADDFF))
                    .weight(1f)
                    .fillMaxHeight(0.5f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = textHeadingQuad00,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier =  Modifier
                        .padding(
                            bottom = 16.dp
                        )
                )
                Text(
                    text = textDescriptionQuad00,
                    textAlign = TextAlign.Justify,
                )
            }

            Column (
                modifier = Modifier
                    .background(color = Color(0xFFD0BCFF))
                    .weight(1f)
                    .fillMaxHeight(0.5f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    text = textHeadingQuad01,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier =  Modifier
                        .padding(
                            bottom = 16.dp
                        )
                )
                Text(
                    text = textDescriptionQuad01,
                    textAlign = TextAlign.Justify,
                )
            }
        }
        Row () {
            Column (
                modifier = Modifier
                    .background(color = Color(0xFFB69DF8))
                    .weight(1f)
                    .fillMaxHeight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = textHeadingQuad10,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier =  Modifier
                        .padding(
                            bottom = 16.dp
                        )
                )
                Text(
                    text = textDescriptionQuad10,
                    textAlign = TextAlign.Justify,
                )
            }

            Column (
                modifier = Modifier
                    .background(color = Color(0xFFF6EDFF))
                    .weight(1f)
                    .fillMaxHeight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = textHeadingQuad11,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier =  Modifier
                        .padding(
                            bottom = 16.dp
                        )
                )
                Text(
                    text = textDescriptionQuad11,
                    textAlign = TextAlign.Justify,
                )
            }
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayQuadrants()
                }
            }
        }
    }
}

@Composable
fun DisplayQuadrants() {
    val textHeadingQuad00 = "Text composable"
    val textDescriptionQuad00 = "Displays text and follows the recommended Material Design guidelines."

    val textHeadingQuad01 = "Image composable"
    val textDescriptionQuad01 = "Creates a composable that lays out and draws a given Painter class object.."

    val textHeadingQuad10 = "Row composable"
    val textDescriptionQuad10 = "A layout composable that places its children in a horizontal sequence.."

    val textHeadingQuad11 = "Column composable"
    val textDescriptionQuad11 = "A layout composable that places its children in a vertical sequence.."

    ComposeQuadrants(
        textHeadingQuad00 = textHeadingQuad00,
        textDescriptionQuad00 = textDescriptionQuad00,
        textHeadingQuad01 = textHeadingQuad01,
        textDescriptionQuad01 = textDescriptionQuad01,
        textHeadingQuad10 = textHeadingQuad10,
        textDescriptionQuad10 = textDescriptionQuad10,
        textHeadingQuad11 = textHeadingQuad11,
        textDescriptionQuad11 = textDescriptionQuad11
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        DisplayQuadrants()

    }
}