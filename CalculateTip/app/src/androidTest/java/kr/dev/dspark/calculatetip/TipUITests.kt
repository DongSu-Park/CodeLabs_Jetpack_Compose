package kr.dev.dspark.calculatetip

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import kr.dev.dspark.calculatetip.ui.theme.CalculateTipTheme
import org.junit.Rule
import org.junit.Test

class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        // 20%의 tip을 계산하는 UI 계측 테스트
        composeTestRule.setContent {
            CalculateTipTheme {
                Surface(modifier = Modifier.fillMaxWidth()) {
                    DisplayCalcTip()
                }
            }
        }

        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip (%)").performTextInput("20")
        composeTestRule.onNodeWithText("Tip amount: $2.00").assertExists()
    }
}