package com.tide.task.requests;

public class LikeDislikeOutput {
	
	private int likes;
	private int dislikes;
	
	public LikeDislikeOutput(int likes, int dislikes) {
		super();
		this.likes = likes;
		this.dislikes = dislikes;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	
	@Override
	public String toString() {
		return "LikeDislikeOutput [likes=" + likes + ", dislikes=" + dislikes + "]";
	}

}
