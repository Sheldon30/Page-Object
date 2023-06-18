package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement amount = $("[data-test-id='action-deposit'] input");
    private SelenideElement fromAmount = $("[data-test-id='from'] input");
    private SelenideElement transferHead = $(byText("Пополнение карты"));

    private SelenideElement amountButton = $("[data-test-id='action-transfer']");
    private SelenideElement errorMessage = $("[data-test-id='error-notification']");
    public TransferPage(){
        transferHead.shouldBe(Condition.visible);
    }
    public void makeTransfer (String transferAmount, DataHelper.CardInfo cardInfo){
        amount.setValue(transferAmount);
        fromAmount.setValue(cardInfo.getCardNumber());
        amountButton.click();

    }
    public DashboardPage makeValidAmount(String transferAmount, DataHelper.CardInfo cardInfo) {
        makeTransfer(transferAmount, cardInfo);
        return new DashboardPage();
    }

    public void ErrorMessageFind(String expectedText){
        errorMessage.shouldHave(Condition.exactText(expectedText), Duration.ofSeconds(10)).shouldBe(Condition.visible);

    }
}
