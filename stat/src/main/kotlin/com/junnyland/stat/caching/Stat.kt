package com.junnyland.stat.caching

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.time.LocalDateTime
import java.util.*


@RedisHash("stat")
class Stat(
    val name: String = "",
    @TimeToLive var expire: Long = 60 * 60 * 24 * 7,
    val createAt:LocalDateTime = LocalDateTime.now(),
    @Id val id: UUID = UUID.randomUUID()
)