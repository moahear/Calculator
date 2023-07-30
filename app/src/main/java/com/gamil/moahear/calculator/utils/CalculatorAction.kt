package com.gamil.moahear.calculator.utils

import java.math.BigDecimal


sealed class CalculatorAction{
    data class Number(val number: BigDecimal):CalculatorAction()
    object Clear:CalculatorAction()
    object Delete:CalculatorAction()
    data class Operation(val operation: CalculatorOperation):CalculatorAction()
    object Calculate:CalculatorAction()
    object Decimal:CalculatorAction()
}
