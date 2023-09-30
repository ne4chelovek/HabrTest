package HabrPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

//https://habr.com/ru/articles/
public class HabrPage {
    WebDriver driver;

    private final Logger LOG = LoggerFactory.getLogger(HabrPage.class);

    @FindBy(css = "#news_block_1 ul > li:nth-child(1)")
    private WebElement firstNews;

    @FindBy(css = "#news_block_1 ul > li:nth-child(2)")
    private WebElement secondNews;

    @FindBy(css = "#news_block_1 ul > li:nth-child(3)")
    private WebElement thirdNews;

    @FindBy(css = "#news_block_1 ul > li:nth-child(4)")
    private WebElement fourthNews;

    @FindBy(css = "#news_block_1 ul > li:nth-child(5)")
    private WebElement fifthNews;

    @FindBy(xpath = "//div[@class='tm-checkbox-labeled__input']")
    private List<WebElement> languageRadioButton;

    @FindBy(css = "div > a.tm-user-menu__auth-button.tm-user-menu__auth-button_primary")
    private WebElement registrationButton;

    @FindBy(xpath = "//div[@class='tm-dropdown']")
    private WebElement humanIcon;

    @FindBy(xpath = "//button[@class='tm-user-menu__menu-link tm-user-menu__menu-link_grey']")
    private WebElement languageMenu;

    @FindBy(id = "email_field")
    private WebElement regEmailField;

    @FindBy(id = "password_field")
    private WebElement regPasswordField;

    @FindBy(css = "span > a > svg")
    private WebElement logoHabr;

    @FindBy(css = " div.tm-tabs.tm-tabs_page-header.tm-tabs > div > span:nth-child(6)")
    private WebElement streamCompany;

    @FindBy(css = "div.tm-navigation-filters-spoiler__wrapper > button.tm-navigation-filters-spoiler__button")
    private WebElement filterButton;

    @FindBy(xpath = "//button[contains(text(),'Лучшие')]")
    private WebElement showFirstButton;

    @FindBy(xpath = "//button[contains(text(),'Неделя')]")
    private WebElement perWeekButton;

    @FindBy(xpath = "//button[contains(text(),'Применить')]")
    private WebElement acceptButton;

    @FindBy(xpath = "//button[@class='tm-header__dropdown-toggle']")
    private WebElement switchPages;

    @FindBy(xpath = "//a[@href='https://career.habr.com?utm_source=habr&utm_medium=habr_top_panel']")
    private WebElement careerPanel;

    @FindBy(xpath = "//a[@href='https://qna.habr.com?utm_source=habr&utm_medium=habr_top_panel']")
    private WebElement qaPanel;

    @FindBy(xpath = "//a[@href='/']")
    private WebElement habrPanel;

    @FindBy(xpath = "//a[@href='https://freelance.habr.com?utm_source=habr&utm_medium=habr_top_panel']")
    private WebElement freelancePanel;

    @FindBy(xpath = "//div[@class='tm-adfox-banner__container tm-layout-sidebar__banner tm-layout-sidebar__banner_top']")
    private WebElement adBanner;

    @FindBy(xpath = "//a [@href='/ru/search/']")
    private WebElement searchIcon;

    @FindBy(xpath = "//input[@autofocus='autofocus']")
    private WebElement searchField;

    @FindBy(xpath = "//span[@class='tm-svg-icon__wrapper tm-search__icon']")
    private WebElement buttonSearchInSearchField;

    @FindBy(xpath = "//article[@data-navigatable]")
    private List<WebElement> listQAPost;

    @FindBy(xpath = "//button[@class='tm-stories-card__image-block']")
    private List<WebElement> storiesCard;

    @FindBy(xpath = "//div[@class='tm-story__button tm-story__button_right']")
    private WebElement rightPointerSwitches;

    @FindBy(xpath = "//div[@class='tm-story__button tm-story__button_left']")
    private WebElement leftPointerSwitches;

    @FindBy(xpath = "//button[@class='swiper-button-next']")
    private List<WebElement> storyCardSwitches;

    @FindBy(xpath = "//a[@class='tm-header__become-author-btn']")
    private WebElement becomeAuthor;

    @FindBy(xpath = "//a[@class='button']")
    private List<WebElement> writePublication;

    @FindBy(xpath = "//h1[@class='tm-error-message__title']")
    private WebElement errorMessageTitle;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement savePreferenceButton;

    @FindBy(xpath = "//a[@id='pagination-next-page']")
    private WebElement nextPageButton;

    @FindBy(xpath = "//div[@id='pagination-prev-page'] ")
    private WebElement prevPageButton;

    @FindBy(xpath = "//a[@href='/ru/feedback/']")
    private WebElement feedBack;

