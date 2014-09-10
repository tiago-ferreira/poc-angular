package br.com.poc.angular.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.poc.angular.database.entities.EntityPeople;

public interface IPeopleRepository extends JpaRepository<EntityPeople,Long>{

}
