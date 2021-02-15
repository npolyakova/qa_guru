import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class formTesting {

    @BeforeAll
    static void setup(){
        open("https://demoqa.com/automation-practice-form");
    }

    @Test //Успешное заполнение формы
    void formFillingWithCorrectData(){
        $("#firstName").setValue("Natalie");
        $("#lastName").setValue("Polyakova");
        $("#userEmail").setValue("natusj13@mail.ru");
        $(byText("Female")).click();
        $("#userNumber").setValue("89000000000");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__day--013").click();

        //$("#subjectsContainer").click();
        $("#subjectsInput").setValue("Mat").pressEnter();
        //$("#subjectsContainer").setValue("Mat").pressEnter();

        $(byText("Reading")).click();

        $("#uploadPicture").uploadFile(new File("C:/Users/Natalya/Pictures/1588266690127712315.jpg"));

        $("#currentAddress").setValue("Sportivnaya street");
        $("#react-select-3-input").setValue("Raj").pressEnter();
        $("#react-select-4-input").setValue("Jai").pressEnter();

        $("#submit").click();

    }
}

