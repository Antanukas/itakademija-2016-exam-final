package lt.akademija.jpaexam.ex02associaions;

public interface Repository<T> {

	T saveOrUpdate(T e);

	public T find(Long id);

}
