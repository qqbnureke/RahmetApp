package com.nurda.rahmetapp.model

data class Response(
    val `data`: Data,
    val error_code: Int,
    val message: String,
    val status: String
)