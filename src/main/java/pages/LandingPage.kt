package pages

import Config
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions

class LandingPage : Common() {
    fun clickLogin() {
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

    fun logoutVisible(): Boolean {
        return Config.driver.findElements(By.xpath("//*[@title='Logout']")).isNotEmpty()
    }
}