    public HabrPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean visibleFirstNews() {
        LOG.info("Блок новостей под № (1) отображается");
        return firstNews.isDisplayed();
    }

    public boolean visibleSecondNews() {
        LOG.info("Блок новостей под № (2) отображается");
        return secondNews.isDisplayed();
    }

    public boolean visibleThirdNews() {
        LOG.info("Блок новостей под № (3) отображается");
        return thirdNews.isDisplayed();
    }

    public boolean visibleFourthNews() {
        LOG.info("Блок новостей под № (4) отображается");
        return fourthNews.isDisplayed();
    }

    public boolean visibleFifthNews() {
        LOG.info("Блок новостей под № (5) отображается");
        return fifthNews.isDisplayed();
    }

    public void clickHumanIcon() {
        LOG.info("Клик по меню");
        humanIcon.click();
    }

    public void clickRegButton() {
        LOG.info("Клик по панели 'Регистрация'");
        registrationButton.click();
    }

    public boolean enableRegEmailField() {
        LOG.info("Проверка активности поля ввода email");
        return regEmailField.isEnabled();
    }

    public boolean enableRegPasswordField() {
        LOG.info("Проверка активности поля ввода password");
        return regPasswordField.isEnabled();
    }

    public void clickLogoHubr() {
        LOG.info("Клик по логотипу Хабр");
        logoHabr.click();
    }

    public void clickStreamCompany() {
        LOG.info("Клик по панели 'Компании'");
        streamCompany.click();
    }

    public void changeFilter() {
        filterButton.click();
        showFirstButton.click();
        perWeekButton.click();
        acceptButton.click();
    }

    public boolean advertisingIsVisible() {
        LOG.info("Проверка видимости рекламы");
        return adBanner.isDisplayed();
    }

    public void searchPage() {
        searchIcon.click();
        searchField.click();
    }

    public void searchText(String inputText) {
        LOG.info("Поиск по заданному тексту");
        searchField.sendKeys(inputText);
        buttonSearchInSearchField.click();
    }

    public boolean postQATopic() {
        LOG.info("Проверка отображения постов");
        return listQAPost.get(0).isDisplayed();
    }

    public void habrStoriesCardFirst() {
        LOG.info("Open story card");
        storiesCard.get(0).click();
        rightPointerSwitches.click();
    }

    public boolean storiesLeftSwitchesIsVisible() {
        return leftPointerSwitches.isDisplayed();
    }

    public void habrStoriesCardLast() {
        LOG.info("Open story card");
        storyCardSwitches.get(0).click();
        storiesCard.get(6).click();
        leftPointerSwitches.click();
    }

    public boolean storiesRightSwitchesIsVisible() {
        return leftPointerSwitches.isDisplayed();
    }

    public void clickDropDownPanel() {
        LOG.info("Click drop panel");
        switchPages.click();
    }

    public boolean habrPanelIsVisible() {
        return habrPanel.isDisplayed();
    }

    public boolean qaPanelIsVisible() {
        return qaPanel.isDisplayed();
    }

    public boolean careerPanelIsVisible() {
        return careerPanel.isDisplayed();
    }

    public boolean freelancePanelIsVisible() {
        return freelancePanel.isDisplayed();
    }

    public void becomeAuthorTopButtonClick() {
        LOG.info("Нажате на панель 'Как стать автором'");
        becomeAuthor.click();
        LOG.info("Нажатие на верхнюю кнопку 'Написать публикацию'");
        writePublication.get(0).click();
    }

    public void becomeAuthorBottomButtonClick() {
        LOG.info("Нажате на панель 'Как стать автором'");
        becomeAuthor.click();
        LOG.info("Нажатие на нижнию панель 'Написать публикацию'");
        writePublication.get(1).click();
    }

    public boolean errorMessageIsDisplayed() {
        return errorMessageTitle.isDisplayed();
    }

    public void languageChangeClick() {
        LOG.info("Нажатие на панель 'Язык,лента'");
        languageMenu.click();
        LOG.info("Нажатие на радио кнопку 'English'");
        languageRadioButton.get(1).click();
        LOG.info("Нажатие на кнопку сохранить настройки");
        savePreferenceButton.click();
    }

    public void waitLanguageChange() {
        LOG.info("Ожиание проверки URL");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlToBe("https://habr.com/en/articles/"));
    }

    public void prevPageButtonClick() {
        LOG.info("Нажатие на кнопку переключения страницы");
        nextPageButton.click();
    }

    public boolean prevPageButtonCheck() {
        return prevPageButton.isEnabled();
    }

    public void feedBackClick() {
        LOG.info("Нажатие на кнопку");
        feedBack.click();
    }

    public void feedBackWait() {
        LOG.info("Ожидание перехода");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlToBe("https://habr.com/ru/feedback/"));
    }
}


