package com.nurda.rahmetapp.model

data class Data(
    val address: Address,
    val categories: List<Category>,
    val hashtags: List<Hashtag>,
    val id: Int,
    val images: List<String>,
    val name: String,
    val partner: Partner,
    val phones: List<String>,
    val rating: Rating,
    val regime: List<Regime>,
    val rule: Rule,
    val town_id: Int
)