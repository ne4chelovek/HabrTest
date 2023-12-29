package SelenideTests;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;


public class HabrQnAPageSelenide {
    private final Logger LOG = LoggerFactory.getLogger(HabrQnAPageSelenide.class);
    private static final By RESULTS_XPATH = By.xpath("//li[@class = 'content-list__item']");
    private static final By SEARCH_FIELD_XPATH = By.xpath("//input[@type='search']");
    private static final By MENU_XPATH = By.xpath("//li[@class='main-menu__item']");
    private static final By HEADER_TITLE_XPATH = By.xpath("//h1[@class='page__header-title']");
    private static final By PUBLICATION_DATE_TEXT_CSS =By.cssSelector(".question:first-child .question__date");
    private static final By PUBLICATION_DATE_ELEMENT_XPATH = By.xpath("//time[@class='question__date question__date_publish']");
    @FindBy(xpath = "//a[@class='logo logo_topbar']")
    private SelenideElement qaLogo;


    public boolean checkLogo(){
        LOG.info("Проверка отображения логотипа");
        return qaLogo.isDisplayed();
    }
    public void inputSearchField(){
        LOG.info("Ввод текста");
         $(SEARCH_FIELD_XPATH).setValue("Selenide")
                 .pressEnter();
         LOG.info("Выбор из списка результатов");
        $$(RESULTS_XPATH).get(0)
                .click();
    }
    public void clickAllTagButton(int num){
        LOG.info("Клик по заданному пункту в меню");
        $$(MENU_XPATH).get(num)
                .click();
    }
    public boolean checkTitle(){
        LOG.info("Проверка отображения титульника на странице");
       return $(HEADER_TITLE_XPATH).isDisplayed();
    }

       public String getPublicationDateText(int index) {
        LOG.info("Получаем атрибут из выбранного элемента");
           return $$(PUBLICATION_DATE_ELEMENT_XPATH).get(index)
                   .getAttribute("datetime");
       }

}
