package pages

import Config
import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.shouldBe
import net.bytebuddy.utility.RandomString
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.xdescribe

class ForumPageSpec : Spek({
    describe("Testy landing page") {
        val forumPage = ForumPage()
        val subforumPage = SubforumPage()
        val username = Config.username
        val password = Config.password
        val siteTitle = Config.siteMainTitle


        val subforumName = "Grzesiek"

        beforeEachTest { forumPage.open(Config.forumUrl) }


        xdescribe("ZAD1:Używając nazwy: $username: oraz hasła: $password, zaloguj się do forum") {
            it("Forum poprawnie loguje użytkownika $username") {
                forumPage.loginUser(username, password)
                forumPage.getUsernameFromNavBar() shouldBe username
                forumPage.logoutIsActive() shouldBe true
//                forumPage.logoutUser()
            }
        }
        xdescribe("ZAD2: Po wejściu na forum sprwadź czy tytuł strony to $siteTitle") {
            it("Tytuł strony jest zgodny z podanym: $siteTitle") {
                forumPage.getPageTitle() shouldBe siteTitle
            }
        }
        xdescribe("ZAD3: Po zalogowaniu się na forum, użytkownik wchodzi w subforum o nazwie $subforumName") {
            it("Użytkownik jest w subforum $subforumName") {
                forumPage.loginUser(username, password)
                forumPage.clickOnSubforumByName(subforumName)
                subforumPage.getActualSubforumName() shouldBe subforumName
            }
        }
        describe("ZAD4: Po wejściu w subforum $subforumName użytkownik zakłada nowy temat") {
            it("Po zapisaniu w subforum widoczny jest dopiero co załozony temat") {
                forumPage.loginUser(username, password)
                forumPage.clickOnSubforumByName(subforumName)
                val topicTitle = RandomString.make(20)
                val topicDescription = RandomString.make(250)
                subforumPage.addNewTopic(topicTitle, topicDescription)
                subforumPage.goToSubforumPage(subforumName)
                subforumPage.getTitlesOfTopics().shouldContain(topicTitle)
            }
        }
        afterEachTest { forumPage.logoutUser() }
        afterGroup { forumPage.close() }
    }



} // this spec end
) // spek end