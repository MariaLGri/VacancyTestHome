package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.VacancyJavaQaPage;

import static io.qameta.allure.Allure.step;


@DisplayName("Автотесты на форму вакансии на сайте НН")
public class VacancyTest extends TestBase {
    VacancyJavaQaPage vacancyJavaQaPage = new VacancyJavaQaPage();

    @Test
    @DisplayName("Проверка открытия страницы вакансии Auto QA (Java)")
    public void vacancyPageTest() {
        step("Открытие страницы вакансии", () -> {
            vacancyJavaQaPage.openPage();
        });
        step("Проверяем наименования страницы (вакансии)", () -> {
            vacancyJavaQaPage.checkResultNamePage();
        });
    }

    @Test
    @DisplayName("Проверка невозможности добавить вакансию в избраннное без регистрации")
    public void vacancyReviewTest() {
        step("Проверяем открытие страницы вакансии Auto QA (Java)", () -> {
            vacancyJavaQaPage.openPage();
        });
        step("Проверяем нажатие кнопки 'добавить в избранное'", () -> {
            vacancyJavaQaPage.clickFavorites();
        });
        step("Проверяем переход на страницу регистрации с формой 'Вход'", () -> {
            vacancyJavaQaPage.checkFormReg();
        });

    }

    @Test
    @DisplayName("Проверка перехода на официальный сайт компании со страницы описания компании")
    public void vacancyReviewStarUserTest() {
        step("Проверяем открытие страницы вакансии Auto QA (Java)", () -> {
            vacancyJavaQaPage.openPage();
        });
        step("Проверяем переход по клику на страницу описания компании ", () -> {
            vacancyJavaQaPage.checkCompanyClickPage();
        });

        step("Проверяем клик по ссылке https://offer-now.ru/", () -> {
            vacancyJavaQaPage.transitionСheck();
        });
        step("Проверяем, что перешли на нужную страницу", () -> {
            vacancyJavaQaPage.checkPageCompany();
        });

    }


    @Test
    @DisplayName("Проверка видимости общей оценки компании ")
    void vacancyReviewStarCompanyTest() {
        step("Проверяем открытие страницы вакансии Auto QA (Java)", () -> {
            vacancyJavaQaPage.openPage();
        });
        step("Проверяем , что видно рейтинг ", () -> {
            vacancyJavaQaPage.checkStarsCompany();
        });
    }

    @Test
    @DisplayName("Проверка перехода на страницу краткого описания компании для вакансии")
    void vacancyCompanyTest() {
        step("Проверяем открытие страницы вакансии Auto QA (Java)", () -> {
            vacancyJavaQaPage.openPage();
        });
        step("Проверяем переход по клику на страницу описания компании ", () -> {
            vacancyJavaQaPage.checkCompanyClickPage();
        });

        step("Проверяем присутствие описания компании на странице", () -> {
            vacancyJavaQaPage.checkCompanyClickPageNew();
        });
    }
}

