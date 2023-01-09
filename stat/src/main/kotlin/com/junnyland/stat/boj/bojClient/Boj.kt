package com.junnyland.stat.boj.bojClient

data class Boj(
    val grade: String,
    val submit: String,
    val solved: String,
    val fail: String,
    val badge: String,
) {
    companion object {
        fun mom(a: List<String>, b: String) = Boj(grade = profile[1],
            submit = profile[11],
            solved = profile[13],
            fail = profile[18],
            badge = badge)
    }
}