package pages

import Config
import org.openqa.selenium.support.ui.WebDriverWait

open class Common {
    fun open(url: String) {
        Config.driver.get(url)
    }

    fun close() {
        Config.driver.close()
        Config.driver.quit()
    }

    val webDriverWait = WebDriverWait(Config.driver, 15)

    // do odkomentowania w razie potrzeb, chwilowo zbedne
//    val jsExecutorInBrowser = Config.driver as JavascriptExecutor
}