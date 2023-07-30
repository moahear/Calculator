package com.gamil.moahear.calculator.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    modifier: Modifier = Modifier,
    symbol: String,
    color: Color = Color.White,
    textStyle: TextStyle = TextStyle(),
    onClick: () -> Unit
) {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(100.dp))
        .background(color = color)
        .clickable {
            onClick()
        }
        .then(modifier), contentAlignment = Alignment.Center
    ) {
        Text(text = symbol,color = Color.White,style = textStyle, fontSize = 36.sp)
    }
}

@Preview
@Composable
fun CalculatorButtonPreview() {
    CalculatorButton(symbol = "+") {
    }
}