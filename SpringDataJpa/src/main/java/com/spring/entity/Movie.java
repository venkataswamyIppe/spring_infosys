package com.spring.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer movie_Id;
	@Column
	private String movie_title;
	@Column
	private Date releaseDate;
	
	@ManyToMany(mappedBy="movie")
	private Set<Director> director;
	
	public Movie(){
		
	}

	public Movie(Integer movie_Id, String movie_title, Date releaseDate, Set<Director> director) {
		super();
		this.movie_Id = movie_Id;
		this.movie_title = movie_title;
		this.releaseDate = releaseDate;
		this.director = director;
	}

	public Integer getMovie_Id() {
		return movie_Id;
	}

	public void setMovie_Id(Integer movie_Id) {
		this.movie_Id = movie_Id;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Set<Director> getDirector() {
		return director;
	}

	public void setDirector(Set<Director> director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Movie [movie_Id=" + movie_Id + ", movie_title=" + movie_title + ", releaseDate=" + releaseDate
				+ ", director=" + director + "]";
	}
}
