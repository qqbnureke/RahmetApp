package com.nurda.rahmetapp.model

data class RahmetResponse(
    val `data`: Data,
    val error_code: Int,
    val message: String,
    val status: String
)