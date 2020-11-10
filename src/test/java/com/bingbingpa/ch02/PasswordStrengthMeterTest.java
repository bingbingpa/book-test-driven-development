package com.bingbingpa.ch02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {
    private final PasswordStrengthMeter meter = new PasswordStrengthMeter();

    @Test
    @DisplayName("모든 규칙을 충족하는 경우")
    void meetsAllCriteria_Then_String() {
        PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, result);
        PasswordStrength result2 = meter.meter("abc1!Add");
        assertEquals(PasswordStrength.STRONG, result2);
    }

    @Test
    @DisplayName("길이만 8글자 미만이고 나머지 조건은 충족하는 경우")
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        PasswordStrength result = meter.meter("ab12!@A");
        assertEquals(PasswordStrength.NORMAL, result);
        PasswordStrength result2 = meter.meter("Ab12!c");
        assertEquals(PasswordStrength.NORMAL, result2);
    }

    @Test
    @DisplayName("숫자를 포함하지 않고 나머지 조건은 충족하는 경우 ")
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        PasswordStrength result = meter.meter("ab!@ABqwer");
        assertEquals(PasswordStrength.NORMAL, result);
    }
}
