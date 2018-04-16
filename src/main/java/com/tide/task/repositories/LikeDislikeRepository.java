package com.tide.task.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tide.task.entities.LikeDislike;

public interface LikeDislikeRepository extends CrudRepository<LikeDislike, Long> {

	public Integer findCountByAnnouncementIdAndType(Long announcementId, String type);

}
