package org.lingBotTeam.lingBot.utils;

import org.lingBotTeam.lingBot.LingBot;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletionStage;

public class Connection {
    public static final String CONNECTION_IP = "0.0.0.0";
    public static final String WEBSOCKET_PORT = "5701";
    public static final String HTTP_PORT = "5700";
    public WebSocket webSocket;
    protected final LingBot bot;

    public Connection(LingBot lbIn) {
        String wsUrl = String.format("ws://%s:%s/all?qq=%s", CONNECTION_IP, WEBSOCKET_PORT, lbIn.getBotQNumber().toString());
//        Long
        URI uri = null;
        try {
            uri = new URI(wsUrl);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpClient httpClient = HttpClient.newBuilder().build();
        webSocket = httpClient.newWebSocketBuilder().connectTimeout(Duration.of(30000, ChronoUnit.MILLIS)).buildAsync(uri, new WebSocket.Listener() {
            /**
             * A {@code WebSocket} has been connected.
             *
             * <p> This is the initial invocation and it is made once. It is
             * typically used to make a request for more invocations.
             *
             * @param webSocket
             * @implSpec The default implementation is equivalent to:
             * <pre>{@code     webSocket.request(1); }</pre>
             */
            @Override
            public void onOpen(WebSocket webSocket) {
                WebSocket.Listener.super.onOpen(webSocket);
            }

            /**
             * A textual data has been received.
             *
             * <p> Return a {@code CompletionStage} which will be used by the
             * {@code WebSocket} as an indication it may reclaim the
             * {@code CharSequence}. Do not access the {@code CharSequence} after
             * this {@code CompletionStage} has completed.
             *
             * @param webSocket the WebSocket on which the data has been received
             * @param data      the data
             * @param last      whether this invocation completes the message
             * @return a {@code CompletionStage} which completes when the
             * {@code CharSequence} may be reclaimed; or {@code null} if it may be
             * reclaimed immediately
             * @implSpec The default implementation is equivalent to:
             * <pre>{@code     webSocket.request(1);
             *    return null; }</pre>
             * @implNote The {@code data} is always a legal UTF-16 sequence.
             */
            @Override
            public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                return WebSocket.Listener.super.onText(webSocket, data, last);
            }

            /**
             * A binary data has been received.
             *
             * <p> This data is located in bytes from the buffer's position to its
             * limit.
             *
             * <p> Return a {@code CompletionStage} which will be used by the
             * {@code WebSocket} as an indication it may reclaim the
             * {@code ByteBuffer}. Do not access the {@code ByteBuffer} after
             * this {@code CompletionStage} has completed.
             *
             * @param webSocket the WebSocket on which the data has been received
             * @param data      the data
             * @param last      whether this invocation completes the message
             * @return a {@code CompletionStage} which completes when the
             * {@code ByteBuffer} may be reclaimed; or {@code null} if it may be
             * reclaimed immediately
             * @implSpec The default implementation is equivalent to:
             * <pre>{@code     webSocket.request(1);
             *    return null; }</pre>
             */
            @Override
            public CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer data, boolean last) {
                return WebSocket.Listener.super.onBinary(webSocket, data, last);
            }

            /**
             * A Ping message has been received.
             *
             * <p> As guaranteed by the WebSocket Protocol, the message consists of
             * not more than {@code 125} bytes. These bytes are located from the
             * buffer's position to its limit.
             *
             * <p> Given that the WebSocket implementation will automatically send a
             * reciprocal pong when a ping is received, it is rarely required to
             * send a pong message explicitly when a ping is received.
             *
             * <p> Return a {@code CompletionStage} which will be used by the
             * {@code WebSocket} as a signal it may reclaim the
             * {@code ByteBuffer}. Do not access the {@code ByteBuffer} after
             * this {@code CompletionStage} has completed.
             *
             * @param webSocket the WebSocket on which the message has been received
             * @param message   the message
             * @return a {@code CompletionStage} which completes when the
             * {@code ByteBuffer} may be reclaimed; or {@code null} if it may be
             * reclaimed immediately
             * @implSpec The default implementation is equivalent to:
             * <pre>{@code     webSocket.request(1);
             *    return null; }</pre>
             */
            @Override
            public CompletionStage<?> onPing(WebSocket webSocket, ByteBuffer message) {
                return WebSocket.Listener.super.onPing(webSocket, message);
            }

            /**
             * A Pong message has been received.
             *
             * <p> As guaranteed by the WebSocket Protocol, the message consists of
             * not more than {@code 125} bytes. These bytes are located from the
             * buffer's position to its limit.
             *
             * <p> Return a {@code CompletionStage} which will be used by the
             * {@code WebSocket} as a signal it may reclaim the
             * {@code ByteBuffer}. Do not access the {@code ByteBuffer} after
             * this {@code CompletionStage} has completed.
             *
             * @param webSocket the WebSocket on which the message has been received
             * @param message   the message
             * @return a {@code CompletionStage} which completes when the
             * {@code ByteBuffer} may be reclaimed; or {@code null} if it may be
             * reclaimed immediately
             * @implSpec The default implementation is equivalent to:
             * <pre>{@code     webSocket.request(1);
             *    return null; }</pre>
             */
            @Override
            public CompletionStage<?> onPong(WebSocket webSocket, ByteBuffer message) {
                return WebSocket.Listener.super.onPong(webSocket, message);
            }

            /**
             * Receives a Close message indicating the WebSocket's input has been
             * closed.
             *
             * <p> This is the last invocation from the specified {@code WebSocket}.
             * By the time this invocation begins the WebSocket's input will have
             * been closed.
             *
             * <p> A Close message consists of a status code and a reason for
             * closing. The status code is an integer from the range
             * {@code 1000 <= code <= 65535}. The {@code reason} is a string which
             * has a UTF-8 representation not longer than {@code 123} bytes.
             *
             * <p> If the WebSocket's output is not already closed, the
             * {@code CompletionStage} returned by this method will be used as an
             * indication that the WebSocket's output may be closed. The WebSocket
             * will close its output at the earliest of completion of the returned
             * {@code CompletionStage} or invoking either of the {@code sendClose}
             * or {@code abort} methods.
             *
             * @param webSocket  the WebSocket on which the message has been received
             * @param statusCode the status code
             * @param reason     the reason
             * @return a {@code CompletionStage} which completes when the
             * {@code WebSocket} may be closed; or {@code null} if it may be
             * closed immediately
             * @apiNote Returning a {@code CompletionStage} that never completes,
             * effectively disables the reciprocating closure of the output.
             *
             * <p> To specify a custom closure code or reason code the
             * {@code sendClose} method may be invoked from inside the
             * {@code onClose} invocation:
             * <pre>{@code     public CompletionStage<?> onClose(WebSocket webSocket,
             *                                      int statusCode,
             *                                      String reason) {
             *        webSocket.sendClose(CUSTOM_STATUS_CODE, CUSTOM_REASON);
             *        return new CompletableFuture<Void>();
             *    } } </pre>
             * @implSpec The default implementation of this method returns
             * {@code null}, indicating that the output should be closed
             * immediately.
             */
            @Override
            public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
                return WebSocket.Listener.super.onClose(webSocket, statusCode, reason);
            }

            /**
             * An error has occurred.
             *
             * <p> This is the last invocation from the specified WebSocket. By the
             * time this invocation begins both the WebSocket's input and output
             * will have been closed. A WebSocket may invoke this method on the
             * associated listener at any time after it has invoked {@code onOpen},
             * regardless of whether or not any invocations have been requested from
             * the WebSocket.
             *
             * <p> If an exception is thrown from this method, resulting behavior is
             * undefined.
             *
             * @param webSocket the WebSocket on which the error has occurred
             * @param error
             */
            @Override
            public void onError(WebSocket webSocket, Throwable error) {
                WebSocket.Listener.super.onError(webSocket, error);
            }
        }).join();
        bot = lbIn;
    }
}
