package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.VacancyJavaQaPage;

import static io.qameta.allure.Allure.step;


@DisplayName("Автотесты на форму вакансии на сайте НН")
public class VacancyTest extends TestBase{
    VacancyJavaQaPage vacancyJavaQaPage =new VacancyJavaQaPage();

    @Test
    @DisplayName("Проверка открытия страницы вакансии Auto QA (Java)")
    public void vacancyPageTest() {
        step("Открытие страницы вакансии", () ->{
            vacancyJavaQaPage.openPage();});
        step("Проверяем наименования страницы (вакансии)", () ->{
            vacancyJavaQaPage .checkResultNamePage();});
    }

    @Test
    @DisplayName("Проверка открытия карточки отзыва, и непустого содержимого в разделе 'Что нравится'")
    void vacancyReviewTest() {
        step("Проверяем открытие страницы вакансии Auto QA (Java)", () ->{
        vacancyJavaQaPage.openPage();});
        step("Проверяем открытие формы отзыва", () ->{
        vacancyJavaQaPage.clickReview();});
        step("Проверяем наличие названия формы 'Отзыв сотрудника'", () ->{
        vacancyJavaQaPage.checkTextReview();});
        step("Проверяем наличие текста и видимости этого текста в блоке 'Что нравится'", () ->{
        vacancyJavaQaPage.checkTextReviewBlock();});

    }

    @Test
    @DisplayName("Проверка колличества звезд в отзыве")
    void vacancyReviewStarUserTest() {
        step("Проверяем открытие страницы вакансии Auto QA (Java)", () ->{
            vacancyJavaQaPage.openPage();});
        step("Проверяем открытие формы отзыва", () ->{
            vacancyJavaQaPage.clickReview();});
        step("Проверяем колличество звезд в отзыве", () ->{
            vacancyJavaQaPage.checkStars();});
    }


    @Test
    @DisplayName("Проверка общей оценки компании,должна быть больше или равна 4.9 (падение т.к.текущий 4.8)")
    void vacancyReviewStarCompanyTest() {
        step("Проверяем открытие страницы вакансии Auto QA (Java)", () ->{
            vacancyJavaQaPage.openPage();});
        step("Проверяем общую оценку компании, должна быть больше или равна 4.9 ", () ->{
            vacancyJavaQaPage.checkStarsCompany();});
    }
}

