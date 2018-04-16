package com.tide.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tide.task.LikeDislikeEnum;
import com.tide.task.requests.LikeDislikeOutput;
import com.tide.task.services.LikeDislikeService;

@RestController
public class LikeDislikeController {
	
	@Autowired
	private LikeDislikeService likeDislikeService;
	
	@RequestMapping("/announcements/{announcementId}/like")
	public Integer getLikes(@PathVariable Long announcementId) {
		return likeDislikeService.getLikesForAnnouncement(announcementId);
	}
	
	@RequestMapping("/announcements/{announcementId}/dislike")
	public Integer getDislikes(@PathVariable Long announcementId) {
		return likeDislikeService.getDislikesForAnnouncement(announcementId);
	}
	
	@RequestMapping("/announcements/{announcementId}/likedislike")
	public LikeDislikeOutput getLikesDislikes(@PathVariable Long announcementId) {
		int likes = likeDislikeService.getLikesForAnnouncement(announcementId);
		int dislikes = likeDislikeService.getDislikesForAnnouncement(announcementId);
		LikeDislikeOutput result = new LikeDislikeOutput(likes, dislikes);
		return result;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/announcements/{announcementId}/like")
	public void setLike(@PathVariable Long announcementId) {
		likeDislikeService.addLikeDislike(announcementId, LikeDislikeEnum.LIKE.name());
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/announcements/{announcementId}/dislike")
	public void setDislike(@PathVariable Long announcementId) {
		likeDislikeService.addLikeDislike(announcementId, LikeDislikeEnum.DISLIKE.name());
	}

}
