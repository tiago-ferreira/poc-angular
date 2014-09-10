package br.com.poc.angular.service;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.poc.angular.service.utils.AbstractGenericService;
import br.com.poc.angular.utils.beans.People;
import br.com.poc.angular.utils.database.interfaces.IPeopleService;
import br.com.poc.angular.utils.database.interfaces.IServiceBase;
import br.com.poc.angular.utils.services.interfaces.IPeopleServiceDistribution;

@Named
public class PeopleServiceDistribution extends AbstractGenericService<People, Long> implements IPeopleServiceDistribution{

	@Inject
	private IPeopleService peopleService;
	
	@Override
	protected IServiceBase<People, Long> getGenericRepository() {
		return peopleService;
	}

}
