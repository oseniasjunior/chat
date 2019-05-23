/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academy.helpers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import lombok.Setter;
import tech.gusavila92.websocketclient.WebSocketClient;

/**
 * @author ozzy
 */
public class GenericWebsocket extends WebSocketClient {

    @Setter
    private Runnable onOpenAction;

    @Setter
    private ChatRunnable onTextReceivedAction;

    @Setter
    private Runnable onExceptionAction;

    private final int ONE_SECOND = 1000;
    private final int ONE_MINUTE = ONE_SECOND * 60;

    public GenericWebsocket(String url) throws URISyntaxException {
        super(new URI(url));
        setConnectTimeout(ONE_SECOND);
        // close and reopen connection when long time without received 
        setReadTimeout(ONE_MINUTE * 60);
        // automatic reconnect in 15 seconds
        enableAutomaticReconnection(ONE_SECOND * 15);
    }

    @Override
    public void onOpen() {
        if (Objects.nonNull(onOpenAction)) {
            onOpenAction.run();
        }
    }

    @Override
    public void onTextReceived(String message) {
        if (Objects.nonNull(onTextReceivedAction)) {
            onTextReceivedAction.run(message);
        }
    }

    @Override
    public void onBinaryReceived(byte[] bytes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onPingReceived(byte[] bytes) {
        System.out.println("onPingReceived");
    }

    @Override
    public void onPongReceived(byte[] bytes) {
        System.out.println("onPongReceived");
    }

    @Override
    public void onException(Exception excptn) {
        if (Objects.nonNull(onExceptionAction)) {
            onExceptionAction.run();
        }
    }

    @Override
    public void onCloseReceived() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
