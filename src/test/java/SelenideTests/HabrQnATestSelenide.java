package SelenideTests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HabrQnATestSelenide {

  private HabrQnAPageSelenide habrQnAPageSelenide;


  @BeforeAll
  public static void setUpAll() {
      Configuration.browserSize = "1280x800";
  }

   @BeforeEach
   public void setUp() {
      // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
       Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
       habrQnAPageSelenide = page();
       open("https://qna.habr.com/");

   }

    @Test
    public void logoCheck(){
      assertTrue(habrQnAPageSelenide.checkLogo(),"Logo was not reflected");
    }

    @Test
    public void transitAfterInputText(){
      habrQnAPageSelenide.inputSearchField();
      assertEquals("https://qna.habr.com/q/1318580",url(),"Открыта не та страница");
    }
    @Test
    public void visibleTitleMainPage(){
      habrQnAPageSelenide.clickAllTagButton(1);
      assertTrue(habrQnAPageSelenide.checkTitle(),"Title is not displayed");
      habrQnAPageSelenide.clickAllTagButton(0);
      assertEquals("https://qna.habr.com/questions",url(),"Открыта не та страница");
    }
   @Test
   public void testPublicationDate() {
       // Получаем дату публикации первой публикации на странице
       String publicationDateText = habrQnAPageSelenide.getPublicationDateText(0);

       // Парсим дату публикации
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       LocalDateTime publicationDate = LocalDateTime.parse(publicationDateText, formatter);

       // Проверяем, что дата публикации не превышает сутки
       LocalDateTime now = LocalDateTime.now();
       LocalDateTime yesterday = now.minusDays(1);
       assertTrue(publicationDate.isAfter(yesterday),"Дата публикации превышает сутки");
   }

}

