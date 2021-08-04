package сomponents;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class Calendar {

    public void selectDate(String year, String month, String day) {
        $x("//*[@id='dateOfBirthInput']").click();
        $x("//*[@class='react-datepicker__year-select']").selectOption(year);
        $x("//*[@class='react-datepicker__month-select']").selectOption(month);
        String dayLocator = format("//div[contains(@class, 'react-datepicker__day--0%s') and " +
                "not(contains(@class, 'react-datepicker__day--outside-month'))]", day);
        $x(dayLocator).click();
    }
}
