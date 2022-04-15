package tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MobileMainPage;
import tests.TestBase;

import static io.qameta.allure.Allure.step;

@Tag("mobile")
public class ChitayGorodMobile extends TestBase {

    MobileMainPage mobileMainPage = new MobileMainPage();


    @ValueSource(strings = {"Книжные циклы","Подборки"})
    @ParameterizedTest(name = "Проверка вкладок главного меню:{0}")
    @DisplayName("Проверка вкладок главного меню")
    void checkMainMenuTest(String value) {
        step("Выбираем город на главной странице", () -> {
            mobileMainPage.chooseCity("Екатеринбург, Свердловская Область");
        });
        step("Проверяем навигационное меню на главной странице", () -> {
            mobileMainPage.checkNavMenu(value);
            mobileMainPage.backPage();
        });
    }

    @Test
    @DisplayName("Проверка разделов на главной странице")
    void checkSliderTest() {
        step("Выбираем город на главной странице", () ->
                mobileMainPage.chooseCity("Екатеринбург, Свердловская Область"));
        step("Проверяем вкладки разделов на главной странице", () -> {
            mobileMainPage.checkSliderMenu("Новинки литературы");
        });
    }

    @Test
    @DisplayName("Проверка каталога")
    void checkatalogTest() {
        step("Выбираем город на главной странице", () ->
                mobileMainPage.chooseCity("Екатеринбург, Свердловская Область"));
        step("Нажимаем копку Каталог", () ->
                mobileMainPage.chooseCatalog());
        step("Выбираем раздел подкаталог", () ->
                mobileMainPage.chooseSubCatalog("Книги для детей"));
        step("Проверяем выбранный подкаталог", () ->
                mobileMainPage.checkSubCatalog("Книги для детей"));
    }

    @Test
    @DisplayName("Проверка поиска книги")
    void searchBookTest() {
        step("Выбираем город на главной странице", () ->
                mobileMainPage.chooseCity("Екатеринбург, Свердловская Область"));
        step("Нажимаем на поле Поиска и вводим название книги", () ->
                mobileMainPage.searchProduct("Мадам Бессонов"));
        step("Нажимаем на первую книгу в результатах поиска", () ->
                mobileMainPage.clickOnProduct());
        step("Проверяем название книги с искомым", () ->
                mobileMainPage.checkTitleProduct("Мадам"));
    }

    @Test
    @DisplayName("Проверка добавление книги в корзину")
    void addToCartTest() {
        step("Выбираем город на главной странице", () ->
                mobileMainPage.chooseCity("Екатеринбург, Свердловская Область"));
        step("Нажимаем на поле Поиска и вводим название книги", () ->
                mobileMainPage.searchProduct("Крошка Панда"));
        step("Нажимаем на первую книгу в результатах поиска", () ->
                mobileMainPage.clickOnProduct());
        step("Нажимаем на кнопку Купить на странице книги", () ->{
              mobileMainPage.clickButtonBuy();
              mobileMainPage.clickButtonBuy();
        });
        step("Проверяем наличие книги в корзине", () ->
           mobileMainPage.checkBookInCart("Крошка Панда"));
    }

    @Test
    @DisplayName("Проверка входа в личный кабинет")
    void enterToCabinetTest() {
        step("Выбираем город на главной странице", () ->
                mobileMainPage.chooseCity("Екатеринбург, Свердловская Область"));
        step("Нажимаем на кнопку Еще", () ->
                mobileMainPage.clickOnMoreFragments());
        step("Нажимаем на кнопку входа", () ->
                mobileMainPage.clickOnSignIn());
        step("Вводим логин", () ->
                mobileMainPage.enterLogin(config.userEmail()));
        step("Вводим пароль", () ->
                mobileMainPage.enterPassword(config.userPassword()));
        step("Нажимаем кнопку входа в кабинет", () ->
                mobileMainPage.clickOnSignIn());
        step("Проверяем имя пользователя в Личном кабинете", () -> {
                mobileMainPage.clickOnMoreFragments();
                mobileMainPage.checkUserName("Svetlana");
        });
    }
}