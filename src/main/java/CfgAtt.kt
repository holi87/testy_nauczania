import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object Config {
    const val username = "noop"
    const val password = "noop12"
    const val forumUrl = "http://forum.attnauka.webd.pro"

    val driver: WebDriver by lazy {
        val driver = ChromeDriver()
        driver
    }
}