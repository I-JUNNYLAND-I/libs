package com.junnyland.stat.caching

import org.springframework.data.repository.CrudRepository
import java.util.*

interface StatCacheRepository :CrudRepository<Stat, UUID> {

}