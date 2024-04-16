import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
    final static String URl = "https://school.qa.guru/";
    static {
        Configuration.pageLoadStrategy ="eager";
    }
    @AfterEach
    void closeWebDriver(){
        Selenide.closeWebDriver();
    }
    @Test
    void successfulLoginTest() {
        open(URl);
        $("[name=email]").setValue("qagurubot@gmail.com").pressEnter();
        $("[name=password]").setValue("somepasshere").pressEnter();
        $(".page-header").shouldHave(text("Список тренингов"));
        open(URl+"cms/system/login");
        $(".logined-form").shouldHave(text("QA_GURU_BOT"));
    }
}
