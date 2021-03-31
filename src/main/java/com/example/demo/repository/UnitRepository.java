package com.example.demo.repository;

import com.example.demo.entity.Unit;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit,Integer> {
//    @Query("select u from Unit u where u.unit=:unit")
    Unit findByUnit( String unit);
}
