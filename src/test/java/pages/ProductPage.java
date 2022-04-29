package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class ProductPage {

    public SelenideElement
            titleBook = $("h1.product__title.js-analytic-product-title"),
            productLink = $("a.product-card__img.js-analytic-productlink");

    public ProductPage chooseBook() {
        sleep(250);
        productLink.click();
        return this;
    }

    public ProductPage checkBook(String value) {
        titleBook.shouldHave(Condition.text(value));
        return this;
    }
}
