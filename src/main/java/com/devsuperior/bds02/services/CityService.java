package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository repository;

    @Transactional(readOnly = true)
    public List<CityDTO> findAll() {
        List<City> cities = repository.findAll(Sort.by("name"));
        return cities.stream().map(x -> new CityDTO(x)).toList();
    }

    @Transactional
    public CityDTO insert(CityDTO dto) {
        City entity = new City();
        copyDtoToEntiy(dto, entity);
        repository.save(entity);
        return new CityDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
        City entity = repository.getReferenceById(id);
        repository.delete(entity);
    }


    private void copyDtoToEntiy(CityDTO dto, City entity) {
        entity.setName(dto.getName());
    }
}
