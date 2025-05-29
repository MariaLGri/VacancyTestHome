package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void installСonfiguration() {
        Configuration.browserSize = "1920x1080"; // разрешение, ну это понятно
        Configuration.pageLoadStrategy = "eager"; // чтоб не ждать загрузки всего сайта , картинок и т.д
        Configuration.baseUrl = "https://penza.hh.ru"; // выносим абсолютный адресс из опен
       Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub"; //хром на стороннем сервисе
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterEach
    void webDriverTearDown() {
        Selenide.closeWebDriver();
    }

}
