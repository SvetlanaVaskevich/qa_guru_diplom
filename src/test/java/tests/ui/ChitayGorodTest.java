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
import tests.TestBase;

import static io.qameta.allure.Allure.step;

@Owner("vaskevich")
@Tag("ui")
@Microservice("Chitay-gorod")
@Feature("WebElements")
public class ChitayGorodTest extends TestBase {

    TestData data = new TestData();

    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    private MainPage mainPage = new MainPage();

    @ValueSource(strings = {"Программирование", "Воспитание"})
    @ParameterizedTest(name = "Поиск товара по параметру: {0}")
    @Description("Тест проверяет поиск товара по выбранному параметру")
    @DisplayName("Поиск товара по параметру")
    @Severity(SeverityLevel.NORMAL)
    void searchProductOnParameterTest(String value){
        step("Открываем страницу https://www.chitai-gorod.ru/", () -> {
            mainPage.openPage();
            mainPage.notification();
        });
        step("Вводим значение параметра в поле Поиска", () ->
                mainPage.searchProduct(value));
        step("Проверяем результат поиска", () -> {
            mainPage.notification();
            mainPage.checkResultProduct(value);
        });
    }

    @ValueSource(strings = {"Лесной, Свердловская Область",
                            "Кунгур, Пермский Край"})
    @ParameterizedTest(name = "Тест на выбор города: {0}")
    @Description("Тест проверяет выбор города ")
    @DisplayName("Выбор города")
    @Severity(SeverityLevel.NORMAL)
    void chooseCityTest(String value){
        String[] split = value.split(",");
        step("Открываем страницу https://www.chitai-gorod.ru/", () -> {
            mainPage.openPage();
            mainPage.notification();
        });
        step("Вводим название города и выбираем его из предложенного списка", () ->
            mainPage.chooseCity(split[0], split[1]));
        step("Проверяем название города в главном меню", () -> {
            mainPage.notification();
            mainPage.checkCity(split[0], split[1]);
        });
    }

    @CsvSource(value = {
            "Адреса магазинов, Наши магазины",
            "Доставка и оплата, Доставка и оплата"
    })
    @ParameterizedTest(name = "Открытие вкладок в главном меню: {0}" )
    @Description("Тест проверяет вкладки в главном меню")
    @DisplayName("Открытие вкладок в главном меню")
    @Severity(SeverityLevel.NORMAL)
    public void searchCategoryTest(String data, String result) {
        step("Открываем страницу https://www.chitai-gorod.ru/", () -> {
            mainPage.openPage();
            mainPage.notification();
        });

        step("Выбираем вкладку в главном меню ", () ->
            mainPage.chooseMenuList(data));
        step("Проверяме результат открытой вкладки ", () -> {
            mainPage.notification();
            mainPage.checkMenuList(result);
        });
    }

    @Test
    @Description("Тест проверяет вкладки в всплывающем меню вкладки")
    @DisplayName("Открытие вкладки в всплывающем меню")
    @Severity(SeverityLevel.NORMAL)
    public void navMenuTest(){
        step("Открываем страницу https://www.chitai-gorod.ru/", () -> {
            mainPage.openPage();
            mainPage.notification();
        });
        step("Выбираем вкладку в навигационном меню", () ->
            mainPage.chooseNavItem(data.titleNavItem));
        step("Проверяем результат открытия вкладки", () -> {
            mainPage.notification();
            mainPage.checkNavItem(data.titleNavItem);
        });
    }

    @ValueSource(strings = {"Лучшие из лучших", "Скоро в продаже"})
    @ParameterizedTest(name = "Работа слайдера: {0}")
    @Description("Тест проверяет открытие категорий книг на главном странице")
    @DisplayName("Открытие категорий книг")
    @Severity(SeverityLevel.NORMAL)
    public void sliderMenuTest(String value){
        step("Открываем страницу https://www.chitai-gorod.ru/", () -> {
            mainPage.openPage();
            mainPage.notification();
        });
        step("Выбираем категорию книг", () ->
            mainPage.chooseCategory(value));
        step("Проверяем открытие страницы с выбранной категорий книг", () -> {
            mainPage.notification();
            mainPage.checkCategory(value);
        });
    }

    @Test
    @Description("Тест проверяет поиск книги в поле Поиска")
    @DisplayName("Поиск заданной книги")
    @Severity(SeverityLevel.CRITICAL)
    public void searchBookTest(){
        step("Открываем страницу https://www.chitai-gorod.ru/", () -> {
            mainPage.openPage();
            mainPage.notification();
        });
        step("Поиск книги в поле Поиска", () ->
            mainPage.searchProduct(data.titleBook));
        step("Выбор книги из найденных вариантов", () -> {
            mainPage.notification();
            mainPage.chooseBook();
        });
        step("Проверяем название книги", () ->
                mainPage.checkBook("\n" +
                        "                    " + data.titleBook + "\n" +
                        "                "));
    }

        /*@Test
        @Description("Тест проверяет авторизацию пользователя")
        @DisplayName("Авторизация")
        @Severity(SeverityLevel.CRITICAL)
        void generatedTest() {
            step("Открываем страницу https://www.chitai-gorod.ru/", () -> {
                mainPage.openPage();
                mainPage.notification();
            });
            step("Открываем окно авторизации", () ->
                mainPage.openLogin());
            step("Вводим имя пользователя svaskevich@bk.ru", () ->
                mainPage.setEmail(config.userEmail()));
            step("Вводим пароль ", () ->
                mainPage.setPassword(config.userPassword()));
            step("set submit form", () ->
                mainPage.enterSubmit());
            step("Проверяем успешную авторизацию", () -> {
                mainPage.notification();
                mainPage.checkAuth(data.name);
            });
        }*/
    }
