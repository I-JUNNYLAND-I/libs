package com.junnyland.stat.instagram.application.port.out

import com.junnyland.stat.instagram.application.domain.ProfileInfo

interface InstaUserOutPort {

    fun findUserById(userId: String): ProfileInfo

}