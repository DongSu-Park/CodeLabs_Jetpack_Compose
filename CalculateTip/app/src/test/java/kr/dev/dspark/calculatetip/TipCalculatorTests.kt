package kr.dev.dspark.calculatetip

import org.junit.Assert.assertEquals
import org.junit.Test

class TipCalculatorTests {
    @Test
    fun calculate_20_percent_tip_no_roundup() {
        // 20% tip을 반올림 없이 계산하는 테스트
        val amount = 10.00
        val tipPercent = 20.00

        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)
        val expectedTip = "$2.00"

        assertEquals(expectedTip, actualTip)
    }
}