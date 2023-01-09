package com.junnyland.stat.boj.caching

import com.junnyland.stat.boj.bojClient.Boj
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.time.LocalDateTime
import java.util.*


@RedisHash("stat")
class Stat(
    @Id val name: String,
    val grade: String,
    val submit: String,
    val solved: String,
    val fail: String,
    val badge: String,
    val myPage: String,
    @TimeToLive var expire: Long = 60 * 60 * 24,
    val createAt: LocalDateTime = LocalDateTime.now(),
) {
    constructor(boj: Boj, userId: String) : this(
        name = userId,
        grade = boj.grade,
        submit = boj.submit,
        solved = boj.solved,
        fail = boj.fail,
        badge = boj.badge,
        myPage = boj.myPage
    )

    fun toDomain() = Boj(
        grade = grade,
        submit = submit,
        solved = solved,
        fail = fail,
        badge = badge,
        myPage = myPage,
    )
}