package com.junnyland.stat.instagram.application.adapter.out

import com.junnyland.stat.config.ApiClient
import com.junnyland.stat.config.ApiConfig
import org.junit.jupiter.api.Test

class InstaUserOutAdapterTest {

    @Test
    fun `get insta profile`() {
        val instaUserOutAdapter: InstaUserOutAdapter = InstaUserOutAdapter(
            "https://graph.instagram.com/",
            "v15.0/",
            "IGQVJYTVg1WXBVOFJWVlYwRUl4V3JjODctU21nbTRrYW1qdG9jMTlLcW5JTXgtZAHpDaF8tYUxST2JscXRSNUV0SFl2dmxWN3ZAleDQyQnRNRnJWTjZAHS1pPZAUN0QVhlaldDSWJrRUhHdWIycWxpZATk3TgZDZD",
            ApiClient(ApiConfig().webClient())
        )

        instaUserOutAdapter.findUserById("wjwan0")


    }
}