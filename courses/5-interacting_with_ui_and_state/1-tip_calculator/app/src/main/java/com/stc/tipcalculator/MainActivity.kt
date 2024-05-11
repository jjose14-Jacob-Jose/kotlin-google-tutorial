package com.stc.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.stc.tipcalculator.Constants.STRING_EMPTY
import com.stc.tipcalculator.ui.theme.TipCalculatorTheme

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

object Constants {
    const val STRING_EMPTY = ""
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

    Text(
        text = stringResource(id = R.string.tip_amount, tipAmount.toString())
    )
}

@Composable
fun TippingScreen() {

    var flagRoundTip by remember { mutableStateOf(false) }
    var billAmount by remember { mutableStateOf(STRING_EMPTY) }
    var tipPercentage by remember { mutableStateOf(STRING_EMPTY) }
    
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.calculate_tip)
        )


        TextField(
            value = billAmount,
            onValueChange = { billAmount = it },
            label = {
                Text(
                    text = stringResource(id = R.string.placeholder_bill_amount)
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        TextField(
            value = tipPercentage,
            onValueChange = { tipPercentage = it },
            label = {
                Text(
                    text = stringResource(id = R.string.placeholder_tip_percentage)
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Row() {
            Text (
                text = stringResource(id = R.string.round_up_tip)
            )
            Switch(
                checked = flagRoundTip,
                onCheckedChange = {
                    flagRoundTip = it
                }
            )
        }

        DisplayTipAmount(billAmount, tipPercentage, flagRoundTip)

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TipCalculatorTheme {
        TippingScreen()
    }
}