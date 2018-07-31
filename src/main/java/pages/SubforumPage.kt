package pages


import Config
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions

class SubforumPage : Common() {
    fun getActualSubforumName(): String {
        webDriverWait.until(ExpectedConditions.urlContains("viewforum"))
        return Config.driver.findElement(By.className("forum-title")).text
    }

    fun addNewTopic(topicTitle: String, topicDescription: String) {
        Config.driver.findElement(By.xpath("//*[@title='Post a new topic']")).click()

        val topicInputBox = Config.driver.findElement(By.id("subject"))
        topicInputBox.clear()
        topicInputBox.sendKeys(topicTitle)

        val topicDescriptionInputBox = Config.driver.findElement(By.id("message"))
        topicDescriptionInputBox.clear()
        topicDescriptionInputBox.sendKeys(topicDescription)

        Config.driver.findElement(By.name("post")).click()
    }

    fun goToSubforumPage(subforumName: String) {
        Config.driver.findElement(By.xpath("//a[@title='$subforumName']")).click()
    }

    fun getTitlesOfTopics(): List<String> {
        val listOfTitles: ArrayList<String> = arrayListOf()
        Config.driver.findElements(By.className("topictitle")).forEach {
            listOfTitles.add(it.text)
        }
        return listOfTitles
    }
}

