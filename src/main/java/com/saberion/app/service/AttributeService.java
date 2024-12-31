package com.saberion.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saberion.app.model.Attribute;
import com.saberion.app.repository.AttributeRepository;

@Service
public class AttributeService {

    @Autowired
    private AttributeRepository attributeRepository;

    
    public List<Attribute> addAttributes(List<Attribute> attributes) {
        return attributeRepository.saveAll(attributes);
    }

    
    public List<Attribute> getAttributesByProductId(Integer productId) {
        return attributeRepository.findByProductId(productId);
    }

    
    public void deleteAttribute(Integer attributeId) {
        attributeRepository.deleteById(attributeId);
    }
}
