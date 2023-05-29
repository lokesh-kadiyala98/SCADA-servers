package example.demo.event;

import example.demo.model.ScadaTag;
import org.springframework.context.ApplicationEvent;

public class ScadaTagUpdateEvent extends ApplicationEvent {
    private ScadaTag scadaTag;

    public ScadaTagUpdateEvent(Object source, ScadaTag scadaTag) {
        super(source);
        this.scadaTag = scadaTag;
    }

    public ScadaTag getScadaTag() {
        return scadaTag;
    }
}

