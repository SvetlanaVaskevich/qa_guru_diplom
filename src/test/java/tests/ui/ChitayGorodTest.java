package tests.ui;

import allure.Microservice;
import config.ProjectConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;
import pages.ProductPage;
import tests.TestBase;

import static io.qameta.allure.Allure.step;

@Owner("vaskevich")
@Feature("MainPageTests")
public class ChitayGorodTest extends TestBase {

    TestData data = new TestData();
    ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
    MainPage mainPage = new MainPage();
    ProductPage productPage = new ProductPage();

    @Tag("ui")
    @ValueSource(strings = {"Программирование", "Воспитание"})
    @ParameterizedTest(name = "Поиск товара по параметру: {0}")
    @Description("Тест проверяет поиск товара по выбранному параметру")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Поиск товара по параметру")
    void searchProductOnParameterTest(String value) {
        step("Открываем страницу", () -> {
            mainPage.openPage();
            mainPage.closeNotification();
        });
        step("Вводим значение параметра в поле Поиска", () ->
                mainPage.searchProduct(value));
        step("Проверяем результат поиска", () -> {
            mainPage.closeNotification();
            mainPage.checkResultProduct(value);
        });
    }

    @Tag("ui")
    @ValueSource(strings = {"Лесной, Свердловская Область",
            "Кунгур, Пермский Край"})
    @ParameterizedTest(name = "Тест на выбор города: {0}")
    @Description("Тест проверяет выбор города ")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Выбор города")
    void chooseCityTest(String value) {
        String[] split = value.split(",");
        step("Открываем страницу", () -> {
            mainPage.openPage();
            mainPage.closeNotification();
        });
        step("Вводим название города и выбираем его из предложенного списка", () ->
                mainPage.chooseCity(split[0], split[1]));
        step("Проверяем название города в главном меню", () -> {
            mainPage.closeNotification();
            mainPage.checkCity(split[0], split[1]);
        });
    }

    @Tag("ui")
    @CsvSource(value = {
            "Адреса магазинов, Наши магазины",
            "Доставка и оплата, Доставка и оплата"
    })
    @ParameterizedTest(name = "Открытие вкладок в главном меню: {0}")
    @Description("Тест проверяет вкладки в главном меню")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Открытие вкладок в главном меню")
    void searchCategoryTest(String data, String result) {
        step("Открываем страницу", () -> {
            mainPage.openPage();
            mainPage.closeNotification();
        });
        step("Выбираем вкладку в главном меню ", () ->
                mainPage.chooseMenuList(data));
        step("Проверяме результат открытой вкладки ", () -> {
            mainPage.closeNotification();
            mainPage.checkMenuList(result);
        });
    }

    @Tag("ui")
    @Test
    @Description("Тест проверяет вкладки в всплывающем меню вкладки")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Открытие вкладки в всплывающем меню")
    void navMenuTest() {
        step("Открываем страницу", () -> {
            mainPage.openPage();
            mainPage.closeNotification();
        });
        step("Выбираем вкладку в навигационном меню", () ->
                mainPage.chooseNavItem(data.titleNavItem));
        step("Проверяем результат открытия вкладки", () -> {
            mainPage.closeNotification();
            mainPage.checkNavItem(data.titleNavItem);
        });
    }

    @Tag("ui")
    @ValueSource(strings = {"Лучшие из лучших", "Скоро в продаже"})
    @ParameterizedTest(name = "Работа слайдера: {0}")
    @Description("Тест проверяет открытие категорий книг на главном странице")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Открытие категорий книг")
    void sliderMenuTest(String value) {
        step("Открываем страницу <{baseUrl}>", () -> {
            mainPage.openPage();
            mainPage.closeNotification();
        });
        step("Выбираем категорию книг", () ->
                mainPage.chooseCategory(value));
        step("Проверяем открытие страницы с выбранной категорий книг", () -> {
            mainPage.closeNotification();
            mainPage.checkCategory(value);
        });
    }

    @Tag("ui")
    @Test
    @Description("Тест проверяет поиск книги в поле Поиска")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Поиск заданной книги")
    void searchBookTest() {
        step("Открываем страницу", () -> {
            mainPage.openPage();
            mainPage.closeNotification();
        });
        step("Поиск книги в поле Поиска", () ->
                mainPage.searchProduct(data.titleBook));
        step("Выбор книги из найденных вариантов", () -> {
            mainPage.closeNotification();
            productPage.chooseBook();
        });
        step("Проверяем название книги", () ->
            productPage.checkBook(data.titleBook));
    }

    @Tag("ui")
    @Test
    @Description("Тест проверяет авторизацию пользователя")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация пользователя")
    void generatedTest() {
        step("Открываем страницу", () -> {
            mainPage.openPage();
            mainPage.closeNotification();
        });
        step("Открываем окно авторизации", () ->
                mainPage.openLogin());
        step("Вводим имя пользователя", () ->
                mainPage.setEmail(config.userEmail()));
        step("Вводим пароль", () ->
                mainPage.setPassword(config.userPassword()));
        step("set submit form", () ->
                mainPage.enterSubmit());
        step("Проверяем успешную авторизацию", () -> {
            mainPage.closeNotification();
            mainPage.checkAuth(data.name);
        });
        step("Выходим из личного кабинета", () ->
                mainPage.logOut());
    }
}
