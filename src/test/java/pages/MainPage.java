package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public SelenideElement
            searchInput = $("input.search-form__input"),
            searchTitle = $("div.js__search_info").$("h1"),
            cityButton = $("#city"),
            cityChange = $("#city-сhange"),
            citySearch = $("#city-search"),
            citySuggest = $("ul.city-suggest.js__city_suggest"),
            headerMenuList = $("ul.header-menu__list"),
            titleMenu = $("h1.color_blue"),
            catalogNav = $("a[href='/catalog/hobbies/']"),
            listCatalog = $("div.catalog__list.js__catalog__list.catalog__list__visible"),
            titleNavItem = $("h1.color_blue.color_blue--oes-title"),
            sliderTitle = $("div.js__main_page_sliders"),
            titleСategory = $("h1.color_blue"),
            loginInput = $("button.js__showPopupLogin"),
            emailInput = $("#popup-email"),
            passwordInput = $("#popup-password"),
            submitButton = $("#authSubmit"),
            profileButton = $("a.header__show-menu"),
            notification = $("#push-notification-balloon"),
            buttonPopUp = $("#push-notification-balloon button.color_grey.push-notification-balloon-hide.js__hide-push-balloon"),
            logoutFromProfile = $("a[href='/?logout=yes']");

    public MainPage openPage() {
        open("");
        return this;
    }

    public MainPage closeNotification() {
        if (notification.is(Condition.visible)) {
            buttonPopUp.click();
        }
        return this;
    }

    public MainPage searchProduct(String value) {
        searchInput.setValue(value).pressEnter();
        return this;
    }

    public MainPage checkResultProduct(String value) {
        searchTitle.shouldHave(Condition.text("Результаты поиска «" + value + "»"));
        return this;
    }

    public MainPage chooseCity(String cityName, String oblastName) {
        cityButton.click();
        cityChange.click();
        citySearch.setValue(cityName);
        citySuggest.$("li[data-city-name='" + cityName + "," + oblastName + "']").click();
        return this;
    }

    public MainPage checkCity(String cityName, String oblastName) {
        cityButton.shouldHave(Condition.text("Россия, Город " + cityName + "," + oblastName));
        return this;
    }

    public MainPage chooseMenuList(String value) {
        headerMenuList.$(byText(value)).click();
        return this;
    }

    public MainPage checkMenuList(String result) {
        titleMenu.shouldHave(Condition.text(result));
        return this;
    }

    public MainPage chooseNavItem(String value) {
        catalogNav.hover();
        listCatalog.$("div.column").$(byText(value)).click();
        return this;
    }

    public MainPage checkNavItem(String value) {
        titleNavItem.shouldHave(Condition.text(value));
        return this;
    }

    public MainPage chooseCategory(String value) {
        sliderTitle.$(byText(value)).click();
        return this;
    }

    public MainPage checkCategory(String value) {
        titleСategory.shouldHave(Condition.text(value));
        return this;
    }

    public MainPage openLogin() {
        loginInput.click();
        return this;
    }

    public MainPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public MainPage setPassword(String value) {
        passwordInput.setValue(value);
        return this;
    }

    public MainPage enterSubmit() {
        submitButton.click();
        return this;
    }

    public MainPage checkAuth(String value) {
        profileButton.shouldHave(Condition.text(value));
        return this;
    }

    public MainPage logOut() {
        profileButton.hover();
        logoutFromProfile.click();
        return this;
    }
}
