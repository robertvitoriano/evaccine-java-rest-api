package br.com.robertvitoriano.backendfullstackweek.repository;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.robertvitoriano.backendfullstackweek.domain.PriorityGroups;

public interface PriorityGroupsRepository extends JpaRepository<PriorityGroups, Long> {

}
