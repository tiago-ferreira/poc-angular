package br.com.poc.angular.test.database.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.poc.angular.test.database.AbstractDatabaseTest;
import br.com.poc.angular.utils.beans.People;
import br.com.poc.angular.utils.database.interfaces.IPeopleService;

public class PeopleServiceTest extends AbstractDatabaseTest{

    private final Logger logger = Logger.getLogger(getClass());
    
    @Inject
    private IPeopleService peopleService;
    
    @Test
    public void testFindAll(){
    	List<People> peoples = peopleService.findAll();
    	if(this.logger.isInfoEnabled()){
    		this.logger.debug(peoples);
    	}
    }
	
}
