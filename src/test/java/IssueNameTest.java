import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class IssueNameTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 6000;
    }

    @DisplayName("Проверка названия issue")
    @Test
    void issueNameTest() {
        open("/AvvakumovaYana");
        $("[data-tab-item=\"repositories\"]").click();;
        $(".wb-break-all").$(byText("HWLesson10")).click();
        $("#issues-tab").click();
        $("#issue_1_link").shouldHave(text("Issue for Homework 10"));
    }

    @DisplayName("Проверка названия issue, тест с лямбдой")
    @Test
    void lambdaIssueNameTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("/AvvakumovaYana");
        });
        step("Открываем раздел с репозиториями", () -> {
            $("[data-tab-item=\"repositories\"]").click();
        });
        step("Открываем репозиторий HWLesson10", () -> {
            $(".wb-break-all").$(byText("HWLesson10")).click();
        });
        step("Открываем раздел с Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем название Issue", () -> {
            $("#issue_1_link").shouldHave(text("Issue for Homework 10"));
        });
    }

    @DisplayName("Проверка названия issue, тест c аннотацией @Step")
    @Test
    void stepIssueNameTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.openPageRepository();
        steps.openRepository();
        steps.openPageIssue();
        steps.nameIssue();
    }
}
