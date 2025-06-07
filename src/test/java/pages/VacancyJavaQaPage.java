package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.*;


public class VacancyJavaQaPage {
    private final SelenideElement
            clickReview = $("[data-qa='review-card-content-title']"),
            textH = $("[data-qa='bottom-sheet-content']"),
            namePage = $(".bloko-header-section-1"),
            pageCompany = $(".g-user-content p").$("strong"),
            textBlock = $("[data-qa='employer-review-big-widget-modal-review-card-0']").$("[class*='magritte-text'][class*='typography-label-2-regular']");

    private final ElementsCollection
            stars = $$("[data-qa='employer-reviews-stars'] .star_filled--KqHIdEHHkRDhXdlH"),
            link = $$("div[data-qa=vacancy-company] span");


    public void openPage() {
        open("/vacancy/120964676?query=Автоматизация+тестирования+java&hhtmFrom=vacancy_search_list");
        //sleep(5000);
        executeJavaScript("$('footer').remove()"); // убирает рек

    }

    public void checkResultNamePage() {
        namePage.shouldHave(text("Auto QA (Java)"));

    }

    public void clickReview() {
        executeJavaScript(
                "arguments[0].click();",
                clickReview);

    }

    public void checkTextReview() {
        textH.shouldHave(text("Отзыв сотрудника"));

    }

    public void checkTextReviewBlock() {
        textBlock.shouldNotBe(empty).shouldHave(visible);

    }


    public void checkStars() {
        stars.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(5));

    }

    public void checkStarsCompany() {
        String ratingText = $(".magritte-text___pbpft_3-0-32.magritte-text_style-primary___AQ7MW_3-0-32.magritte-text_typography-title-5-semibold___Y-owC_3-0-32")
                .getText()
                .replace(",", "."); // заменяем запятую на точку для корректного парсинга
        double rating = Double.parseDouble(ratingText);

// Проверяем, что оценка больше 4
        assert rating > 4.9 : "Рейтинг должен быть больше 4.9, текущий рейтинг: " + rating;

    }

    public void checkCompanyClickPage() {
        link.findBy(exactText("Offer Now"))
                .click();

    }

    public void checkCompanyClickPageNew() {
        pageCompany.shouldHave(exactText("Offer Now"));

    }
}
