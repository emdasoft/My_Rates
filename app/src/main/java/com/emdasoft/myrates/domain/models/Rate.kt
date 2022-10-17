package com.emdasoft.myrates.domain.models

data class Rate(
    val date: String,
    val name: String,
    val buyRate: Double,
    val sellRate: Double,
)