package br.com.poc.angular.utils.database.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.poc.angular.utils.beans.BaseBean;

public interface IServiceBase<T extends BaseBean, ID extends Serializable> {

	T findById(ID id);

	List<T> findAll();

	T insert(T bean);

	void update(T bean);

	void delete(ID bean);

}
