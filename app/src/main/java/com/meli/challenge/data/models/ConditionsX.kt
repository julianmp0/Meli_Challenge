package com.meli.challenge.data.models


import com.google.gson.annotations.SerializedName

data class ConditionsX(
    @SerializedName("context_restrictions")
    val contextRestrictions: List<String>,
    @SerializedName("eligible")
    val eligible: Boolean,
    @SerializedName("end_time")
    val endTime: Any,
    @SerializedName("start_time")
    val startTime: Any
)