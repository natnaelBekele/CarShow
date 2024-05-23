package com.binary.repository;

import com.binary.Entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

    //count()=> return the number of entity
//    findAll()=> return all item of given type
//    deletByID()=>
//    delete(T Entity)
//    deleteAll()
//    save(T Entity)
//    savwAll()
}
