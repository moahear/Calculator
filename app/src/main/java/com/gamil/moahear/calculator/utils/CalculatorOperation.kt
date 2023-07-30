package com.gamil.moahear.calculator.utils

sealed class CalculatorOperation(val symbol:String){
    object Add:CalculatorOperation(symbol="+")
    object Minus:CalculatorOperation(symbol="-")
    object Multiplication:CalculatorOperation(symbol="×")
    object Division:CalculatorOperation(symbol="÷")
}
