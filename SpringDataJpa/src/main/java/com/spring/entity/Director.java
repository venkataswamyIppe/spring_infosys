package com.spring.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "director")
public class Director {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer director_Id;
	@Column
	private String fname;
	@Column
	private String lname;
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="director_movie", joinColumns={@JoinColumn(name="director_Id")}, 
                inverseJoinColumns={@JoinColumn(name="movie_Id")})
	private Set<Movie> movie;

	public Director(){
		
	}
	
	public Director(Integer director_Id, String fname, String lname, Set<Movie> movie) {
		super();
		this.director_Id = director_Id;
		this.fname = fname;
		this.lname = lname;
		this.movie = movie;
	}

	public Integer getDirector_Id() {
		return director_Id;
	}

	public void setDirector_Id(Integer director_Id) {
		this.director_Id = director_Id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	@ManyToMany(mappedBy = "director")
	public Set<Movie> getMovie() {
		return movie;
	}

	public void setMovie(Set<Movie> movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Director [director_Id=" + director_Id + ", fname=" + fname + ", lname=" + lname + ", movie=" + movie
				+ "]";
	}
}
