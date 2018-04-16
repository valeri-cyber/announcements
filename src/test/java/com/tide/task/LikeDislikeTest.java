package com.tide.task;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tide.task.controllers.AnnouncementsController;
import com.tide.task.controllers.LikeDislikeController;
import com.tide.task.entities.Announcement;
import com.tide.task.requests.AnnouncementsInput;
import com.tide.task.requests.LikeDislikeOutput;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AnnouncementsApp.class)
public class LikeDislikeTest {
	
	private static final Logger LOG = Logger.getLogger(LikeDislikeTest.class);
	
	@Autowired
	private AnnouncementsController announcementController;
	
	@Autowired
	private LikeDislikeController likeDislikeController;
	
	@Test
	public void postAndGetAnnouncements() {
		AnnouncementsInput announcement = new AnnouncementsInput();
		announcement.setTitle("test");
		announcement.setContent("test");
		announcementController.addAnnouncement(announcement);
		List<Announcement> announcementsList = announcementController.getAnnouncements();
		Announcement result = announcementsList.get(announcementsList.size()-1);
		LOG.info(result);
		assertTrue("test".equals(result.getTitle()) && "test".equals(result.getContent()));
	}
	
	@Test
	public void updateAndDeleteAnnouncements() {
		AnnouncementsInput announcement = new AnnouncementsInput();
		announcement.setTitle("test");
		announcement.setContent("test");
		announcementController.addAnnouncement(announcement);
		List<Announcement> announcementsList = announcementController.getAnnouncements();
		Long announcementId = announcementsList.get(announcementsList.size()-1).getId();
		announcement.setTitle("testtest");
		announcement.setContent("testtest");
		announcementController.updateAnnouncement(announcementId, announcement);
		Announcement result = announcementController.getAnnouncement(announcementId);
		LOG.info(result);
		assertTrue("testtest".equals(result.getTitle()) && "testtest".equals(result.getContent()));
		announcementController.deleteAnnouncement(announcementId);
		result = announcementController.getAnnouncement(announcementId);
		LOG.info(result);
		assertTrue(null == result);
	}
	
	@Test
	public void postAndGetLikesDislikes() {
		AnnouncementsInput announcement = new AnnouncementsInput();
		announcement.setTitle("test");
		announcement.setContent("test");
		announcementController.addAnnouncement(announcement);
		List<Announcement> announcementsList = announcementController.getAnnouncements();
		Long announcementId = announcementsList.get(announcementsList.size()-1).getId();
		likeDislikeController.setLike(announcementId);
		likeDislikeController.setDislike(announcementId);
		LikeDislikeOutput result = likeDislikeController.getLikesDislikes(announcementId);
		LOG.info(result);
		assertTrue(result.getLikes() == 1 && result.getDislikes() == 1);
	}

}
