package br.com.poc.angular.test.database.repositories;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.poc.angular.database.entities.EntityPeople;
import br.com.poc.angular.database.repositories.IPeopleRepository;
import br.com.poc.angular.test.database.AbstractDatabaseTest;

import java.util.List;

public class PeopleRepositoryTest extends AbstractDatabaseTest{

	
	private final Logger logger = Logger.getLogger(this.getClass());

	@Inject
	private IPeopleRepository peopleRepository;
	
	@Test
	public void testFindAll(){
		List<EntityPeople> peoples = peopleRepository.findAll();
		if(this.logger.isInfoEnabled()){
			this.logger.debug(peoples);
		}
		
	}
}
