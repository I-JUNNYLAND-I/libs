package com.junnyland.stat.service

import com.junnyland.stat.bojClient.Boj
import com.junnyland.stat.bojClient.ParserBoj
import com.junnyland.stat.caching.StatCache
import org.slf4j.LoggerFactory.getLogger
import org.springframework.stereotype.Service

interface FindUser {
    fun findUser(userId: String): Boj

    @Service
    class FindUserService(
        private val parserBoj: ParserBoj,
        private val statCache: StatCache
    ): FindUser {
        val log = getLogger("USER")
        override fun findUser(userId: String): Boj =
            if(statCache.exists(userId)) statCache.find(userId)
                .also { log.info("Cache Hit {}",userId) }
            else parserBoj.call(userId)
                .also { log.info("Cache Miss {}",userId) }
                .also { statCache.save(it,userId) }
    }
}