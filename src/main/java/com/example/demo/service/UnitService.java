package com.example.demo.service;

import com.example.demo.entity.TypeOfDish;
import com.example.demo.entity.Unit;
import com.example.demo.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitService {

    @Autowired
    private UnitRepository unitRepository;

    public Unit insert(Unit unit)
    {

        return  unitRepository.saveAndFlush(unit); //saveAndFlush
    }
    //delete id or user?
    public void delete(Unit unit)
    {

        unitRepository.delete(unit);
    }

    public List<Unit> find()
    {

        return unitRepository.findAll();
    }

    public Optional<Unit> findById(Integer id)
    {

        return unitRepository.findById(id);
    }

    public Unit findByUnit(String unit)
    {

        return unitRepository.findByUnit(unit);
    }
}
