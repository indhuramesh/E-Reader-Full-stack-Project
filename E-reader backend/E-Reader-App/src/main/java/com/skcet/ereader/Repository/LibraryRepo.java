package com.skcet.ereader.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skcet.ereader.Model.Library;

public interface LibraryRepo extends JpaRepository<Library,Integer> {
	
	Library findByTitleAndAuthors(String title, String authors);
   
}
