package br.com.poc.angular.utils.services.interfaces;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import br.com.poc.angular.utils.beans.BaseBean;

public interface IGenericServiceDistribution<T extends BaseBean, PK extends Serializable> {

	@GET
	public List<T> findAll();

	@POST
	public void insert(Object jsonEntityObject);

	@DELETE
        @Path("/{pk}")
	public void delete(@PathParam("pk") PK id);

	@PUT
	public void update(Object jsonEntityObject);
	
	@GET
	@Path("/{pk}")
	public T findOne(@PathParam("pk") PK id);

	
}
