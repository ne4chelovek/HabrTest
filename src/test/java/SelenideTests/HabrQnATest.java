package SelenideTests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HabrQnATest {

    private HabrQnAPage habrQnAPage;


    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        habrQnAPage = page();
        open("https://qna.habr.com/");

    }

    @DisplayName("Проверка отображения логотипа")
    @Test
    public void logoCheck() {
        assertTrue(habrQnAPage.checkLogo(), "Logo was not reflected");
    }

    @DisplayName("Проверка поиска и выдачи элементов")
    @Test
    public void transitAfterInputText() {
        habrQnAPage.inputSearchField();
        assertEquals("https://qna.habr.com/q/1318580", url(), "Открыта не та страница");
    }

    @DisplayName("Проверка отображения корректности титульника после перехода на выбранную в меню страницу")
    @Test
    public void visibleTitleMainPage() {
        habrQnAPage.clickAllTagButton(1);
        assertTrue(habrQnAPage.checkTitle(), "Title is not displayed");
        habrQnAPage.clickAllTagButton(0);
        assertEquals("https://qna.habr.com/questions", url(), "Открыта не та страница");
    }

    @DisplayName("Проверка даты публикации на главной странице")
    @Test
    public void testPublicationDate() {
        // Получаем дату публикации первой публикации на странице
        String publicationDateText = habrQnAPage.getPublicationDateText(0);

        // Парсим дату публикации
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime publicationDate = LocalDateTime.parse(publicationDateText, formatter);

        // Проверяем, что дата публикации не превышает сутки
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterday = now.minusDays(1);
        assertTrue(publicationDate.isAfter(yesterday), "Дата публикации превышает сутки");
    }
}

