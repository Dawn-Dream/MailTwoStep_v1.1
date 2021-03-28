package com.dawndream.MailTwoStep.mail;

import java.util.Random;

public class StepCode {
    public String code() {
        int i = new Random().nextInt(1000000);
        String code = String.format("%06d", i);
        return code;
    }
}
