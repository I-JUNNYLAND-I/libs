package com.junnyland.stat.caching

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.connection.RedisConfiguration

@SpringBootTest
class StatTest{
    @Autowired
    lateinit var statCacheRepository: StatCacheRepository

    @Test
    fun `saveTest`(){
        val save = statCacheRepository.save(Stat(name = "test"))
        println(save)
    }
}