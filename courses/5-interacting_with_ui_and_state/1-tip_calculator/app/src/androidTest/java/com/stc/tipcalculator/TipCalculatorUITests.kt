package com.stc.tipcalculator

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.stc.tipcalculator.constants.Constants
import com.stc.tipcalculator.ui.theme.TipCalculatorTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorUITests {

    @get:Rule
    val composeTestRule = createComposeRule()


    fun get_tip_percentage(billAmount: Double, tipPercentage: Double): Double {
        return (billAmount * tipPercentage/100)
    }

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipCalculatorTheme {
                TippingScreen()
            }

        }
        val billAmount = 20.0
        val tipPercentage = 30.0
        composeTestRule.onNodeWithTag(Constants.TEST_TAG_TEXTFIELD_BILl_AMOUNT).performTextInput(billAmount.toString())
        composeTestRule.onNodeWithTag(Constants.TEST_TAG_TEXTFIELD_TIP_PERCENTAGE).performTextInput(tipPercentage.toString())
        val expectedTip = NumberFormat.getCurrencyInstance().format(get_tip_percentage(billAmount, tipPercentage))

        val tipAmountNode = composeTestRule.onNodeWithTag(Constants.TEST_TAG_TEXT_TIP_AMOUNT)
        tipAmountNode.assertExists()

        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
            "No node with this text was found."
        )
    }
}