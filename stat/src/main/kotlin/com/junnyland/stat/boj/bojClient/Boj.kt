package com.junnyland.stat.boj.bojClient

data class Boj(
    val grade: String,
    val submit: String,
    val solved: String,
    val fail: String,
    val badge: String,
) {
    companion object {
        fun convert(datas: List<String>, badge: String) = Boj(
            grade = datas[1],
            submit = datas[11],
            solved = datas[13],
            fail = datas[18],
            badge = badge
        )
    }
}