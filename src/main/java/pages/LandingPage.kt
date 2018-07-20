package pages

import Config
import org.openqa.selenium.By

class LandingPage : Common() {
    fun clickLogin() {
        Config.driver.findElement(By.xpath("//*[@id='nav-main']//a[@title='Login']")).click()
    }

    private fun fillUsernameAndPassword(username: String, password: String) {
        val usernameBox = Config.driver.findElement(By.id("username"))
        val passwordBox = Config.driver.findElement(By.id("password"))
        usernameBox.clear()
        usernameBox.sendKeys(username)
        passwordBox.clear()
        passwordBox.sendKeys(password)
    }

    fun clickLoginButton() {
        Config.driver.findElement(By.className("button1")).click()
    }

    fun loginUser(username: String, password: String) {
        clickLogin()
        fillUsernameAndPassword(username, password)
        clickLoginButton()
    }

    fun getUsernameFromNavBar() {
        Config.driver.findElement(By.xpath("//ul[@id='nav-main']//span[@class='username']")).text
    }

    fun logoutVisible(): Boolean {
        return Config.driver.findElements(By.xpath("//*[@title='Logout']")).isNotEmpty()
    }
}