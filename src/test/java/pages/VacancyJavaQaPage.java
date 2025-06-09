package pages;

import com.codeborne.selenide.*;


import java.time.Duration;


import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;



public class VacancyJavaQaPage {
    private final SelenideElement

            textH = $("[data-qa=\"title-container\"]"),
            namePage = $(".bloko-header-section-1"),
            pageCompany = $(".g-user-content p").$("strong"),
            transition = $("a[data-qa='link'][href='https://offer-now.ru/']"),
            pageCompanyOfSite = $(".tn-atom"),
            favorites = $("[data-qa=\"vacancy-body-mark-favorite_false\"]");
    private final ElementsCollection
            stars = $$("[data-qa='employer-reviews-stars'] .star_filled--KqHIdEHHkRDhXdlH"),
            link = $$("div[data-qa=vacancy-company] span");


    public VacancyJavaQaPage openPage() {
        open("/vacancy/120964676?query=Автоматизация+тестирования+java&hhtmFrom=vacancy_search_list");
        executeJavaScript("$('.footer-counters').remove()");// убирает рек

        return this;
    }

    public void checkResultNamePage() {
        namePage.shouldHave(text("Auto QA (Java)"));

    }

    public void transitionСheck() {


        // 1. Запомнить текущее количество вкладок
        int initialWindowCount = getWebDriver().getWindowHandles().size();
        executeJavaScript("document.querySelectorAll('[title]').forEach(el => el.removeAttribute('title'))");
        executeJavaScript("document.querySelector('.uxfeedback-widget').remove()");
        transition.click();
        switchTo().window(initialWindowCount);
    }

    public void checkPageCompany() {
        // 5. Проверить URL в новой вкладке (с учетом возможного редиректа)
        webdriver().shouldHave(urlContaining("offer-now.ru"), Duration.ofSeconds(5));
        $("body").shouldBe(visible);
        $(".t228__logo").shouldHave(text("OfferNow"));
    }


    public VacancyJavaQaPage clickFavorites() {
        favorites.click();

        return this;
    }


    public void checkFormReg() {
        textH.shouldHave(text("Вход"));

    }


    public void checkStarsCompany() {
        // 1. Проверяем наличие уведомления и закрываем его, если есть
        if ($("[data-qa='bloko-notification']").exists()) {
            // Вариант A: Закрыть кнопкой (если есть)
            $("[data-qa='bloko-notification'] [data-qa='close-button']").click();

            $("[data-qa='employer-reviews-stars'] [class*='star']")
                    .shouldBe(visible, Duration.ofSeconds(10));
        }
    }

    public VacancyJavaQaPage checkCompanyClickPage() {
        link.findBy(exactText("Offer Now"))
                .click();
        return this;
    }

    public void checkCompanyClickPageNew() {
        pageCompany.shouldHave(exactText("Offer Now"));

    }
}
