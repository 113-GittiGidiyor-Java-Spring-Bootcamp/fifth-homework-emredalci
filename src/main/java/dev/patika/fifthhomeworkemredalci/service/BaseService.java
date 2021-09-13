package dev.patika.fifthhomeworkemredalci.service;

import java.util.List;

public interface BaseService<T>{

    List<T> findAll();

    T findByName(String name);

    //T save(T object);

    //T update(T object);

    void deleteById(long id);


}
