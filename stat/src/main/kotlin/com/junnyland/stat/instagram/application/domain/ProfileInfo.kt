package com.junnyland.stat.instagram.application.domain

data class ProfileInfo(
    val name: String,
    val follower: Int,
    val following: Int,
    val image: String
)
