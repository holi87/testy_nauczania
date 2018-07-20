package pages

import Config
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class LandingPageSpec : Spek({
    describe("Testy landing page") {
        val landingPage = LandingPage()
        val username = Config.username
        val password = Config.password
        beforeEachTest { landingPage.open(Config.forumUrl) }
        describe("Używając nazwy: $username: oraz hasła: $password, zaloguj się do forum") {
            it("Forum poprawnie loguje użytkownika $username") {
                landingPage.loginUser(username, password)
                println(landingPage.logoutVisible())
                println(landingPage.getUsernameFromNavBar())
            }
        }
        afterGroup { landingPage.close() }
    }


} // this spec end
) // spek end