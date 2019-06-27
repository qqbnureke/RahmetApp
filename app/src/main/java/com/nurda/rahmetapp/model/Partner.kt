package com.nurda.rahmetapp.model

data class Partner(
    val category: Category,
    val description: String,
    val filials: List<Any>,
    val id: Int,
    val logotype_url: String,
    val name: String,
    val social_networks: SocialNetworks,
    val website_url: String
)