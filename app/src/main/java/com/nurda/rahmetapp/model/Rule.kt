package com.nurda.rahmetapp.model

data class Rule(
    val cashback: String,
    val cashback_account: CashbackAccount,
    val cashback_account_id: Int,
    val cashback_limit: Int,
    val commission: String,
    val contract_id: Int,
    val create_at: String,
    val filial_id: Int,
    val grade_id: Any,
    val id: Int,
    val is_active: Boolean,
    val max_pay_amount: Int,
    val order_min_amount: Int,
    val special_offer_text: Any,
    val special_offer_type: Any,
    val update_at: Any
)