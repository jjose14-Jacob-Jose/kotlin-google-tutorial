package com.stc.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stc.tipcalculator.constants.Constants
import com.stc.tipcalculator.constants.Constants.STRING_EMPTY
import com.stc.tipcalculator.ui.theme.TipCalculatorTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TipCalculatorTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TippingScreen()
                }
            }
        }
    }
}

@Composable
fun EditNumberField(modifier: Modifier = Modifier) {
    var amountInput by remember { mutableStateOf("") }
    TextField(
        value = amountInput,
        onValueChange = { amountInput = it },
        modifier = modifier
    )
}

@Composable
fun DisplayTipAmount(billAmountString: String, tipPercentageString: String, flagRoundTip: Boolean) {
    var tipAmount = 0.0
    try {
        val billAmount = billAmountString.toDouble()
        val tipPercentage = tipPercentageString.toDouble()
        tipAmount = (billAmount * tipPercentage/100);
        if(flagRoundTip)
            tipAmount = Math.ceil(tipAmount)
    } catch (exception: Exception) {
        tipAmount = 0.0
    }
    val tipAmountFormatted = NumberFormat.getCurrencyInstance().format(tipAmount)

    Text(
        text = stringResource(id = R.string.tip_amount, tipAmountFormatted.toString()),
        fontSize = 35.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .testTag(Constants.TEST_TAG_TEXT_TIP_AMOUNT)
    )
}

@Composable
fun TippingScreen() {

    var flagRoundTip by remember { mutableStateOf(false) }
    var billAmount by remember { mutableStateOf(STRING_EMPTY) }
    var tipPercentage by remember { mutableStateOf(STRING_EMPTY) }
    
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(
                start = 25.dp,
                end = 25.dp
            )
    ) {
        Text(
            text = stringResource(id = R.string.calculate_tip),
        )
        Spacer (modifier = Modifier.height(15.dp))


        TextField(
            value = billAmount,
            onValueChange = { billAmount = it },
            label = {
                Text(
                    text = stringResource(id = R.string.placeholder_bill_amount)
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .testTag(Constants.TEST_TAG_TEXTFIELD_BILl_AMOUNT),
            singleLine =  true
        )

        Spacer (modifier = Modifier.height(20.dp))

        TextField(
            value = tipPercentage,
            onValueChange = { tipPercentage = it },
            label = {
                Text(
                    text = stringResource(id = R.string.placeholder_tip_percentage)
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .testTag(Constants.TEST_TAG_TEXTFIELD_TIP_PERCENTAGE),
            singleLine =  true
        )

        Spacer (modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text (
                text = stringResource(id = R.string.round_up_tip),
                modifier = Modifier
                    .padding(
                        top = 10.dp
                    )
            )
            Switch(
                checked = flagRoundTip,
                onCheckedChange = {
                    flagRoundTip = it
                }
            )
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            DisplayTipAmount(billAmount, tipPercentage, flagRoundTip)
        }


    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TipCalculatorTheme {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.background
        ) {
            TippingScreen()
        }
    }

}