package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


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
        $(".react-datepicker__day--024").click();
        //$("[aria-label$='May 24th, 1984']").click();
        // $(byText("24")).click();
        // $("react-datepicker__day--024").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/mem.jpg"));
        $("#currentAddress").setValue("Rome");
        //  $("#state").scrollTo().click();
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Agra").pressEnter();
        //$("#city").scrollTo().click();
        // $(byText("Agra")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text("Alex Bond"));
        $(".table-responsive").$(byText("Student Email"))
                .parent().shouldHave(text("alex@compani.com"));
        $(".table-responsive").$(byText("Gender"))
                .parent().shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile"))
                .parent().shouldHave(text("1234567890"));
        $(".table-responsive").$(byText("Date of Birth"))
                .parent().shouldHave(text("24 May,1984"));
        $(".table-responsive").$(byText("Subjects"))
                .parent().shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies"))
                .parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture"))
                .parent().shouldHave(text("mem.jpg"));
        $(".table-responsive").$(byText("Address"))
                .parent().shouldHave(text("Rome"));
        $(".table-responsive").$(byText("State and City"))
                .parent().shouldHave(text("Uttar Pradesh Agra"));

        $("#closeLargeModal").click();

    }
}

