package com.junnyland.stat.boj.caching

import com.junnyland.stat.boj.bojClient.Boj
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

interface StatCache {
    fun exists(userId: String): Boolean
    fun find(userId: String): Boj

    fun save(boj: Boj, userId: String)
    fun findAll(): Iterable<Stat>

    @Repository
    class StatCacheImpl(
        private val statCacheRepository: StatCacheRepository
    ) : StatCache {
        override fun exists(key: String) = statCacheRepository.existsById(key)
        override fun find(key: String) = statCacheRepository.findByIdOrNull(key)
            ?.run(Stat::toDomain)
            ?: throw IllegalArgumentException("Not Found")

        override fun save(boj: Boj, userId: String) {
            CoroutineScope(Dispatchers.Default).launch {
                statCacheRepository.save(Stat(boj, userId))
            }
        }

        override fun findAll(): Iterable<Stat> = statCacheRepository.findAll()
    }
}
