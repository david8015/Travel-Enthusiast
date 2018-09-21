package com.TravelEnthusiast2.Bean;

public class Picture {
		  private int id;
		  private String title;
		  private String image;
		  private String picture_of;
		  private String photo_date;
		  private boolean landmark;
		  private String description;
		  
		public Picture() {
			super();
		}
		public Picture(int id, String title, String image, String picture_of, String photo_date, boolean landmark, String description) {
			super();
			this.id = id;
			this.title = title;
			this.image = image;
			this.picture_of = picture_of;
			this.photo_date = photo_date;
			this.landmark = landmark;
			this.description = description;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getPicture_of() {
			return picture_of;
		}
		public void setPicture_of(String picture_of) {
			this.picture_of = picture_of;
		}
		public String getPhoto_date() {
			return photo_date;
		}
		public void setPhoto_date(String photo_date) {
			this.photo_date = photo_date;
		}
		public boolean isLandmark() {
			return landmark;
		}
		public void setLandmark(boolean landmark) {
			this.landmark = landmark;
		} 
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	}
