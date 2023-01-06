package com.junnyland.stat.caching

import org.springframework.data.repository.CrudRepository

interface StatCacheRepository :CrudRepository<Stat, String>