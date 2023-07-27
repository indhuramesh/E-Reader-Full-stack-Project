package com.skcet.ereader.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skcet.ereader.Model.Library;
import com.skcet.ereader.Model.User;
import com.skcet.ereader.Service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {

	
	@Autowired(required=true)
	UserService us;
	
	@PostMapping("/Login")
	private String Login(@RequestBody Map<String, String> xLogin) {
	    String username = xLogin.get("username");
	    String password = xLogin.get("password");
	    String result = us.Login(username, password);
	    return result;
	}

	
    @PostMapping("/Signup")
    public String Signup(@RequestBody User user) {
        return us.Signup(user);
    }
	@PostMapping("/add")
	public User addInfo(@RequestBody User u) {
		return us.saveDetails(u);
	}
	
	@GetMapping("/get")
	public List<User> getInfo(){
		return us.getDetails();
	}
	@PutMapping("/updateDetails/{id}")
	public User updateInfo(@PathVariable("id") int id,@RequestBody User u1)
	{
		return us.updateDetails(id,u1);
	}
	@DeleteMapping("/delete/{id}")
	public  String deleteInfo(@PathVariable("id") int id)
	{
		us.deleteDetails(id);
		return "The "+id+" id have been deleted";
	}
	
	
	//library
	
	@GetMapping("/getBook")
	private List<Library> getbook(){
		return us.getData();
	}
	
	
	@GetMapping("/getBook/{id}")
	private Optional<Library> bookbyid(@PathVariable int id) {
		return us.findbyID(id);
	}
	
	
	
	@PostMapping("/addBook")
    public ResponseEntity<String> addBook(@RequestBody Library l) {
        try {
           Library addedBook = us.addData(l);
            return ResponseEntity.status(HttpStatus.CREATED).body("Book added successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Book already exists");
        }
    }
	
	
	@PutMapping("/updateBook")

	public ResponseEntity<String> updateInfo(@RequestBody Library l1) {

	try {

	us.updateData(l1);

	return ResponseEntity.ok("Details updated successfully.");

	} catch (UserService.DetailNotFoundException ex) {

	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Details not found.");

	} catch (Exception ex) {

	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating the details.");
	}
	}
	
	@DeleteMapping("/deleteBook/{id}")
	private String deletebook(@PathVariable int id) {
		return us.deleteData(id);
	}
}
