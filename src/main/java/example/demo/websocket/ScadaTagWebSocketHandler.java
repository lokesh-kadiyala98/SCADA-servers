package example.demo.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.io.IOException;

public class ScadaTagWebSocketHandler extends TextWebSocketHandler {
    private Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String tagName = message.getPayload();
        sessions.put(tagName, session);
    }

    public void notifySubscribers(String tagName, String update) {
        WebSocketSession session = sessions.get(tagName);
        if (session != null && session.isOpen()) {
            try {
                session.sendMessage(new TextMessage(update));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
