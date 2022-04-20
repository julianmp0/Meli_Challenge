package com.meli.challenge.data.models


import com.google.gson.annotations.SerializedName

data class Metrics(
    @SerializedName("cancellations")
    val cancellations: Cancellations,
    @SerializedName("claims")
    val claims: Claims,
    @SerializedName("delayed_handling_time")
    val delayedHandlingTime: DelayedHandlingTime,
    @SerializedName("sales")
    val sales: Sales
)