package com.tide.task.requests;

public class AnnouncementsInput {
	
	private String title;
	private String content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "AnnouncementsInput [title=" + title + ", content=" + content + "]";
	}

}
