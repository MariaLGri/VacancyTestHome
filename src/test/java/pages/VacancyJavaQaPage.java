package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.*;


public class VacancyJavaQaPage {
    private final SelenideElement
            clickeReview = $(".item--Kt3MXU1OVEVIrIg5"),
            textH = $("[data-qa='reviews-modal-review-title']"),
            namePage = $(".bloko-header-section-1"),
pageCompany = $(".g-user-content p").$("strong"),
           textBlock = $("[data-qa='employer-review-big-widget-modal-review-card-0']").$("[class*='magritte-text'][class*='typography-label-2-regular']");

    private final ElementsCollection
            stars = $$("[data-qa='employer-reviews-stars'] .star_filled--KqHIdEHHkRDhXdlH"),
            link = $$("div[data-qa=vacancy-company] span");


     public VacancyJavaQaPage openPage(){
    open("/vacancy/120964676?query=Автоматизация+тестирования+java&hhtmFrom=vacancy_search_list");
        executeJavaScript("$('footer').remove()"); // убирает рек
        $(".bloko-button_kind-primary").click();
         // executeJavaScript("document.querySelector('.popup').style.display = 'none';");
    return this;
}

    public VacancyJavaQaPage checkResultNamePage(){
        namePage.shouldHave(text("Auto QA (Java)"));
        return this;
    }

    public VacancyJavaQaPage clickReview(){
        clickeReview.hover().click();
        return this;
    }
    public VacancyJavaQaPage checkTextReview(){
        textH.shouldHave(text("Отзыв сотрудника"));
        return this;
    }

public VacancyJavaQaPage checkTextReviewBlock(){
    textBlock.shouldNotBe(empty).shouldHave(visible);
        return this;
    }


    public VacancyJavaQaPage checkStars(){
        stars.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(5));
        return this;
    }

    public VacancyJavaQaPage checkStarsCompany(){
        String ratingText = $(".magritte-text___pbpft_3-0-32.magritte-text_style-primary___AQ7MW_3-0-32.magritte-text_typography-title-5-semibold___Y-owC_3-0-32")
                .getText()
                .replace(",", "."); // заменяем запятую на точку для корректного парсинга
        double rating = Double.parseDouble(ratingText);

// Проверяем, что оценка больше 4
        assert rating > 4.9 : "Рейтинг должен быть больше 4.9, текущий рейтинг: " + rating;
        return this;
    }

    public VacancyJavaQaPage checkCompanyClickPage(){
         link.findBy(exactText("Offer Now"))
                .click();
        return this;
    }
    public VacancyJavaQaPage checkCompanyClickPageNew(){
        pageCompany.shouldHave(exactText("Offer Now"));
        return this;
    }
}
