package com.melsheikh.hotelreservation.repositories.base;

import java.util.List;
import java.util.Optional;

public interface IRepository<I, T> {
    Optional<T> findById(I id);
    List<T> findAll();
    void save(T t);
    T delete(I id);
}
