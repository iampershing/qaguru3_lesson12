package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Feature("QA.Guru Homework")
@Story("Homework")
public class SelenideGitHubTests extends TestBase {

    @Test
    @Issue("JIRA-123321")
    @DisplayName("Using Selenide - Check That Homework for Lecture 5 Exist")
    @Description("Verification that homework have been completed")
    @Tag("GitHub")
    @Owner("Sergei P")
    @Severity(SeverityLevel.TRIVIAL)
    public void assertThatLectureFiveHomeworkExistUsingPureSelenide() {
        open(URL);
        $(".header-search-input").click();
        $(".header-search-input").setValue(USER);
        $(".header-search-input").pressEnter();
        $(byText("Users")).click();
        $(".user-list").shouldHave(text(USER));
        $(byLinkText(USER)).click();
        $(withText(NAME)).should(exist);
    }

    @Test
    @DisplayName("Using Selenide - Check That it is possible to create an issue")
    @Description("Verification that it is possible to create an issue on github using pure selenide")
    @Tag("GitHub")
    @Owner("Sergei P")
    @Severity(SeverityLevel.CRITICAL)
    public void createIssueOnGithubUsingPureSelenideTest() {
        open(URL);
        $("[href='/login']").click();
        $("#login_field").val("UserForEducation");
        $("#password").val("EduPass123");
        $("[name='commit']").click();
        $(".header-search-input").click();
        $(".header-search-input").setValue(REPO);
        $(".header-search-input").pressEnter();
        $(byLinkText(REPO)).click();
        $("[data-tab-item='issues-tab']").click();
        $(".js-cookie-consent-accept").click();
        $x("//span[contains(text(),'New issue')]").should(enabled).click();
        $("#issue_title").should(visible).val(TITLE);
        $("#issue_body").should(visible).val(DESC);
        $(byText("assign yourself")).click();
        $(byText("Labels")).click();
        $("#label-filter-field").val("bug");
        $(".label-select-menu-item").$(byText("bug")).click();
        $(".label-select-menu-item").pressEscape();
        $(byText("Submit new issue")).click();
        $("[data-tab-item='issues-tab']").click();
        $(byText(TITLE)).should(exist);
        $(byText(TITLE)).click();
        $(byText("Delete issue")).click();
        $("[name='verify_delete']").click();
        $("[data-tab-item='issues-tab']").click();
        $(byText(TITLE)).shouldNot(visible);
    }
}
