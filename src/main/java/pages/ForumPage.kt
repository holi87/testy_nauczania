package pages

import Config
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions

class ForumPage : Common() {
    fun clickOnSubforumByName(subforumName: String) {
        Config.driver.findElements(By.className("forumtitle")).forEach {
            if (it.text == subforumName) {
                it.click()
                return
            }
        }
    }

    fun getActualSubforumName(): String {
        webDriverWait.until(ExpectedConditions.urlContains("viewforum"))
        return Config.driver.findElement(By.className("forum-title")).text
    }
}