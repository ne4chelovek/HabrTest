package com.example.habrtest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.habr.com/");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void News() {

        WebElement ShowMoreNews = driver.findElement(By.xpath("//*[contains(text(), \"Показать еще\")]"));
        ShowMoreNews.click();

        WebElement News = driver.findElement(By.cssSelector("#news_block_1 ul > li:nth-child(1)"));
        News.click();

        assertTrue(driver.findElement(By.xpath("//*[contains(text(), \"Посты\")]")).isDisplayed(), "Элемент не найден");

    }

    @Test
    public void MenuSelection() {

        WebElement AllSelect = driver.findElement(By.cssSelector("nav :nth-child(1)"));
        AllSelect.click();
        assertTrue(driver.findElement(By.cssSelector("[class=\"tm-header__logo-wrap\"]")).isDisplayed());

        WebElement DevSelect = driver.findElement(By.cssSelector("nav :nth-child(2)"));
        DevSelect.click();
        assertTrue(driver.findElement(By.cssSelector("[class=\"tm-header__logo-wrap\"]")).isDisplayed());

        WebElement AdminSelect = driver.findElement(By.cssSelector("nav :nth-child(3)"));
        AdminSelect.click();
        assertTrue(driver.findElement(By.cssSelector("[class=\"tm-header__logo-wrap\"]")).isDisplayed());

        WebElement DesignSelect = driver.findElement(By.cssSelector("nav :nth-child(4)"));
        DesignSelect.click();
        assertTrue(driver.findElement(By.cssSelector("[class=\"tm-header__logo-wrap\"]")).isDisplayed());

        WebElement ManageSelect = driver.findElement(By.cssSelector("nav :nth-child(5)"));
        ManageSelect.click();
        assertTrue(driver.findElement(By.cssSelector("[class=\"tm-header__logo-wrap\"]")).isDisplayed());

    }

}