package com.junnyland.stat.instagram.application.adapter.out

import com.junnyland.stat.config.ApiClient
import com.junnyland.stat.instagram.application.domain.ProfileInfo
import com.junnyland.stat.instagram.application.port.out.InstaUserOutPort
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Repository

@Repository
class InstaUserOutAdapter(
    @Value("\${instagram.url}") private val url: String,
    @Value("\${instagram.api}") private val version: String,
    @Value("\${instagram.token}") private val token: String,
    private val apiClient: ApiClient
) : InstaUserOutPort {
    override fun findUserById(userId: String): ProfileInfo {
        val allUrl = url.plus(version)
            .plus(userId)
            .plus("?fields=id,username")
            .plus("&access_token=${token}")
        apiClient.get(allUrl)
            .run { println(this) }

        return ProfileInfo("", 1, 1, "")
    }

}