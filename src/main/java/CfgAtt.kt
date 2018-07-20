import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

object Config {
    val username = "noop"
    val password = "noop12"
    val forumUrl = "forum.attnauka.webd.pro"

    val driver: WebDriver by lazy {
        val driver = ChromeDriver()
        driver
    }
}