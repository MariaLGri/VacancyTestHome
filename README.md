
<p align="center"> 
  <img src="media/pictures/company_logo.png" alt="HAR Logo" width="400px" height="70px">
</p>

<div align="center">
  <h3>ПРОЕКТ ПО АВТОМАТИЗАЦИИ ДЛЯ САЙТА КОМПАНИИ</h3>
  <a href="https://offer-now.ru/" title="Официальный сайт" style="color: #0066cc; font-size: 1.25rem; font-weight: 600; text-decoration: none;">
    OFFER NOW
  </a>
</div>

## :scroll: Содержание:

- [Используемый стек](#используемый-стек)
- [Запуск автотестов](#запуск-автотестов)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Пример Allure-отчета](#пример-allure-отчета)
- [Интеграция](#Интеграция)
- [Уведомления в Telegram](#уведомления-в-telegram)
- [Видео примера запуска тестов](#видео-примера-запуска-тестов)

<a id="используемый-стек"></a>
# :computer: Используемый стек

<p align="center">
<img width="7%" title="IntelliJ IDEA" src="media/icons/Intelij_IDEA.png">
<img width="7%" title="Java" src="media/icons/Java.png">
<img width="7%" title="selenide" src="media/icons/Selenide.png">
<img width="7%" title="Selenoid" src="media/icons/Selenoid.png">
<img width="7%" title="Allure Report" src="media/icons/Allure_Report.png">
<img width="7%" title="Gradle" src="media/icons/Gradle.png">
<img width="7%" title="JUnit5" src="media/icons/JUnit5.png">
<img width="7%" title="JUnit5" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/github/github-original.svg" />
<img width="7%" title="Jenkins" src="media/icons/Jenkins.png">
<img width="7%" title="Jenkins" src="media/icons/AllureTestOps.svg">
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

<a id="запуск-автотестов"></a>
# :arrow_forward: Запуск автотестов

# Запуск тестов из терминала
```
gradle clean 
all_test 
-Dbrowser=chrome 
-DbrowserVersion=127.0 
-DbrowserSize=1920x1200 
-DselenoidUrl=selenoid.autotests.cloud 
```
При выполнении данной команды в терминале IDE тесты запустятся удаленно в <code>Selenoid</code>.


<a id="сборка-в-jenkins"></a>
<p align="center"> 

# <img width="28px" style="vertical-align:middle" src="media/pictures/Jenkins_logo.png" alt="Jenkins Logo"> Сборка в Jenkins

</p>




Для запуска сборки необходимо перейти в раздел <code> Build with Parameters:</code> и нажать кнопку <code>Build</code>.
<p align="center">

<img title="Jenkins Build" src="media/pictures/build.PNG">
</p>

После выполнения сборки, в блоке <code>История сборок</code> напротив номера сборки появятся значки <code>Allure Report</code>, при клике на которую откроется страница с сформированным отчетом.

<a id="пример-allure-отчета"></a>
<p align="center">

# <img width="28px" style="vertical-align:middle" alt="Allure Report" src="media/icons/Allure_Report.png"> Пример Allure-отчета




## 📊 Allure Report Insights

### 🔍 Overview
<p align="center">
  <a href="https://jenkins.autotests.cloud/job/035_vacancy_test_home/23/allure/#" target="_blank" rel="noopener noreferrer">
    <img src="media/pictures/allure_overview.png" alt="Allure Overview Dashboard" style="border: 1px solid #ddd; border-radius: 4px; padding: 5px;">
  </a>
  <br>
  <a href="https://jenkins.autotests.cloud/job/035_vacancy_test_home/23/allure/#" target="_blank" rel="noopener noreferrer" style="display: inline-block; margin-top: 10px; padding: 8px 16px; background-color: #01fdfa; color: white; text-decoration: none; border-radius: 4px; font-weight: bold;">
    🚀 Открыть полный отчёт
  </a>
</p>

### Suites

### 📂 Test Suites
<p align="center">
  <a href="https://jenkins.autotests.cloud/job/035_vacancy_test_home/23/allure/#suites/a657a03f5cf0e7f2aa2f3b2cec09b6fd/e16f0f1c4492a626/" target="_blank" rel="noopener noreferrer">
    <img src="media/pictures/suites.png" alt="Allure Test Suites" style="border: 1px solid #ddd; border-radius: 4px; padding: 5px; margin-top: 20px;">
  </a>
  <br>
  <a href="https://jenkins.autotests.cloud/job/035_vacancy_test_home/23/allure/#suites/a657a03f5cf0e7f2aa2f3b2cec09b6fd/e16f0f1c4492a626/" target="_blank" rel="noopener noreferrer" style="display: inline-block; margin-top: 10px; padding: 8px 16px; background-color: #6a5acd; color: white; text-decoration: none; border-radius: 4px; font-weight: bold;">
    🔎 Детализация тест-сьютов
  </a>
</p>

### 📈 Test Analytics
<p align="center">
  <a href="https://jenkins.autotests.cloud/job/035_vacancy_test_home/23/allure/#graph" target="_blank" rel="noopener noreferrer">
    <img src="media/pictures/graph.png" alt="Allure Analytics Graph" style="border: 1px solid #ddd; border-radius: 4px; padding: 5px; margin-top: 20px;">
  </a>
  <br>
  <a href="https://jenkins.autotests.cloud/job/035_vacancy_test_home/23/allure/#graph" target="_blank" rel="noopener noreferrer" style="display: inline-block; margin-top: 10px; padding: 8px 16px; background-color: #2e8b57; color: white; text-decoration: none; border-radius: 4px; font-weight: bold;">
    📊 Анализ выполнения тестов
  </a>
</p>



<a id="Интеграция"></a>

# <img width="28px" src="media/icons/AllureTestOps.svg"> Интеграция с Allure TestOps

### 📈 Аналитика тестов в Allure TestOps

<p align="center">
   <br>
<img width="70%" title="Telegram Notifications" src="media/pictures/allure_testops_dahsbord.png">
 <br>
  <a href="https://allure.autotests.cloud/project/4774/dashboards" target="_blank" style="background-color:#00B4A0;color:white;padding:10px 24px;border-radius:6px;text-decoration:none;font-weight:600;margin-top:16px;display:inline-block;">
    Открыть в Allure TestOps
  </a>
</p>

<a id="уведомления-в-telegram"></a>

# <img width="28px" style="vertical-align:middle" title="Selenoid" src="media/icons/Telegram.png"> Результат выполнения автотестов


После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/pictures/telegram.PNG">
</p>


<a id="видео-примера-запуска-тестов"></a>

# <img width="6%" style="vertical-align:middle" title="Selenoid" src="media/icons/Selenoid.png"> Видео примера запуска тестов в Selenoid


В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста


<p align="center">
  <img src="media/Video/video.gif" alt="Demo" width="500">
</p>
