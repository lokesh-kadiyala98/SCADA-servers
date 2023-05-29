package example.demo.listener;

import example.demo.event.ScadaTagUpdateEvent;
import example.demo.model.ScadaTag;
import example.demo.websocket.ScadaTagWebSocketHandler;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ScadaTagUpdateListener implements ApplicationListener<ScadaTagUpdateEvent> {

    private final ScadaTagWebSocketHandler scadaTagWebSocketHandler;

    public ScadaTagUpdateListener(ScadaTagWebSocketHandler scadaTagWebSocketHandler) {
        this.scadaTagWebSocketHandler = scadaTagWebSocketHandler;
    }

    @Override
    public void onApplicationEvent(ScadaTagUpdateEvent event) {
        ScadaTag updatedScadaTag = event.getScadaTag();

        // Notify the WebSocket subscribers if the ScadaTag with the specific name is updated.
        scadaTagWebSocketHandler.notifySubscribers(updatedScadaTag.getName(), Integer.toString(updatedScadaTag.getValue()));
    }
}


