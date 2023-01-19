package com.junnyland.stat.instagram.application.port.`in`

import com.junnyland.stat.instagram.application.domain.ProfileInfo
import com.junnyland.stat.instagram.application.port.out.InstaUserOutPort

interface GetProfileUsecase {

    fun getInstaProfile(userId: String): ProfileInfo


    class GetProfileInstagram(
        private val instaUserOutPort: InstaUserOutPort
    ) : GetProfileUsecase {

        override fun getInstaProfile(userId: String): ProfileInfo {
            return instaUserOutPort.findUserById(userId)
        }
    }
}