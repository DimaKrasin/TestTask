package net.restapp.servise;

import java.util.List;

public interface IService<T> {
    void save(T entity);

    List<T> getAll();
}
