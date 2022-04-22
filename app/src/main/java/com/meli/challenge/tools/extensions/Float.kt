package com.meli.challenge.tools.extensions

import java.text.DecimalFormat
import java.text.NumberFormat


fun Float.formatToCurrency(): String {
    val formatter: NumberFormat = DecimalFormat("#,###")
    return "$ ${formatter.format(this)}"
}