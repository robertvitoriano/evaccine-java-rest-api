package br.com.robertvitoriano.backendfullstackweek.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.robertvitoriano.backendfullstackweek.domain.PriorityGroups;
import br.com.robertvitoriano.backendfullstackweek.repository.PriorityGroupsRepository;

@RestController
@RequestMapping("/priority-groups")
public class PriorityGroupsController {
	
	@Autowired
	private PriorityGroupsRepository priorityGroupsRepository;
	@GetMapping
	public List<PriorityGroups> listAll(){
		
		return priorityGroupsRepository.findAll();
		
	}

}
