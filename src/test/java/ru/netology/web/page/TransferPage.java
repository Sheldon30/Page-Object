package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage {
    public TransferPage Card1(){
        $$("[data-test-id='action-deposit']").get(1).click();
        return new TransferPage();
    }


}
