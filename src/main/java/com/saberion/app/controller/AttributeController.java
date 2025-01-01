package com.saberion.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saberion.app.model.Attribute;
import com.saberion.app.service.AttributeService;

@RestController
@RequestMapping("/api/attributes")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @PostMapping
    public ResponseEntity<List<Attribute>> addAttributes(@RequestBody List<Attribute> attributes) {
        List<Attribute> savedAttributes = attributeService.addAttributes(attributes);
        return ResponseEntity.ok(savedAttributes);
    }

    @GetMapping
    public ResponseEntity<List<Attribute>> getAttributesByProductId(@RequestParam Integer productId) {
        List<Attribute> attributes = attributeService.getAttributesByProductId(productId);
        return ResponseEntity.ok(attributes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttribute(@PathVariable Integer id) {
        attributeService.deleteAttribute(id);
        return ResponseEntity.noContent().build();
    }
}
