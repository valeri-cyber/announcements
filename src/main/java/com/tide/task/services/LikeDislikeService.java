package com.tide.task.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tide.task.LikeDislikeEnum;
import com.tide.task.entities.Announcement;
import com.tide.task.entities.LikeDislike;
import com.tide.task.repositories.AnnouncementRepository;
import com.tide.task.repositories.LikeDislikeRepository;

@Service
public class LikeDislikeService {
	
	@Autowired
	private LikeDislikeRepository likeDislikeRepository;
	@Autowired
	private AnnouncementRepository announcementRepository;
	
	public List<LikeDislike> getAllLikesDislikes(){
		List<LikeDislike> likesDislikes = new ArrayList<>();
		likeDislikeRepository.findAll().forEach(likesDislikes::add);
		return likesDislikes;
	}
	
	public LikeDislike getLikeDislike(Long id){
		return likeDislikeRepository.findOne(id);
	}
	
	public Integer getLikesForAnnouncement(Long announcementId){
		return likeDislikeRepository.findCountByAnnouncementIdAndType(announcementId, LikeDislikeEnum.LIKE.name());
	}
	
	public Integer getDislikesForAnnouncement(Long announcementId){
		return likeDislikeRepository.findCountByAnnouncementIdAndType(announcementId, LikeDislikeEnum.DISLIKE.name());
	}
	
	public void addLikeDislike(Long announcementId, String type) {
		Announcement announcement = announcementRepository.findOne(announcementId);
		LikeDislike likeDislike = new LikeDislike();
		likeDislike.setType(type);
		likeDislike.setAnnouncement(announcement);
		likeDislikeRepository.save(likeDislike);
	}

}
