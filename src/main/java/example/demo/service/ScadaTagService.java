package example.demo.service;

import example.demo.event.ScadaTagUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import example.demo.model.ScadaTag;
import example.demo.repository.ScadaTagRepository;

import java.util.List;

@Service
public class ScadaTagService {

    private final ScadaTagRepository scadaTagRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public ScadaTagService(ScadaTagRepository scadaTagRepository, ApplicationEventPublisher eventPublisher) {
        this.scadaTagRepository = scadaTagRepository;
        this.eventPublisher = eventPublisher;
    }

    public List<ScadaTag> getAllTags() {
        return scadaTagRepository.findAll();
    }

    public ScadaTag getTagByName(String name) {
        return scadaTagRepository.findById(name).orElse(null);
    }

    public ScadaTag createTag(ScadaTag scadaTag) {
        return scadaTagRepository.save(scadaTag);
    }

    public ScadaTag updateTag(ScadaTag scadaTag) {
        ScadaTag savedTag = scadaTagRepository.save(scadaTag);
        eventPublisher.publishEvent(new ScadaTagUpdateEvent(this, savedTag));
        return savedTag;
    }

    public void deleteTag(String name) {
        scadaTagRepository.deleteById(name);
    }
}
