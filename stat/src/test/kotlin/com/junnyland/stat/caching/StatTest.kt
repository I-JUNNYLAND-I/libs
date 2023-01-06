package com.junnyland.stat.caching

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

//@Disabled
@SpringBootTest(args = ["--spring.data.redis.host=db.junnyland.com"])
class StatTest {
    @Autowired
    lateinit var statCacheRepository: StatCacheRepository

    @Test
    fun `saveTest`() {
        Stat(
            name = "test",
            grade = "test",
            submit = "test",
            solved = "test",
            fail = "test",
            badge = "test",
            myPage = "test"
        ).let {
            statCacheRepository.save(it)
        }.also {
            println(it)
        }
    }
}