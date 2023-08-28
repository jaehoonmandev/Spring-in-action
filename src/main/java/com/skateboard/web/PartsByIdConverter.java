package com.skateboard.web;

import com.skateboard.DTO.Parts;
import com.skateboard.data.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PartsByIdConverter implements Converter<String, Parts> {
    private PartsRepository partsRepo;

    @Autowired
    public PartsByIdConverter(PartsRepository partsRepo){
        this.partsRepo = partsRepo;
    }

    @Override
    public Parts convert(String id){
        Optional<Parts> optionalParts = partsRepo.findById(id);
        return optionalParts.isPresent() ? optionalParts.get() : null;
    }

}
