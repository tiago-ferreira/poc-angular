package br.com.poc.angular.utils.services.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.poc.angular.utils.beans.People;
import br.com.poc.angular.utils.services.ServiceConstants;
import br.com.poc.angular.utils.services.ServiceName;

@Path(value = ServiceName.PEOPLE_SERVICE)
@Produces(ServiceConstants.MEDIA_TYPE)
@Consumes(ServiceConstants.MEDIA_TYPE)
public interface IPeopleServiceDistribution extends IGenericServiceDistribution<People, Long>{

}
