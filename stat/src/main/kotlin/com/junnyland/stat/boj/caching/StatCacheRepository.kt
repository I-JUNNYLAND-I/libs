package com.junnyland.stat.boj.caching

import org.springframework.data.repository.CrudRepository

interface StatCacheRepository :CrudRepository<Stat, String>