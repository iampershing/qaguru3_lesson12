package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Feature("QA.Guru Homework")
@Story("Homework")
public class DemoQAFormFillingTests extends TestBase {

  @Test
  @DisplayName("Fill The Form Selenide Test")
  @Description("Verification that user can submit the form successfully")
  @Tag("Form Test")
  @Owner("Sergei P")
  @Severity(SeverityLevel.TRIVIAL)
  public void userCanFillTheForm() {
    step("Open Demo QA Page", (step) -> {
      open("https://demoqa.com/automation-practice-form");
    });
    step("Fill The Form", (step) -> {
      $("#firstName").val(firstName);
      $("#lastName").val(lastName);
      $("#userEmail").val(email);
      $x("//label[contains(text(),'Male')]").click();
      $("#userNumber").val(number);
      $("#dateOfBirthInput").click();
      $(".react-datepicker__month-select").selectOption(month);
      $(".react-datepicker__year-select").selectOption(year);
      $(".react-datepicker__day--001").click();
      $("#subjectsInput").setValue(subject).pressEnter();
      $x("//label[contains(text(),'Sports')]").click();
      $("#uploadPicture").uploadFile(file);
      $("#currentAddress").setValue(address);
      $("#state").click();
      $(byText(state)).click();
      $("#city").click();
      $(byText(city)).click();
      $("#submit").click();
      $(byText(success)).shouldBe(Condition.visible);
    });
    step("Verify that form submitted successfully", (step) -> {
      $("tr:nth-child(1)>td:nth-child(2)").shouldHave(Condition.text(firstName + " " + lastName));
      $("tr:nth-child(2)>td:nth-child(2)").shouldHave(Condition.text(email));
      $("tr:nth-child(3)>td:nth-child(2)").shouldHave(Condition.text(gender));
      $("tr:nth-child(4)>td:nth-child(2)").shouldHave(Condition.text(number));
      $("tr:nth-child(5)>td:nth-child(2)").shouldHave(Condition.text(day + " " + month + "," + year));
      $("tr:nth-child(6)>td:nth-child(2)").shouldHave(Condition.text(subject));
      $("tr:nth-child(7)>td:nth-child(2)").shouldHave(Condition.text(hobby));
      $("tr:nth-child(9)>td:nth-child(2)").shouldHave(Condition.text(address));
      $("tr:nth-child(10)>td:nth-child(2)").shouldHave(Condition.text(state + " " + city));
    });


  }

}
