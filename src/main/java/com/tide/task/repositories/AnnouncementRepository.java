package com.tide.task.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tide.task.entities.Announcement;

public interface AnnouncementRepository extends CrudRepository<Announcement, Long>{
	
	

}
