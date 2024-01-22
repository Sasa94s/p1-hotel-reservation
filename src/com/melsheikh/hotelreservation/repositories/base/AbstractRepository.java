package com.melsheikh.hotelreservation.repositories.base;

import com.melsheikh.hotelreservation.models.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractRepository<I, E extends Entity<I>> implements IRepository<I, E> {
    protected final Map<I, E> items;

    protected AbstractRepository() {
        items = new HashMap<>();
    }

    @Override
    public Optional<E> findById(I id) {
        return Optional.ofNullable(items.get(id));
    }

    @Override
    public List<E> findAll() {
        return items.values().stream().toList();
    }

    @Override
    public void save(E entity) {
        items.put(entity.getId(), entity);
    }

    @Override
    public E delete(I id) {
        return items.remove(id);
    }
}
