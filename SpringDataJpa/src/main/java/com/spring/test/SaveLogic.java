package com.spring.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.spring.entity.Director;
import com.spring.entity.Movie;
import com.spring.repository.DirectorRepository;

@Component
public class SaveLogic {
	private static SaveLogic saveLogic;
	/*@Autowired
    private MovieRepository movieRepository;
	*/
	@Autowired
    private DirectorRepository directorRepository;
	
	public static void main(String[] args) {
		// Reading the Configuration file
		ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
		// Get the SaveLogic bean
        saveLogic = (SaveLogic) context.getBean("saveLogic");
        saveLogic.saveDirector();

        ((AbstractApplicationContext) context).close();
	}
	
	public void saveDirector()
    {
		
		// Create a new Director object director1
		Director director1 = new Director();
		director1.setFname("ippe");
		director1.setLname("venkat");

		// Create a new Movie object movie1
		Movie movie1 = new Movie();
		movie1.setMovie_title("Dhoni");
		movie1.setReleaseDate(new Date());
		
		//Adding movie1 to movieSet
        Set<Movie> movieSet = new HashSet<Movie>();
        movieSet.add(movie1);
        
        director1.setMovie(movieSet);
        
        //Add director object to a list
        List<Director> directorList= new ArrayList<Director>();
        directorList.add(director1);
        
        //Saving the directorList
        directorRepository.save(directorList);
        System.out.println("Director and Director Movie saved successfully!!");
		

	}

}
