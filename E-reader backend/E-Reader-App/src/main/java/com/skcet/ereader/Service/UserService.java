package com.skcet.ereader.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcet.ereader.Model.Library;
import com.skcet.ereader.Model.User;
import com.skcet.ereader.Repository.LibraryRepo;
import com.skcet.ereader.Repository.UserRepo;

@Service

public class UserService {
	
	@Autowired
	UserRepo ur;
	@Autowired
	LibraryRepo lr;
	public User saveDetails(User u) {
		return ur.save(u);
	}
	public List<User> getDetails(){
		return ur.findAll();
	}
	
	public User updateDetails(int id,User u1)
	{
		User xuser=ur.findById(id).orElse(null);
		if(xuser!=null) {
			xuser.setUsername(u1.getUsername());
			xuser.setEmail(u1.getEmail());
			xuser.setPassword(u1.getPassword());
			return ur.saveAndFlush(xuser);
		}
		else {
			return null;
		}
				
		
	}
	public String deleteDetails(int id)
	{
		User xuser=ur.findById(id).orElse(null);
		if(xuser!=null) {
			ur.deleteById(id);
			return "User deleted" +id;
		}
		else {
			return "Invalid User Id";
		}
	}
	
	//login
	public String Login(String username,String password) {
		User xuser=ur.findByUsername(username);
		if(xuser==null) {
			return "Invalid username";
		}
		else {
			if(xuser.getPassword().equals(password)) {
				return "success";
			}
			else {
				return "Invalid password";
			}
		}
	}
	
	//Signup
	public String Signup(User u2) {
		String username=u2.getUsername();
		User xuser=ur.findByUsername(username);
		if(xuser==null) {
			ur.save(u2);
			return "Username added";
		}
		else {
			return "Existing username";
		}
		
	}
	
	
	
	
	//LibraryLogic
	public Library addData(Library data) {
        // Check if the book already exists based on title and author
        Library existingBook = lr.findByTitleAndAuthors(data.getTitle(), data.getAuthors());

        if (existingBook == null) {
            // The book does not exist, proceed to save it
            return lr.save(data);
        } else {
            // The book already exists, handle it appropriately (e.g., throw an exception)
            throw new RuntimeException("Book already exists!");
        }
    }
	
	public List<Library> getData(){
		return lr.findAll();
	}
	
	public Library updateData(Library l1) {

		// Your implementation to update details here

		// You can check for the existence of the record, throw DetailNotFoundException, and update the details in the repository

		return lr.saveAndFlush(l1);

		}
	public static class DetailNotFoundException extends RuntimeException{
		public DetailNotFoundException(String message) {
			super(message);
		}
	}
	//Delete
		public String deleteData(int id) {
			lr.deleteById(id);
			return "Deleted Successfully";
		}
		
		//Find by ID
		public Optional<Library> findbyID(int id) {
			return lr.findById(id);
		}
	
	

}
