package com.junnyland.stat.insta.adpater.out

import org.openqa.selenium.By
import org.openqa.selenium.PageLoadStrategy
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.springframework.stereotype.Service
import java.lang.Thread.sleep

interface FindUser {
    fun by(userId: String): Any

    @Service
    class BySelenium : FindUser {
        override fun by(userId: String): Any {
            val dirver = driver()
                .also { it.get(URL+userId) }

            // class name "x6umtig x1b1mbwd xaqea5y xav7gou xk390pu x5yr21d xpdipgo xdj266r x11i5rnm xat24cr x1mh8g0r xexx8yu x4uap5 x18d9i69 xkhd6sd x11njtxf xh8yej3"
            val data = dirver.findElements(By.className("x6umtig"))
            val findElements = dirver.findElements(By.className("x6umtig"))
            val userId= """
                #mount_0_0_cH > div > div > div > div.x9f619.x1n2onr6.x1ja2u2z > div > div > div > div.x78zum5.xdt5ytf.x10cihs4.x1t2pt76.x1n2onr6.x1ja2u2z > section > main > div > header > section > div.x6s0dn4.x78zum5.x1q0g3np.xs83m0k.xeuugli.x1n2onr6 > h2
            """.trim()
            val image = dirver.findElement(By.cssSelector("/div/div/div/div[1]/div/div/div/div[1]/section/main/div/header/div/div/span/img"))
            val usreId = dirver.findElement(By.xpath("//*[@id=\"mount_0_0_0Q\"]/div/div/div/div[1]/div/div/div/div[1]/section/main/div/header/section/div[1]/h2"))
            val name = dirver.findElement(By.xpath("//*[@id=\"mount_0_0_0Q\"]/div/div/div/div[1]/div/div/div/div[1]/section/main/div/header/section/div[1]/h2"))
            val follower = dirver.findElement(By.xpath("//*[@id=\"mount_0_0_0Q\"]/div/div/div/div[1]/div/div/div/div[1]/section/main/div/div[1]/spanS"))
            val follow = dirver.findElement(By.xpath("//*[@id=\"mount_0_0_0Q\"]/div/div/div/div[1]/div/div/div/div[1]/section/main/div/ul/li[3]/button/div/span/span"))
            println("dirver = ${dirver}")
            return ""
        }

        fun driver()=ChromeOptions()
            .also {
                it.setPageLoadStrategy(PageLoadStrategy.NORMAL)
                it.addArguments("--disable-gpu")
                it.addArguments("--disable-extensions")
                it.addArguments("--proxy-bypass-list=*")
                it.addArguments("--headless")

            }
            .let { ChromeDriver(it) }

        companion object {
            private const val URL = "https://www.instagram.com/"
        }
    }
}