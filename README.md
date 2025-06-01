
<p align="center"> 
  <img src="media/pictures/companн_logo.png" alt="HAR Logo" width="400px" height="70px">
</p>

<p align="center">
  Проект по автоматизации для сайта компании <br>
  <a href="https://example.com" style="color: #05f2fa;>Offer Now</a>
</p>


## :scroll: Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

### :computer: Используемый стек

<p align="center">
<img width="7%" title="IntelliJ IDEA" src="media/icons/Intelij_IDEA.png">
<img width="7%" title="Java" src="media/icons/Java.png">
<img width="7%" title="selenide" src="media/icons/Selenide.png">
<img width="7%" title="Selenoid" src="media/icons/Selenoid.png">
<img width="7%" title="Allure Report" src="media/icons/Allure_Report.png">
<img width="7%" title="Gradle" src="media/icons/Gradle.png">
<img width="7%" title="JUnit5" src="media/icons/JUnit5.png">
<img width="5%" title="GitHub" src="media/icons/github.png">
<img width="7%" title="Jenkins" src="media/icons/Jenkins.png">
<img width="7%" title="Telegram" src="media/icons/Telegram.png">
<!--<img width="5%" title="Jira" src="media/logo/Jira.svg">-->
</p>

Тесты в данном проекте написаны на языке <code>Java</code> с использованием фреймворка для тестирования [Selenide](https://selenide.org/), сборщик - <code>Gradle</code>. <code>JUnit 5</code> задействован в качестве фреймворка модульного тестирования.
При прогоне тестов для запуска браузеров используется [Selenoid](https://aerokube.com/selenoid/).
Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота. Так же реализована интеграция с <code>Allure TestOps</code> и <code>Jira</code>.

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## :arrow_forward: Запуск автотестов

### Запуск тестов из терминала
```
gradle clean 
all_test 
-Dbrowser=chrome 
-DbrowserVersion=127.0 
-DbrowserSize=1920x1200 
-DselenoidUrl=selenoid.autotests.cloud 
```
При выполнении данной команды в терминале IDE тесты запустятся удаленно в <code>Selenoid</code>.


<p align="center"> 

## <img width="7%" style="vertical-align:middle" src="media/pictures/Jenkins_logo.png" alt="Jenkins Logo"> Сборка в Jenkins

</p>




Для запуска сборки необходимо перейти в раздел <code> Build with Parameters:</code> и нажать кнопку <code>Build</code>.
<p align="center">

<img title="Jenkins Build" src="media/pictures/build.PNG">
</p>

После выполнения сборки, в блоке <code>История сборок</code> напротив номера сборки появятся значки <code>Allure Report</code>, при клике на которую откроется страница с сформированным отчетом.

<p align="center">

## <img width="7%" style="vertical-align:middle" alt="Allure Report" src="media/icons/Allure_Report.png"> Пример Allure-отчета
### Overview

</p>

<p align="center">
<img title="Allure Overview" src="media/pictures/allure_overview.png">
</p>


<p align="center">
<img title=https://jenkins.autotests.cloud/job/035_vacancy_test_home/23/allure/#>
</p>

### Результат выполнения автотестов



После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/pictures/telegram.PNG">
</p>

### <img width="7%" style="vertical-align:middle" title="Selenoid" src="media/icons/Selenoid.png"> Видео примера запуска тестов в Selenoid

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста


<p align="center">
  <img title="Selenoid Video" src="media/Video/video.gif">
</p>
