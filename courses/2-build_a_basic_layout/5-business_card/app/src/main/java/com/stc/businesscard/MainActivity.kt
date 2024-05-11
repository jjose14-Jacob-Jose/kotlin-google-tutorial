package com.stc.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stc.businesscard.ui.theme.BusinessCardTheme

@Composable
fun BusinessCard(
    text_name_full: String,
    text_title: String,
    text_phone_number: String,
    text_social_media_handle: String,
    text_email: String,
    painter_picture: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color(0xFFD2E8D4))
            .padding(
                top = 20.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally


//        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Column (
            modifier = Modifier
                .fillMaxHeight(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Image(
                painter = painter_picture,
                contentDescription = "Business Card Logo",
                modifier = Modifier
                    .background(Color(0xFF073042))
            )
            Text (
                text = text_name_full,
                fontSize = 20.sp
            )
            Text (
                text = text_title,
                color = Color(android.graphics.Color.parseColor("#167648")),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold


            )
        }
        Box(
            modifier = Modifier
                .height(350.dp)
                .scale(
                    scaleX = 0.75f,
                    scaleY = 0.75f,
                ),

        ) {
            Column (
                modifier = Modifier
                    .fillMaxHeight(0.25f)
                    .padding(
                        start = 16.dp,
                        end = 16.dp
                    )
                ,

                verticalArrangement = Arrangement.SpaceAround

            ){
                Row () {
                    Icon (
                        imageVector = Icons.Default.Phone,
                        contentDescription = "Phone Icon",
                        tint = Color(0xFF006D3B),
                        modifier = Modifier
                            .padding (
                                end = 5.dp
                            )
                    )
                    Text (
                        text = text_phone_number
                    )
                }
                Spacer (modifier = Modifier.height(5.dp))
                Row () {
                    Icon (
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share Icon",
                        tint = Color(0xFF006D3B),
                        modifier = Modifier
                            .padding (
                                end = 5.dp
                            )
                    )
                    Text (
                        text = text_social_media_handle
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row () {
                    Icon (
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon",
                        tint = Color(0xFF006D3B),
                        modifier = Modifier
                            .padding (
                                end = 5.dp
                            )
                    )
                    Text (
                        text = text_email
                    )
                }
            }
        }

    }
}

@Composable
fun BusinessCardInit() {
    val full_name = "Jacob Jose"
    val title = "Software Engineer"
    val phone_number = "+1 (123) 456-7890"
    val social_media = "https://jacobjose.live"
    val email = "mail@jacobjose.live"
    val image = painterResource(id = R.drawable.android_robot)

    BusinessCard(
        text_name_full = full_name,
        text_title = title,
        text_phone_number = phone_number,
        text_social_media_handle = social_media,
        text_email = email,
        painter_picture = image
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
//        Greeting("Android")
        BusinessCardInit()
    }

}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface (
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    BusinessCardInit()
                }
            }
        }
    }
}