package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Feature("QA.Guru Homework")
@Story("Homework")
public class LambdaGitHubTests extends TestBase {

    @Test
    @Issue("JIRA-123321")
    @DisplayName("Using Lambda - Check That Homework for Lecture 5 Exist")
    @Description("Verification that homework have been completed")
    @Tag("GitHub")
    @Owner("Sergei P")
    @Severity(SeverityLevel.TRIVIAL)
    public void assertThatLectureFiveHomeworkExistUsingLambda() {
        step("Open GitHub page", (step) -> {
            open(URL);
        });
        step("Search for repository", (step) -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(USER);
            $(".header-search-input").pressEnter();
        });
        step("Search for the user", (step) -> {
            $(byText("Users")).click();
            $(".user-list").shouldHave(text(USER));
        });
        step("Open user page", (step) -> {
            $(byLinkText(USER)).click();
        });
        step("Assert that homework exist", (step) -> {
            $(withText(NAME)).should(exist);
        });
    }

    @Test
    @DisplayName("Using Lambda Steps - Check That it is possible to create an issue")
    @Description("Verification that it is possible to create an issue on github using lambda steps")
    @Tag("GitHub")
    @Owner("Sergei P")
    @Severity(SeverityLevel.CRITICAL)
    public void createIssueOnGithubUsingLambdaStepsTest() {
        step("Open GitHub page", (step) -> {
            open(URL);
        });
        step("Login to Github", (step) -> {
            $("[href='/login']").click();
            $("#login_field").val("UserForEducation");
            $("#password").val("EduPass123");
            $("[name='commit']").click();
        });
        step("Search for repository", (step) -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPO);
            $(".header-search-input").pressEnter();
        });
        step("Open repository", (step) -> {
            $(byLinkText(REPO)).click();
        });
        step("Open issue tab", (steo) -> {
            $("[data-tab-item='issues-tab']").click();
            $(".js-cookie-consent-accept").click();
        });
        step("Click on submit new issue tab", (step) -> {
            $x("//span[contains(text(),'New issue')]").should(enabled).click();
        });
        step("Fill the title and body form", (step) -> {
            $("#issue_title").should(visible).val(TITLE);
            $("#issue_body").should(visible).val(DESC);
        });
        step("Assign user", (step) -> {
            $(byText("assign yourself")).click();
        });
        step("Assign labels", (step) -> {
            $(byText("Labels")).click();
            $("#label-filter-field").val("bug");
            $(".label-select-menu-item").$(byText("bug")).click();
            $(".label-select-menu-item").pressEscape();
        });
        step("Submit the issue", (step) -> {
            $(byText("Submit new issue")).click();
        });
        step("Verify that issue exist", (step) -> {
            $("[data-tab-item='issues-tab']").click();
            $(byText(TITLE)).should(exist);
        });
        step("Delete issue", (step) -> {
            $(byText(TITLE)).click();
            $(byText("Delete issue")).click();
            $("[name='verify_delete']").click();
        });
        step("Verify that issue deleted", (step) -> {
            $("[data-tab-item='issues-tab']").click();
            $(byText(TITLE)).shouldNot(visible);
        });
    }
}
