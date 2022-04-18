# Дипломный проект по тестированию интернет-магазина [Читай-город](https://reqres.in/)

## Содержание:

* [Технологии, используемые в данном проекте](https://github.com/SvetlanaVaskevich/qa_guru_diplom#%D1%82%D0%B5%D1%85%D0%BD%D0%BE%D0%BB%D0%BE%D0%B3%D0%B8%D0%B8-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D1%83%D0%B5%D0%BC%D1%8B%D0%B5-%D0%B2-%D0%B4%D0%B0%D0%BD%D0%BD%D0%BE%D0%BC-%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B5)
* [Тест кейсы](https://github.com/SvetlanaVaskevich/qa_guru_diplom#%D1%82%D0%B5%D1%81%D1%82-%D0%BA%D0%B5%D0%B9%D1%81%D1%8B)
* [Сборка в Jenkins](https://github.com/SvetlanaVaskevich/qa_guru_diplom#%D1%81%D0%B1%D0%BE%D1%80%D0%BA%D0%B0-%D0%B2-jenkins)
* [Информация о тестах в Allure report]()
* [Интеграция с AllureTestOps]()

## Технологии, используемые в данном проекте

[<img alt="Java" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Java.svg" width="50"/>](https://www.java.com/)
[<img alt="IDEA" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Idea.svg" width="50"/>](https://www.jetbrains.com/idea/)
[<img alt="Appium" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Appium.svg" width="50"/>](https://appium.io/)
[<img alt="Selenide" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Selenide.svg" width="50"/>](https://ru.selenide.org/)
[<img alt="Selenoid" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Selenoid.svg" width="50"/>](https://aerokube.com/selenoid/latest/)
[<img alt="Android" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Android.svg" width="50"/>](https://developer.android.com/studio)
[<img alt="Browserstack" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Browserstack.svg" width="50"/>](https://www.browserstack.com/)
[<img alt="Github" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/GitHub.svg" width="50"/>](https://github.com/) 
[<img alt="JUnit 5" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Junit5.svg" width="50"/>](https://junit.org/junit5/) 
[<img alt="Gradle" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Gradle.svg" width="50"/>](https://gradle.org/)
[<img alt="Allure" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Allure.svg" width="50"/>](https://github.com/allure-framework/allure2)
[<img alt="Allure_EE" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Allure_EE.svg" width="50"/>](https://qameta.io/)
[<img alt="Jenkins" height="50" src="https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/logo/Jenkins.svg" width="50"/>](https://www.jenkins.io/)

В данном проекте автотесты написаны на **Java** с использованием фреймворка для тестирования **Selenide**. Для сборки проекта в среде **IntelliJ IDEA** используется **Gradle**.
**JUnit5** задействован в качестве фреймворка модульного тестирования. Запуск тестов выполняется из **Jenkins**. **Selenoid** используется для запуска браузеров в контейнерах **Docker**. 

**Browserstack** используется для запуска мобильных тестов, для запуска на эмуляторе используются **Android Studio** и **Appium**. **Allure Report**, **AllureTestOps** и **Telegram Bot** используются для визуализации результатов тестирования.

## Тест кейсы

### Тест кейсы для UI тестирования

✓ Тест поиска товара по выбранному параметру

✓ Тест выбора города

✓ Тест открытия вкладок в главном меню

✓ Тест открытия вкладки в всплывающем меню

✓ Тест на проверку категорий книг на главном странице

✓ Тест поиска заданной книги

✓ Тест на авторизацию пользователя

### Тест кейсы для mobile тестирования

✓ Тест проверки вкладок главного меню

✓ Тест проверки разделов на главной странице

✓ Тест работы каталога

✓ Тест поиска заданной книги

✓ Тест на добавление книги в корзину

✓ Тест на авторизацию пользователя

## [Сборка в Jenkins](https://jenkins.autotests.cloud/job/C10-Svetlana_Vas_diplom/)
    clean 
    test
    -DtestType=${testType}
    -Dtag=${tag}
    -Dbrowser=${browser}
    -Dversion=${version}
    -DbrowserSize=${browserSize}

В данной сборке указаны следующие параметры:

_testType_ - имя ресурса\девайса (возможен запуск в **UI тестов** - в **selenoid**, 
**mobile тестов** - в **Browserstack**, на эмуляторе в **Android Studi**o c 
помощью сервера **Appium**)

_tag_ - разновидность тестов (**UI**, **mobile**)

_browser_ - браузер, в котором будут выполняться тесты (**chrome**, **opera**, **firefox**)

_version_ - версия браузера

_browserSize_ - размер окна браузера при выполнении тестов

![](https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom/main/images/screens/Jenkins_UI.png)


## Информация о тестах в [Allure report](https://jenkins.autotests.cloud/job/C10-Svetlana_Vas_diplom/16/allure/#)

### Главное окно

![](https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom_api/main/images/screens/AllureReport1.png)

### Окно с тестовыми кейсами

![](https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom_api/main/images/screens/AllureReport2.png)

### Окно с графиками

![](https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom_api/main/images/screens/AllureGraphs.png)

## Интеграция с [AllureTestOps](https://allure.autotests.cloud/project/1249/test-cases?treeId=0)

###Тест-кейсы с историей запусков

![](https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom_api/main/images/screens/AllureTestCases.png)

###Дашборд

![](https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom_api/main/images/screens/AllureDashboards.png)

## Уведомление в Telegram

После завершения тестов отчет о прохождении приходит в Telegram с помощью заранее созданного бота

![](https://raw.githubusercontent.com/SvetlanaVaskevich/qa_guru_diplom_api/main/images/screens/TelegrammAPI.png)