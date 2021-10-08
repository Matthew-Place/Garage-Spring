package com.qa.garage.service.interfaces;

import java.util.List;

public interface GenericService<T, K extends Object> {

	public T mapToDTO(K k);

	public List<T> mapToDTO(List<K> k);

	public T findByID(Integer id);

	public List<T> findAll();

	public T create(K k);

	public T update(K k, Integer id);

	public boolean delete(Integer id);
}
