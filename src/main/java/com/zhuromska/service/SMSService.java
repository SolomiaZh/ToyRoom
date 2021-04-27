package com.lotos.model.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSService {

    final private static String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    final private static String AUTH_TOKEN = System.getenv("TWILIO_AUH_TOKEN");
    final private static PhoneNumber phoneNumber = new PhoneNumber("+380952193407");
    final private static PhoneNumber servicePhoneNumber = new PhoneNumber("+18176011946");

    public static void sendSMS(String msg) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(phoneNumber, servicePhoneNumber, msg).create();
    }
}
