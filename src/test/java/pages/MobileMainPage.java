package pages;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;

public class MobileMainPage {

    public MobileMainPage chooseCity(String value){
        $(AppiumBy.xpath(String.format("//android.widget.TextView[@text=\"%s\"]", value))).click();
        $(AppiumBy.id("ru.chitaigorod.mobile:id/toolbar"))
                .$(AppiumBy.className("android.widget.ImageButton")).click();
        return this;
    }

    public MobileMainPage checkNavMenu(String value){
        $(AppiumBy.xpath(String.format("//android.widget.TextView[@text=\"%s\"]",value))).click();
        $(AppiumBy.id("ru.chitaigorod.mobile:id/toolbar")).$(AppiumBy.className("android.widget.TextView"))
                .shouldHave(Condition.text(value));
        return this;
    }

    public MobileMainPage backPage(){
        back();
        return this;
    }

    public MobileMainPage checkSliderMenu(String value){
        $(AppiumBy.id("ru.chitaigorod.mobile:id/textViewAllNewReleases")).click();
        $(AppiumBy.id("ru.chitaigorod.mobile:id/toolbar")).$(AppiumBy.className("android.widget.TextView"))
                .shouldHave(Condition.text(value));
        return this;
    }

    public MobileMainPage chooseCatalog(){
        $(AppiumBy.id("ru.chitaigorod.mobile:id/catalogFragment")).click();
        return this;
    }

    public MobileMainPage chooseSubCatalog(String value){
        $(AppiumBy.xpath(String.format("//android.widget.TextView[@text=\"%s\"]",value))).click();
        return this;
    }

    public MobileMainPage checkSubCatalog(String value){
        $(AppiumBy.id("ru.chitaigorod.mobile:id/toolbar"))
                .$(AppiumBy.className("android.widget.TextView"))
                .shouldHave(Condition.text(value));
        return this;
    }

    public MobileMainPage searchProduct(String value){
        $(AppiumBy.id("ru.chitaigorod.mobile:id/frameLayoutSearch")).click();
        $(AppiumBy.id("ru.chitaigorod.mobile:id/search_src_text"))
                .setValue(value);
        return this;
    }

    public MobileMainPage clickOnProduct() {
        $(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='ru.chitaigorod.mobile:id/productView']"))
                .click();
        return this;
    }

    public MobileMainPage checkTitleProduct(String value) {
        $(AppiumBy.id("ru.chitaigorod.mobile:id/textViewTitle")).
                shouldHave(Condition.text(value));
        return this;
    }

    public MobileMainPage clickButtonBuy() {
        $(AppiumBy.id("ru.chitaigorod.mobile:id/buttonPurchase")).click();
        return this;
    }

    public MobileMainPage checkBookInCart(String value) {
        $(AppiumBy.id("ru.chitaigorod.mobile:id/textViewCartProductTitle"))
                .shouldHave(Condition.text(value));
        return this;
    }

    public MobileMainPage clickOnMoreFragment() {
        return this;
    }

    public MobileMainPage enterLogin(String value) {
        $(AppiumBy.id("ru.chitaigorod.mobile:id/editTextLogin")).setValue(value);
        return this;
    }

    public MobileMainPage enterPassword(String value) {
        $(AppiumBy.id("ru.chitaigorod.mobile:id/editTextPassword")).setValue(value);
        return this;
    }

    public MobileMainPage clickOnSignIn() {
        $(AppiumBy.id("ru.chitaigorod.mobile:id/buttonSignIn")).click();
        return this;
    }

    public MobileMainPage clickOnMoreFragments() {
        $(AppiumBy.id("ru.chitaigorod.mobile:id/moreFragment")).click();
        return this;
    }

    public MobileMainPage checkUserName(String value) {
        $(AppiumBy.id("ru.chitaigorod.mobile:id/textViewUserName"))
                .shouldHave(Condition.text(value));
        return this;
    }
}
