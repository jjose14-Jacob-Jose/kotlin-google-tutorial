package com.stc.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stc.lemonade.constants.ConstantsMain
import com.stc.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    LemonadeCycle()
                }

            }
        }
    }
}

@Composable
fun LemonadeCycle(modifier: Modifier = Modifier
    .fillMaxSize()
    ) {
    var stageCurrent by remember {mutableStateOf(1)}
    val squeezeCountMaxLocal = (ConstantsMain.SQUEEZE_COUNT_MIN..ConstantsMain.SQUEEZE_COUNT_MAX).random()
    var squeezeCountCurrent = 0

    var resourceImage = R.drawable.lemon_tree
    var resourceImageContentDescription = R.string.contentDescription_lemon_tree
    var resourceTextStageDescription = R.string.text_stage1_lemon_tree
    when(stageCurrent) {
        2 -> {
            resourceImage = R.drawable.lemon_squeeze
            resourceImageContentDescription = R.string.contentDescription_lemon_only
            resourceTextStageDescription = R.string.text_stage2_lemon
        }
        3 -> {
            resourceImage = R.drawable.lemon_drink
            resourceImageContentDescription = R.string.contentDescription_glass_full_lemonade
            resourceTextStageDescription = R.string.text_stage3_lemonade_in_glass
        }
        4 -> {
            resourceImage = R.drawable.lemon_restart
            resourceImageContentDescription = R.string.contentDescription_glass_empty
            resourceTextStageDescription = R.string.text_stage4_empty_glass
        }
        else -> {
            resourceImage = R.drawable.lemon_tree
            resourceImageContentDescription = R.string.contentDescription_lemon_tree
            resourceTextStageDescription = R.string.text_stage1_lemon_tree
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(35.dp)
                .background(Color(0xFF878036))
        ) {
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(35.dp)
                .background(Color(0xFFF9E44C)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.app_name),
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Image(
                painter = painterResource(id = resourceImage),
                contentDescription = stringResource(id = resourceImageContentDescription),
                alignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(35.dp))
                    .background(Color(0xFFCBEBD4))
                    .border(
                        width = 1.dp,
                        shape = RoundedCornerShape(35.dp),
                        color = Color(
                            red = 105,
                            green = 205,
                            blue = 216
                        )

                    )
                    .clickable {
                        when {
                            stageCurrent == 1 -> {
                                stageCurrent++
                            }
                            stageCurrent == 2 -> {
                                squeezeCountCurrent++
                                if(squeezeCountCurrent >= squeezeCountMaxLocal) {
                                    stageCurrent++
                                }
                            }
                            stageCurrent == 3 ->
                                stageCurrent++
                            else -> stageCurrent = 1
                        }
                    }

            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Text(
                text = stringResource(id = resourceTextStageDescription),
                fontSize = 18.sp
            )
        }

    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeCycle()
    }
}