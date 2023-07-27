package com.skcet.ereader.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="book")

public class Library {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(unique=true)
	private String title;
	private String authors;
	private String description;
	private String edition;
	private String format;
	private long num_pages;
	private double rating;
	private String genres;
	private String image_url;
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
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public long getNum_pages() {
		return num_pages;
	}
	public void setNum_pages(long num_pages) {
		this.num_pages = num_pages;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public Library(int id, String title, String authors, String description, String edition, String format,
			long num_pages, double rating, String genres, String image_url) {
		super();
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.description = description;
		this.edition = edition;
		this.format = format;
		this.num_pages = num_pages;
		this.rating = rating;
		this.genres = genres;
		this.image_url = image_url;
	}
	public Library() {
		
	}

}
