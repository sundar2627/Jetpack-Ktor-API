package com.example.jetpackktorimplementation
import kotlinx.serialization.Serializable

@Serializable
data class Feed(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)