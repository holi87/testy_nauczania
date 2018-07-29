package pages

import Config
import io.kotlintest.shouldBe
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class ForumPageSpec : Spek({
    describe("Testy landing page") {
        val forumPage = ForumPage()
        val username = Config.username
        val password = Config.password
        val siteTitle = Config.siteMainTitle


        val subforumName = "Grzesiek"

        beforeEachTest { forumPage.open(Config.forumUrl) }


        describe("Używając nazwy: $username: oraz hasła: $password, zaloguj się do forum") {
            it("Forum poprawnie loguje użytkownika $username") {
                forumPage.loginUser(username, password)
                forumPage.getUsernameFromNavBar() shouldBe username
                forumPage.logoutIsActive() shouldBe true
                forumPage.logoutUser()
            }
        }
        describe("Po wejściu na forum sprwadź czy tytuł strony to $siteTitle") {
            it("Tytuł strony jest zgodny z podanym: $siteTitle") {
                forumPage.getPageTitle() shouldBe siteTitle
            }
        }
        describe("Po zalogowaniu się na forum, użytkownik wchodzi w subforum o nazwie $subforumName") {
            it("Użytkownik jest w subforum $subforumName") {
                forumPage.loginUser(username, password)
                forumPage.clickOnSubforumByName(subforumName)
                forumPage.getActualSubforumName() shouldBe subforumName
            }
        }
        afterGroup { forumPage.close() }
    }



} // this spec end
) // spek end