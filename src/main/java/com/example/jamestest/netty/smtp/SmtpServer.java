package com.example.jamestest.netty.smtp;

import org.apache.james.metrics.api.NoopMetricFactory;
import org.apache.james.protocols.api.handler.WiringException;
import org.apache.james.protocols.netty.NettyServer;
import org.apache.james.protocols.smtp.SMTPConfigurationImpl;
import org.apache.james.protocols.smtp.SMTPProtocol;
import org.apache.james.protocols.smtp.SMTPProtocolHandlerChain;
import org.jboss.netty.util.HashedWheelTimer;

import java.net.InetSocketAddress;

public class SmtpServer {

    public void start() throws WiringException {

        SMTPProtocolHandlerChain smtpProtocolHandlerChain = new SMTPProtocolHandlerChain(new NoopMetricFactory());
        smtpProtocolHandlerChain.add(new SmtpEnvelopHandler());
        NettyServer nettyServer = new NettyServer.Factory(new HashedWheelTimer())
                .protocol(new SMTPProtocol(
                        smtpProtocolHandlerChain,
                        new SMTPConfigurationImpl()
                ))
                .build();
        try {
            nettyServer.setListenAddresses(new InetSocketAddress("localhost",9090));
            nettyServer.bind();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
