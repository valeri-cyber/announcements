package com.tide.task.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tide.task.entities.Announcement;
import com.tide.task.repositories.AnnouncementRepository;
import com.tide.task.requests.AnnouncementsInput;

@Service
public class AnnouncementsService {
	
	@Autowired
	private AnnouncementRepository announcementRepository;
	
	public List<Announcement> getAllAnnouncements(){
		List<Announcement> announcements = new ArrayList<>();
		announcementRepository.findAll().forEach(announcements::add);
		return announcements;
	}
	
	public Announcement getAnnouncement(Long id){
		return announcementRepository.findOne(id);
	}
	
	public void addAnnouncement(AnnouncementsInput announcementInput) {
		Announcement announcement = new Announcement();
		announcement.setTitle(announcementInput.getTitle());
		announcement.setContent(announcementInput.getContent());
		announcementRepository.save(announcement);
	}
	
	public void updateAnnouncement(Long id, AnnouncementsInput announcementInput) {
		Announcement announcement = announcementRepository.findOne(id);
		if (announcement == null) return;
		announcement.setTitle(announcementInput.getTitle());
		announcement.setContent(announcementInput.getContent());
		announcementRepository.save(announcement);
	}
	
	public void deleteAnnouncement(Long id){
		announcementRepository.delete(id);
	}

}
