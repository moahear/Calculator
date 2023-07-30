package com.gamil.moahear.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gamil.moahear.calculator.component.CalculatorButton
import com.gamil.moahear.calculator.ui.theme.CalculatorTheme
import com.gamil.moahear.calculator.ui.theme.GrayLight
import com.gamil.moahear.calculator.ui.theme.VividGamboge
import com.gamil.moahear.calculator.utils.CalculatorAction
import com.gamil.moahear.calculator.utils.CalculatorOperation
import com.gamil.moahear.calculator.viewmodel.CalculatorViewModel
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val spacingButton=8.dp
            val calculatorViewModel= viewModel<CalculatorViewModel>()
            val state=calculatorViewModel.state
            CalculatorTheme {
                Box(modifier= Modifier
                    .fillMaxSize()
                    .background(color = Color.DarkGray)
                    .padding(16.dp)) {
                    Column(modifier= Modifier
                        .fillMaxSize()
                        .align(alignment = Alignment.BottomCenter), verticalArrangement = Arrangement.spacedBy(spacingButton, alignment = Alignment.CenterVertically)) {
                        Text(text = state.numberOne+(state.operation?.symbol ?: "")+state.numberTwo,modifier= Modifier
                            .fillMaxWidth()
                            .padding(vertical = 32.dp), lineHeight = 32.sp ,fontWeight = FontWeight.Light, fontSize = 32.sp, color = Color.White, maxLines = 3)
                        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(spacingButton, alignment = Alignment.CenterHorizontally)) {
                            CalculatorButton(symbol = "AC", color = GrayLight,modifier= Modifier
                                .aspectRatio(2f)
                                .weight(2f)) {
                                //Click
                                calculatorViewModel.onAction(CalculatorAction.Clear)
                            }
                            CalculatorButton(symbol = "DEL", color = GrayLight,modifier= Modifier
                                .aspectRatio(1f)
                                .weight(1f)) {
                                //click
                                calculatorViewModel.onAction(CalculatorAction.Delete)
                            }

                            CalculatorButton(symbol = "÷", color = VividGamboge,modifier= Modifier
                                .aspectRatio(1f)
                                .weight(1f)) {
                                //Click
                                calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Division))
                            }
                        }

                        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(spacingButton, alignment = Alignment.CenterHorizontally)) {
                            CalculatorButton(symbol = "7", color = GrayLight,modifier= Modifier
                                .aspectRatio(1f)
                                .weight(1f)) {
                                //Click
                                calculatorViewModel.onAction(CalculatorAction.Number(BigDecimal(7)))
                            }
                            CalculatorButton(symbol = "8", color = GrayLight,modifier= Modifier
                                .aspectRatio(1f)
                                .weight(1f)) {
                                //Click
                                calculatorViewModel.onAction(CalculatorAction.Number(BigDecimal(8)))
                            }

                            CalculatorButton(symbol = "9", color = GrayLight,modifier= Modifier
                                .aspectRatio(1f)
                                .weight(1f)) {
                                //Click
                                calculatorViewModel.onAction(CalculatorAction.Number(BigDecimal(9)))
                            }
                            CalculatorButton(symbol = "×", color = VividGamboge,modifier= Modifier
                                .aspectRatio(1f)
                                .weight(1f)) {
                                //Click
                                calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiplication))
                            }
                        }

                        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(spacingButton, alignment = Alignment.CenterHorizontally)) {
                            CalculatorButton(symbol = "4", color =GrayLight,modifier= Modifier
                                .aspectRatio(1f)
                                .weight(1f)) {
                                //Click
                                calculatorViewModel.onAction(CalculatorAction.Number(BigDecimal(4)))
                            }
                            CalculatorButton(symbol = "5", color = GrayLight,modifier= Modifier
                                .aspectRatio(1f)
                                .weight(1f)) {
                                //Click
                                calculatorViewModel.onAction(CalculatorAction.Number(BigDecimal(5)))
                            }

                            CalculatorButton(symbol = "6", color = GrayLight,modifier= Modifier
                                .aspectRatio(1f)
                                .weight(1f)) {
                                //Click
                                calculatorViewModel.onAction(CalculatorAction.Number(BigDecimal(6)))
                            }
                            CalculatorButton(symbol = "-", color = VividGamboge,modifier= Modifier
                                .aspectRatio(1f)
                                .weight(1f)) {
                                //Click
                                calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Minus))
                            }
                        }

                        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(spacingButton, alignment = Alignment.CenterHorizontally)) {
                            CalculatorButton(symbol = "1", color = GrayLight,modifier= Modifier
                                .aspectRatio(1f)
                                .weight(1f)) {
                                //Click
                                calculatorViewModel.onAction(CalculatorAction.Number(BigDecimal(1)))
                            }
                            CalculatorButton(symbol = "2", color = GrayLight,modifier= Modifier
                                .aspectRatio(1f)
                                .weight(1f)) {
                                //Click
                                calculatorViewModel.onAction(CalculatorAction.Number(BigDecimal(2)))
                            }

                            CalculatorButton(symbol = "3", color = GrayLight,modifier= Modifier
                                .aspectRatio(1f)
                                .weight(1f)) {
                                //Click
                                calculatorViewModel.onAction(CalculatorAction.Number(BigDecimal(3)))
                            }
                            CalculatorButton(symbol = "+", color = VividGamboge,modifier= Modifier
                                .aspectRatio(1f)
                                .weight(1f)) {
                                //Click
                                calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                            }
                        }

                        Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(spacingButton, alignment = Alignment.CenterHorizontally)) {
                            CalculatorButton(symbol = "0", color = GrayLight,modifier= Modifier
                                .aspectRatio(2f)
                                .weight(2f)) {
                                //Click
                                calculatorViewModel.onAction(CalculatorAction.Number(BigDecimal(0)))
                            }
                            CalculatorButton(symbol = ".", color =GrayLight,modifier= Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                            ) {
                                //Click
                                calculatorViewModel.onAction(CalculatorAction.Decimal)
                            }

                            CalculatorButton(symbol = "=", color = VividGamboge,modifier= Modifier
                                .aspectRatio(1f)
                                .weight(1f)) {
                                //Click
                                calculatorViewModel.onAction(CalculatorAction.Calculate)
                            }
                        }
                    }
                }
            }
        }
    }
}
