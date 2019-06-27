package com.nurda.rahmetapp.model

data class Regime(
    val day: Int,
    val end: String,
    val lunch: Lunch,
    val start: String,
    val status: Int
)