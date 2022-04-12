package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement
    input = $("input.search-form__input.js__search-input"),
    title = $("div.js__search_info").$("h1"),
    city = $("#city"),
    cityChange = $("#city-сhange"),
    citySearch = $("#city-search"),
    citySuggest = $("ul.city-suggest.js__city_suggest"),
    menuList = $("ul.header-menu__list"),
    titleMenu = $("h1.color_blue"),
    catalogNav = $("a[href='/catalog/hobbies/']"),
    listCatalog = $("div.catalog__list.js__catalog__list.catalog__list__visible"),
    titleNavItem = $("h1.color_blue.color_blue--oes-title"),
    sliderTitle = $("div.js__main_page_sliders"),
    titleCategorya = $("h1.color_blue"),
    titleBook = $("h1.product__title.js-analytic-product-title"),
    productLink = $("a.product-card__img.js-analytic-productlink"),
    login = $("button.js__showPopupLogin"),
    email = $("#popup-email"),
    password = $("#popup-password"),
    submit = $("#authSubmit"),
    showMenu = $("a.header__show-menu");

    public MainPage openPage(){
        open("");
        return this;
    }

    public MainPage searchProduct(String value){
        input.setValue(value).pressEnter();
        return this;
    }

    public MainPage checkResultProduct(String value){
        title.shouldHave(Condition.text("Результаты поиска «" + value + "»"));
        return this;
    }

    public MainPage chooseCity(String cityName, String oblastName){
        city.click();
        cityChange.click();
        citySearch.setValue(cityName);
        citySuggest.$("li[data-city-name='"+cityName+","+oblastName+"']").click();
        return this;
    }

    public MainPage checkCity(String cityName, String oblastName){
        city.shouldHave(Condition.text("Россия, Город "+cityName+","+oblastName));
        return this;
    }

    public MainPage chooseMenuList(String value) {
        menuList.$(byText(value)).click();
        return this;
    }

    public MainPage checkMenuList(String result) {
        titleMenu.shouldHave(Condition.text(result));
        return this;
    }

    public MainPage chooseNavItem(String value){
        catalogNav.hover();
        listCatalog.$("div.column").$(byText(value)).click();
        return this;
    }

    public MainPage checkNavItem(String value){
        titleNavItem.shouldHave(Condition.text(value));
        return this;
    }

    public MainPage chooseCategory(String value){
        sliderTitle.$(byText(value)).click();
        return this;
    }

    public MainPage checkCategory(String value){
        titleCategorya.shouldHave(Condition.text(value));
        return this;
    }

    public MainPage chooseBook(){
        productLink.click();
        return this;
    }

    public MainPage checkBook(String value){
        titleBook.shouldHave(Condition.text(value));
        return this;
    }

    public MainPage openLogin(){
        login.click();
        return this;
    }

    public MainPage setEmail(String value){
        email.setValue(value);
        return this;
    }

    public MainPage setPassword(String value){
        password.setValue(value);
        return this;
    }

    public MainPage enterSubmit(){
        submit.click();
        return this;
    }

    public MainPage checkAuth(String value){
        showMenu.shouldHave(Condition.text(value));
        return this;
    }
}
