import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("/AvvakumovaYana");
    }
    @Step("Открываем раздел с репозиториями")
    public void openPageRepository() {
        $("[data-tab-item=\"repositories\"]").click();
    }
    @Step("Открываем репозиторий HWLesson10")
    public void openRepository() {
        $(".wb-break-all").$(byText("HWLesson10")).click();
    }
    @Step("Открываем раздел с Issue")
    public void openPageIssue() {
        $("#issues-tab").click();
    }
    @Step("Проверяем название Issue")
    public void nameIssue() {
        $("#issue_1_link").shouldHave(text("Issue for Homework 10"));
    }
}
