package com.gamil.moahear.calculator.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.gamil.moahear.calculator.utils.CalculatorAction
import com.gamil.moahear.calculator.utils.CalculatorOperation
import com.gamil.moahear.calculator.utils.CalculatorState
import java.math.BigDecimal
import java.math.MathContext

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> {
                enterNumber(action.number)
            }

            is CalculatorAction.Clear -> {
                clearAll()
            }

            is CalculatorAction.Decimal -> {
                enterDecimal()
            }

            is CalculatorAction.Delete -> {
                delete()
            }

            is CalculatorAction.Operation -> {
                enterOperation(action.operation)
            }

            is CalculatorAction.Calculate -> {
                calculate()
            }
        }
    }

    private fun calculate() {
        val numberOne = state.numberOne.toBigDecimalOrNull()
        val numberTwo = state.numberTwo.toBigDecimalOrNull()
        if (numberOne != null && numberTwo != null) {
            val result = when (state.operation) {
                is CalculatorOperation.Add -> numberOne .add(numberTwo)
                is CalculatorOperation.Minus -> numberOne .minus(numberTwo)
                is CalculatorOperation.Division -> numberOne .divide(numberTwo, MathContext.DECIMAL128)
                is CalculatorOperation.Multiplication -> numberOne .multiply(numberTwo)
                null -> return
            }
            state = state.copy(numberOne = result.toString(), numberTwo = "", operation = null)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && state.numberOne.isNotBlank() && !state.numberOne.contains('.')) {
            state = state.copy(numberOne = state.numberOne + '.')
            return
        } else if (state.numberTwo.isNotBlank() && !state.numberTwo.contains('.')) {
            state = state.copy(numberTwo = state.numberTwo + '.')
        }
    }

    private fun enterOperation(calculatorOperation: CalculatorOperation) {
        if (state.numberOne.isNotBlank()) {
            state = state.copy(operation = calculatorOperation)
        }
    }

    private fun clearAll() {
        state = state.copy(numberOne = "", numberTwo = "", operation = null)
        //state=CalculatorState()
    }

    private fun delete() {
        when {
            state.numberTwo.isNotBlank() -> {
                state = state.copy(numberTwo = state.numberTwo.dropLast(1))
            }

            state.operation != null -> {
                state = state.copy(operation = null)
            }

            state.numberOne.isNotBlank() -> {
                state = state.copy(numberOne = state.numberOne.dropLast(1))
            }
        }
    }

    private fun enterNumber(number: BigDecimal) {
        if (state.operation == null) {
            /*if (state.numberOne.length >= Constants.MAX_LENGTH) {
                return
            }*/
            state = state.copy(numberOne = state.numberOne + number)
            return
        }

        /*if (state.numberTwo.length >= Constants.MAX_LENGTH) {
            return
        }*/
        state = state.copy(numberTwo = state.numberTwo + number)
    }
}