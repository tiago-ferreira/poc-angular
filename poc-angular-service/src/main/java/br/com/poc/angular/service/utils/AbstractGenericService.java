package br.com.poc.angular.service.utils;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;

import br.com.poc.angular.utils.beans.BaseBean;
import br.com.poc.angular.utils.database.interfaces.IServiceBase;
import br.com.poc.angular.utils.services.interfaces.IGenericServiceDistribution;

public abstract class AbstractGenericService<T extends BaseBean, PK extends Serializable> implements IGenericServiceDistribution<T, PK> {

	private static final ObjectMapper jsonMapper = new ObjectMapper();

	private Logger logger = Logger.getLogger(this.getClass());

	private Class<T> entityType;

	private Class<PK> keyType;

	static {
		jsonMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@SuppressWarnings("unchecked")
	public AbstractGenericService() {
		if (this.logger.isInfoEnabled()) {
			this.logger.info(String.format("Creating a REST service [%s].", this.getClass().getGenericSuperclass()));
		}

		try {
			ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
			Type[] genericTypes = parameterizedType.getActualTypeArguments();
			entityType = (Class<T>)genericTypes[0];
			setKeyType((Class<PK>)genericTypes[1]);
		} catch (RuntimeException e) {
			this.logger.error(e.getMessage(), e);
			// Re-throw the exception.
			throw e;
		}
	}

	protected abstract IServiceBase<T, PK> getGenericRepository();

	@Override
	public void insert(Object jsonEntityObject) {
		T entityObject = jsonMapper.convertValue(jsonEntityObject, entityType);

		this.getGenericRepository().insert(entityObject);
	}

	@Override
	public void delete(PK id) {
		//PK keyObject = jsonMapper.convertValue(jsonKeyObject, keyType);

		//this.getGenericRepository().delete(keyObject);
            this.getGenericRepository().delete(id);
	}

	@Override
	public void update(Object jsonEntityObject) {
		T entityObject = jsonMapper.convertValue(jsonEntityObject, entityType);

		this.getGenericRepository().update(entityObject);
	}

	@Override
	public List<T> findAll() {
		return this.getGenericRepository().findAll();
	}
	@Override
	public T findOne(PK id){
		return this.getGenericRepository().findById(id);
	}
	
	protected Class<PK> getKeyType() {
		return keyType;
	}

	protected void setKeyType(Class<PK> keyType) {
		this.keyType = keyType;
	}

	protected Class<T> getEntityType() {
		return entityType;
	}

	protected void setEntityType(Class<T> entityType) {
		this.entityType = entityType;
	}

}
