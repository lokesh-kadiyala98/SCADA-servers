package example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import example.demo.model.ScadaTag;
import example.demo.service.ScadaTagService;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ScadaTagController {

    private final ScadaTagService scadaTagService;

    @Autowired
    public ScadaTagController(ScadaTagService scadaTagService) {
        this.scadaTagService = scadaTagService;
    }

    @GetMapping
    public ResponseEntity<List<ScadaTag>> getAllTags() {
        return new ResponseEntity<>(scadaTagService.getAllTags(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<ScadaTag> getTagByName(@PathVariable String name) {
        return new ResponseEntity<>(scadaTagService.getTagByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ScadaTag> createTag(@RequestBody ScadaTag scadaTag) {
        return new ResponseEntity<>(scadaTagService.createTag(scadaTag), HttpStatus.CREATED);
    }

    @PutMapping("/{name}")
    public ResponseEntity<ScadaTag> updateTag(@PathVariable String name, @RequestBody ScadaTag scadaTag) {
        ScadaTag existingTag = scadaTagService.getTagByName(name);
        if (existingTag != null) {
            scadaTag.setName(name);
            return new ResponseEntity<>(scadaTagService.updateTag(scadaTag), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteTag(@PathVariable String name) {
        scadaTagService.deleteTag(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

