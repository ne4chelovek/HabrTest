package HabrTest;

import HabrPage.HabrPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HabrTest {
    private WebDriver driver;
    private HabrPage HabrPage;

    final String url = "https://habr.com/ru/articles/";

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.habr.com/");
        HabrPage = new HabrPage(driver);
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Отображение блока новостей под № (1)")
    public void firstNewsBlock() {
        assertTrue(HabrPage.visibleFirstNews(), "Блок новостей под № (1) не отображается");
    }

    @Test
    @DisplayName("Отображение блока новостей под № (2)")
    public void secondNewsBlock() {
        assertTrue(HabrPage.visibleSecondNews(), "Блок новостей под № (2) не отображается");
    }

    @Test
    @DisplayName("Отображение блока новостей под № (3)")
    public void thirdNewsBlock() {
        assertTrue(HabrPage.visibleThirdNews(), "Блок новостей под № (3) не отображается");
    }

    @Test
    @DisplayName("Отображение блока новостей под № (4)")
    public void fourthNewsBlock() {
        assertTrue(HabrPage.visibleFourthNews(), "Блок новостей под № (4) не отображается");
    }

    @Test
    @DisplayName("Отображение блока новостей под № (5)")
    public void fifthNewsBlock() {
        assertTrue(HabrPage.visibleFifthNews(), "Блок новостей под № (5) не отображается");
    }

    @Test
    @DisplayName("Проверка активности полей ввода для регистрации")
    public void registrationPage() {
        HabrPage.clickHumanIcon();
        HabrPage.clickRegButton();
        assertTrue(HabrPage.enableRegEmailField(), "Поле ввода email не активен");
        assertTrue(HabrPage.enableRegPasswordField(), "Поле ввода password не активен");
    }

    @Test
    @DisplayName("Переход через логотип")
    public void logoHabrPage() {
        HabrPage.clickStreamCompany();
        HabrPage.clickLogoHubr();
        assertEquals(url, driver.getCurrentUrl(), "Открыта не верная страница");
    }

    @Test
    @DisplayName("Изменение фильтров выдачи")
    public void changeDatePost() {
        HabrPage.changeFilter();
        assertEquals(url + "top/weekly/", driver.getCurrentUrl(), "Открыта не верная страница");
    }

    @Test
    @DisplayName("Проверка отоброжение рекламы")
    public void adIsVisible() {
        assertTrue(HabrPage.advertisingIsVisible(), "Баннер с рекламой не отображается на странице");
    }

    @Test
    @DisplayName("Выдача элементов по заданной теме")
    public void searchByTopic() {
        String inputText = "QA";
        HabrPage.searchPage();
        HabrPage.searchText(inputText);
        HabrPage.postQATopic();
        assertTrue(HabrPage.postQATopic(), "Пост по заданной теме не отображается");
    }

    @Test
    @DisplayName("Отображение левого переключателя, при просмотре видео")
    public void storyCardSwitchesFirst() {
        HabrPage.habrStoriesCardFirst();
        assertTrue(HabrPage.storiesLeftSwitchesIsVisible(), "Левый переключатель не появился");
    }

    @Test
    @DisplayName("Отображение правого переключателя, при просмотре видео")
    public void storyCardSwitchesLast() {
        HabrPage.habrStoriesCardLast();
        assertTrue(HabrPage.storiesRightSwitchesIsVisible(), "Правый переключатель не появился");
    }

    @Test
    @DisplayName("Отображение панели Хабр в выпадающем блоке")
    public void dropDownPanelHabr() {
        HabrPage.clickDropDownPanel();
        assertTrue(HabrPage.habrPanelIsVisible(), "В выпадающей панели блок Хабр не отображается");
    }

    @Test
    @DisplayName("Отображение панели Q&A в выпадающем блоке")
    public void dropDownPanelQA() {
        HabrPage.clickDropDownPanel();
        assertTrue(HabrPage.qaPanelIsVisible(), "В выпадающей панели блок Q&A не отображается");
    }

    @Test
    @DisplayName("Отображение панели Карьера в выпадающем блоке")
    public void dropDownPanelCareer() {
        HabrPage.clickDropDownPanel();
        assertTrue(HabrPage.careerPanelIsVisible(), "В выпадающей панели блок Карьера не отображается");
    }

    @Test
    @DisplayName("Отображение панели Фриланс в выпадающем блоке")
    public void dropDownPanelFreeLance() {
        HabrPage.clickDropDownPanel();
        assertTrue(HabrPage.freelancePanelIsVisible(), "В выпадающей панели блок Фриланс не отображается");
    }
 
    @Test
    @DisplayName("Отображения сообщения ошибки, при поптке публикации на Хабр без авторизации, через верхнюю кнопку")
    public void errorMessagesAfterTopButtonClick() {
        HabrPage.becomeAuthorTopButtonClick();
        assertTrue(HabrPage.errorMessageIsDisplayed(), "Сообщение ошибки не появилось");
    }

    @Test
    @DisplayName("Отображения сообщения ошибки, при поптке публикации на Хабр без авторизации, через нижнюю кнопку")
    public void errorMessagesAfterBottomButtonClick() {
        HabrPage.becomeAuthorBottomButtonClick();
        assertTrue(HabrPage.errorMessageIsDisplayed(), "Сообщение ошибки не появилось");
    }

    @Test
    @DisplayName("Проверка смены языка")
    public void changeLanguage() {
        HabrPage.clickHumanIcon();
        HabrPage.languageChangeClick();
        HabrPage.waitLanguageChange();
        assertEquals("https://habr.com/en/articles/", driver.getCurrentUrl(), "Открыта страница не на английском языке");

    }
    @Test
    @DisplayName("Проверка активности кнопки перехода на предыдущую страницу")
    public void previousPageButtonIsEnable(){
        HabrPage.prevPageButtonClick();
        assertTrue(HabrPage.prevPageButtonCheck(),"Кнопка не активна");
    }
    @Test
    @DisplayName("Проверка перехода на страницу технической поддержки")
    public void feedBackClickTransition(){
        HabrPage.feedBackClick();
        HabrPage.feedBackWait();
        assertEquals("https://habr.com/ru/feedback/",driver.getCurrentUrl(),"Открыта не верная страница");
    }
}






