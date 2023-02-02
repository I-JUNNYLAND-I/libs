package com.junnyland.stat.insta.adpater.out

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File

class FindUserTest {
    val finduser: FindUser = FindUser.BySelenium()

    @BeforeEach
    fun setup() {
        val osName = System.getProperty("os.name").toLowerCase()
        if (osName.contains("win")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver_Win32.exe")
        } else if (osName.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver_mac")
        } else {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver_linux")
        }
    }

    @Test
    fun findTest() {
        finduser.by("junnyland")
    }
}