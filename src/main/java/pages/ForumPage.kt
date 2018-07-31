package pages

import Config
import org.openqa.selenium.By

class ForumPage : Common() {
    fun clickOnSubforumByName(subforumName: String) {
        Config.driver.findElements(By.className("forumtitle")).forEach {
            if (it.text == subforumName) {
                it.click()
                return
            }
        }
    }


}