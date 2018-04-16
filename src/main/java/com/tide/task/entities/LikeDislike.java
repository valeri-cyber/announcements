package com.tide.task.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "LikeDislike.findCountByAnnouncementIdAndType", 
			query = "SELECT count(ld.id) FROM LikeDislike ld JOIN ld.announcement a WHERE a.id=?1 and ld.type = ?2")
public class LikeDislike {
	
	@Id
	@GeneratedValue
	private Long id;
	private String type;
	@ManyToOne
	private Announcement announcement;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Announcement getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}
	
	@Override
	public String toString() {
		return "LikeDislike [id=" + id + ", type=" + type + ", announcement=" + announcement + "]";
	}

}
