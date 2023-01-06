package com.junnyland.stat.boj.caching

import com.junnyland.stat.boj.bojClient.Boj
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface StatCache{
    fun exists(userId: String): Boolean
    fun find(userId: String): Boj
    fun save(boj: Boj, userId:String): Stat?
    fun finaAll(): Any

    @Repository
    class StatCacheImpl(
        private val statCacheRepository: StatCacheRepository
    ) : StatCache {

        override fun exists(key:String)= statCacheRepository.existsById(key)
        override fun find(key:String)= statCacheRepository.findByIdOrNull(key)
            ?.let { it.toDomain() }
            ?: throw Exception("Not Found")
        @Transactional
        override fun save(boj: Boj, userId:String) = statCacheRepository.save(Stat(boj,userId))
        override fun finaAll() = statCacheRepository.findAll()
    }
}
