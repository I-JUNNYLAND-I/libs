package com.junnyland.stat.selenium

import org.springframework.boot.CommandLineRunner
import org.springframework.core.io.DefaultResourceLoader
import org.springframework.stereotype.Service
import java.lang.System.getProperty
import java.lang.System.setProperty
import java.util.Locale.getDefault

private fun isWin(os: String) = os.contains("win")
private fun isMac(os: String) = os.contains("mac")

@Service
class SeleniumConfig(
    private val resourceLoader: DefaultResourceLoader,
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        setup()
    }

    fun setup() = getProperty(OS).lowercase(getDefault()).let {
        when {
            isWin(it) -> setProperty(DRIVER, driverPath("chromedriver_Win32.exe"))
            isMac(it) -> setProperty(DRIVER, driverPath("chromedriver_mac"))
            else -> setProperty(DRIVER, driverPath("chromedriver_linux"))
        }
    }

    private fun driverPath(driver: String) =
        resourceLoader.getResource("classpath:driver/${driver}").file.absolutePath

    companion object {
        private const val DRIVER: String = "webdriver.chrome.driver"
        private const val OS: String = "os.name"
    }
}