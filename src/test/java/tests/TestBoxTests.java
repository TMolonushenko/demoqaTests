package tests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;
//class ChromeTest {
//  WebDriver driver;

// @BeforeAll
// static void setupClass() {
//     WebDriverManager.chromedriver().setup();

//  }


// @BeforeEach
//  void setupTest() {
//  driver = new ChromeDriver();
//  }

//  @AfterEach
//  void theardown() {
//  if (driver != null) {
//    driver.quit();

//  }

//  }

public class TestBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = " https://demoqa.com/";
        Configuration.browserSize = "1920x1080";

    }


    @Test
    void successFillTest() {
        open("automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Bond");
        $("#userEmail").setValue("alex@compani.com");
        $(byText("Other")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();

        $(".react-datepicker__year-select").selectOption("1984");
        $(".react-datepicker__month-select").selectOption("May");
        $(byText("24")).click();

        $("#subjectsInput").setValue("English").pressEnter();
        $(byText("Music")).click();
        // $("#hobbies-checkbox-1").sendKeys("Music");
        $("#uploadPicture").uploadFile(new File("src/test/resources/mem.jpg"));


        //хобби
        // $(".custom-control-label").setValue("Dharmapuri, Forest Colony, Tajganj");
        //тут должна быть картинка
        $("#currentAddress").setValue("Rome");
        $("#state").scrollTo().click();
        $(byText("Uttar Pradesh")).click();
        $("#city").scrollTo().click();
        $(byText("Agra")).click();

        $("#submit").click();


        $(".table-responsive").shouldHave(text("Alex Bond"));
        $(".table-responsive").shouldHave(text("alex@compani.com"));
        $(".table-responsive").shouldHave(text("Other"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("24 May, 1984"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("mem.jpg"));
        $(".table-responsive").shouldHave(text("Rome"));
        $(".table-responsive").shouldHave(text("Dharmapuri, Forest Colony, Tajganj, Agra, Uttar Pradesh 282001, India"));
        $(".table-responsive").shouldHave(text("Uttar Pradesh Agra"));

        $("#closeLargeModal").click();

    }
}

