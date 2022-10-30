package com.shahbazyan.course.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    List<T> list();
    void create(T t);


    void update(T t, int id);

    void delete(int id);



}
