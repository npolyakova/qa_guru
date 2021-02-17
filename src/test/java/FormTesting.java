import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTesting {

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
        $("#userNumber").setValue("8900000000");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__day--013").click();

        $("#subjectsInput").setValue("Mat").pressEnter();

        $(byText("Reading")).click();

        $("#uploadPicture").uploadFile(new File("C:/Users/Natalya/Pictures/1588266690127712315.jpg"));

        $("#currentAddress").setValue("Sportivnaya street");
        $("#react-select-3-input").setValue("Raj").pressEnter();
        $("#react-select-4-input").setValue("Jaip").pressEnter();

        $("#submit").click();

        $(".fade.modal.show").shouldBe(Condition.visible);
        $(".modal-header").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".modal-body table thead").shouldHave(Condition.text("Label"), Condition.text("Values"));
        $(".modal-body tbody tr", 0).shouldHave(Condition.text("Student Name"), Condition.text("Natalie Polyakova"));
        $(".modal-body tbody tr", 1).shouldHave(Condition.text("Student Email"), Condition.text("natusj13@mail.ru"));
        $(".modal-body tbody tr", 2).shouldHave(Condition.text("Gender"), Condition.text("Female"));
        $(".modal-body tbody tr", 3).shouldHave(Condition.text("Mobile"), Condition.text("8900000000"));
        $(".modal-body tbody tr", 4).shouldHave(Condition.text("Date of Birth"), Condition.text("13 September,1998"));
        $(".modal-body tbody tr", 5).shouldHave(Condition.text("Subjects"), Condition.text("Maths"));
        $(".modal-body tbody tr", 6).shouldHave(Condition.text("Hobbies"), Condition.text("Reading"));
        $(".modal-body tbody tr", 7).shouldHave(Condition.text("Picture"), Condition.text("1588266690127712315.jpg"));
        $(".modal-body tbody tr", 8).shouldHave(Condition.text("Address"), Condition.text("Sportivnaya street"));
        $(".modal-body tbody tr", 9).shouldHave(Condition.text("State and City"), Condition.text("Rajasthan Jaipur"));

        $("#closeLargeModal").click();
        $(".fade.modal.show").shouldNotBe(Condition.visible);
    }
}

