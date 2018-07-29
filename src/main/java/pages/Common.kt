package pages

import Config
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

open class Common {
    fun open(url: String) {
        Config.driver.get(url)
    }

    fun close() {
        Config.driver.close()
        Config.driver.quit()
    }

    val webDriverWait = WebDriverWait(Config.driver, 5)

    private fun clickLogin() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login")))
        Config.driver.findElement(By.xpath("//*[@id='nav-main']//a[@title='Login']")).click()
    }

    private fun fillUsernameAndPassword(username: String, password: String) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-title")))
        val usernameBox = Config.driver.findElement(By.id("username"))
        val passwordBox = Config.driver.findElement(By.id("password"))
        usernameBox.clear()
        usernameBox.sendKeys(username)
        passwordBox.clear()
        passwordBox.sendKeys(password)
    }

    private fun clickLoginButton() {
        Config.driver.findElement(By.className("button1")).click()
    }

    fun loginUser(username: String, password: String) {
        clickLogin()
        fillUsernameAndPassword(username, password)
        clickLoginButton()
    }

    fun getUsernameFromNavBar(): String {
        return Config.driver.findElement(By.id("username_logged_in")).text
    }

    fun logoutIsActive(): Boolean {
        return Config.driver.findElements(By.xpath("//*[@title='Logout']")).isNotEmpty()
    }

    fun getPageTitle(): String {
        return Config.driver.title
    }

    fun logoutUser() {
        if (logoutIsActive()) {
            clickDropdownListOnUsername()
            clickOnLogout()
        }
    }

    private fun clickOnLogout() {
        Config.driver.findElement(By.xpath("//*[@title='Logout']")).click()
    }

    private fun clickDropdownListOnUsername() {
        Config.driver.findElement(By.id("username_logged_in")).click()
    }

    //do odkomentowania w razie potrzeb, chwilowo zbedne
//    val jsExecutorInBrowser = Config.driver as JavascriptExecutor
}