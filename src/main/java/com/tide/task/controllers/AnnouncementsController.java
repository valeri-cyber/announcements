package com.tide.task.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tide.task.entities.Announcement;
import com.tide.task.requests.AnnouncementsInput;
import com.tide.task.services.AnnouncementsService;

@RestController
public class AnnouncementsController {
	
	private static final Logger LOG = Logger.getLogger(AnnouncementsController.class);
	
	@Autowired
	private AnnouncementsService announcementsService;
	
	@RequestMapping("/announcements")
	public List<Announcement> getAnnouncements() {
		return announcementsService.getAllAnnouncements();
	}
	
	@RequestMapping("/announcements/{announcementId}")
	public Announcement getAnnouncement(@PathVariable Long announcementId) {
		return announcementsService.getAnnouncement(announcementId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/announcements")
	public void addAnnouncement(@RequestBody AnnouncementsInput announcement) {
		LOG.info(announcement);
		announcementsService.addAnnouncement(announcement);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/announcements/{announcementId}")
	public void updateAnnouncement(@PathVariable Long announcementId, @RequestBody AnnouncementsInput announcement) {
		LOG.info(announcement);
		announcementsService.updateAnnouncement(announcementId, announcement);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/announcements/{announcementId}")
	public void deleteAnnouncement(@PathVariable Long announcementId) {
		announcementsService.deleteAnnouncement(announcementId);
	}

}
