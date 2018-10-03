package com.TravelEnthusiast2.Bean;

public class Picture {
		  private int id;
		  private String pictureTitle;
		  private String image;
		  private String picture_of;
		  private String photo_date;
		  private boolean landmark;
		  private String pictureDescription;
		  
		public Picture() {
			super();
		}
		public Picture(int id, String pictureTitle, String image, String picture_of, String photo_date, boolean landmark, String pictureDescription) {
			super();
			this.id = id;
			this.pictureTitle = pictureTitle;
			this.image = image;
			this.picture_of = picture_of;
			this.photo_date = photo_date;
			this.landmark = landmark;
			this.pictureDescription = pictureDescription;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getPictureTitle() {
			return pictureTitle;
		}
		public void setPictureTitle(String pictureTitle) {
			this.pictureTitle = pictureTitle;
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
		public String getPictureDescription() {
			return pictureDescription;
		}
		public void setPictureDescription(String pictureDescription) {
			this.pictureDescription = pictureDescription;
		}
	}
