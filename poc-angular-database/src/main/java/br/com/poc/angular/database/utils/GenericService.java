package br.com.poc.angular.database.utils;

import java.io.Serializable;
import java.util.List;

import br.com.poc.angular.utils.beans.BaseBean;
import br.com.poc.angular.utils.database.interfaces.IServiceBase;

public abstract class GenericService<T extends BaseBean, K extends BaseEntity, ID extends Serializable>
extends GenericServiceWithKey<T, K, ID, ID> implements IServiceBase<T, ID> {

	/////////////////////////////////////////////////////////////////////////////////
	// PUBLIC METHODS (IServiceBase)
	/////////////////////////////////////////////////////////////////////////////////

	@Override
	public T findById(ID id) {
		return parserEntity(this.getConcreteDao().findOne(id));
	}

	@Override
	public List<T> findAll() {
		return parserEntity(this.getConcreteDao().findAll());
	}

	@Override
	public T insert(T bean) {
		return parserEntity(getConcreteDao().saveAndFlush(parserBean(bean)));
	}

	@Override
	public void update(T bean) {
		this.getConcreteDao().save(parserBean(bean));
	}

	@Override
	public void delete(ID bean) {
		this.getConcreteDao().delete(bean);
	}

}
