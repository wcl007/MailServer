package com.example.jamestest.netty.smtp;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.james.protocols.smtp.MailEnvelope;
import org.apache.james.protocols.smtp.SMTPSession;
import org.apache.james.protocols.smtp.hook.HookResult;
import org.apache.james.protocols.smtp.hook.MessageHook;

import java.io.IOException;

public class SmtpEnvelopHandler implements MessageHook {


    @Override
    public HookResult onMessage(SMTPSession smtpSession, MailEnvelope mailEnvelope) {
        System.out.println(mailEnvelope.getSender() + " " + mailEnvelope.getRecipients() + " " + mailEnvelope.getSize());
        try {
            System.out.println(mailEnvelope.getMessageInputStream().read());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return HookResult.OK;
    }

    @Override
    public void init(Configuration configuration) throws ConfigurationException {

    }

    @Override
    public void destroy() {

    }
}
