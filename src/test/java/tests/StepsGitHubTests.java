package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("QA.Guru Homework")
@Story("Homework")
public class StepsGitHubTests extends TestBase {

    @Test
    @DisplayName("Using Steps - Check That Homework for Lecture 5 Exist")
    @Description("Verification that homework have been completed")
    @Tag("GitHub")
    @Owner("Sergei P")
    @Severity(SeverityLevel.TRIVIAL)
    public void assertThatLectureFiveHomeworkExistUsingSteps() {
        steps.openUrl();
        steps.searchForRepository();
        steps.searchForUser();
        steps.openUserPage();
        steps.assertThatHomeworkExist();
    }

    @Test
    @DisplayName("Using Steps - Check That it is possible to create an issue")
    @Description("Verification that it is possible to create an issue on github using steps")
    @Tag("GitHub")
    @Owner("Sergei P")
    @Severity(SeverityLevel.CRITICAL)
    public void createIssueOnGithubUsingStepsTest() {
        steps.openUrl();
        steps.login();
        steps.searchForSpecificRepository();
        steps.openRepository();
        steps.openIssueTab();
        steps.clickOnSubmitNewIssue();
        steps.fillTheTitleAndBodyForm();
        steps.assignUser();
        steps.assignLabels();
        steps.submitTheIssue();
        steps.verifyThatIssueExist();
        steps.deleteTheIssue();
        steps.verifyThatIssueDeleted();
    }
}
