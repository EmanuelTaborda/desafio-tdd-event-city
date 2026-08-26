package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.repositories.EventRepository;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    EventRepository repository;

    @Transactional
    public EventDTO update(Long id, EventDTO dto) {
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado.");
        }
        Event entity = repository.getReferenceById(id);
        City city = cityRepository.getReferenceById(dto.getCityId());
        entity.setCity(city);
        entity.setDate(dto.getDate());
        entity.setName(dto.getName());
        entity.setUrl(dto.getUrl());
        entity = repository.save(entity);
        return new EventDTO(entity);
    }
}
