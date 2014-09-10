package br.com.poc.angular.database.services;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.poc.angular.database.entities.EntityPeople;
import br.com.poc.angular.database.repositories.IPeopleRepository;
import br.com.poc.angular.database.utils.GenericService;
import br.com.poc.angular.utils.beans.People;
import br.com.poc.angular.utils.database.interfaces.IPeopleService;

@Named
public class PeopleService extends GenericService<People, EntityPeople, Long> implements IPeopleService {

	@Inject
	private IPeopleRepository peopleRepository;
	
	
	@Override
	protected JpaRepository<EntityPeople, Long> getConcreteDao() {
		return peopleRepository;
	}

}
