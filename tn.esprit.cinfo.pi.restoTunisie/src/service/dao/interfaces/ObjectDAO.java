package service.dao.interfaces;

import java.util.List;


public interface ObjectDAO<T> {

	public List<T> findAll();

	public T findById(int id);

	public int save(T t);

	public int removeAll();

	public int removeById(int id);

}