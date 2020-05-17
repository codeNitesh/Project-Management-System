package com.nitesh.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nitesh.pma.entites.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
	@Override
	public List<Project> findAll();
}
