package com.fortech.stm.controller;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fortech.stm.authentification.AuthenticateUserRequest;
import com.fortech.stm.persistence.EncryptionUtils;
import com.fortech.stm.persistence.UserCredentials;
import com.fortech.stm.persistence.UserCredentialsDAOImpl;
import com.fortech.stm.services.DealService;
import com.fortech.stm.services.PlayerService;
import com.fortech.stm.services.TeamService;



@RestController
public class SportsTeamMGMController {

	 @Autowired
	 PlayerService playerService;
	 @Autowired 
	 TeamService teamService;
	 @Autowired
	 DealService dealService;
	 @Autowired
	 AuthenticateUserRequest authenticateUserRequest;
	 @Autowired
	 UserCredentialsDAOImpl uc;
	     
	    //-------------------Retrieve All Users--------------------------------------------------------
	     
//	    @RequestMapping(value="/user/", method= RequestMethod.GET)
//	    public ResponseEntity<List<User>> listAllUsers() {
//	    	List<User> users = userService.findAllUsers();
//	    	if (users.isEmpty()) {
//	    		return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
//	    	}
//	    	return new ResponseEntity<List<User>>(users,HttpStatus.OK);
//	    }
//	   
//	    

	    @RequestMapping(value="/", method= RequestMethod.GET)
	    public ModelAndView firstPage() {
	 return new ModelAndView("redirect:"+"/login/login.jsp");

	    }
	    
//	    
//	    @RequestMapping(value="/",method = RequestMethod.GET)
//	    public String get() {
//	        return "/login/login.jsp";
//	    }
//	    
	    
	    
	    @RequestMapping(value="/ceva", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public void login(@RequestBody AuthenticateUserRequest authenticateUserRequest) throws SQLException {
	    	UserCredentials user = new UserCredentials();
	    	user.setUsername(EncryptionUtils.encryptString(authenticateUserRequest.getUsername()));
	    	user.setPassword(EncryptionUtils.encryptString(authenticateUserRequest.getPassword()));
	   // 	if (uc.findUser(user.getUsername()) != null) {
	    		//uc.save(user);
	    	 return;

	    }
	    
	    
	    @RequestMapping(value="/ggg", method= RequestMethod.GET)
	    public void register() throws SQLException {
	    	return;
	    	}

	    
	    
	    @RequestMapping(value="/register", method= RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE)
	    public void performRegistration(@RequestBody AuthenticateUserRequest authenticateUserRequest) throws SQLException {
	    	UserCredentials user = new UserCredentials();
	    	user.setUsername(EncryptionUtils.encryptString(authenticateUserRequest.getUsername()));
	    	user.setPassword(EncryptionUtils.encryptString(authenticateUserRequest.getPassword()));
//	    	if (uc.findUser(user.getUsername()) == null) {
//	    		uc.save(user);	    		
//	    	    }
	    }
	    
	    
	    
	    @RequestMapping(value="/addplayer", method= RequestMethod.POST, consumes =MediaType.APPLICATION_JSON_VALUE)
	    public void addPlayer(@RequestBody PlayerService playerService) throws SQLException {
	    	UserCredentials user = new UserCredentials();
	    	user.setUsername(EncryptionUtils.encryptString(authenticateUserRequest.getUsername()));
	    	user.setPassword(EncryptionUtils.encryptString(authenticateUserRequest.getPassword()));
//	    	if (uc.findUser(user.getUsername()) == null) {
//	    		uc.save(user);	    		
//	    	    }
	    }
	    
	    
//	 	    @RequestMapping(value="/login/login.jsp", method= RequestMethod.GET)
//	    public ResponseEntity login(@RequestBody String username, @RequestBody String password) {
//	 	    	if (!"admin".equals(username) && (!"admin".equals(password))) {
//	 	    		
//	 	    	}
//	 return null;
//
//	    }
	 	    
//	 	    
//	 	   @RequestMapping(value="/login", method=RequestMethod.POST)
//	 	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthenticateUserRequest authenticateUserRequest) {
//
//	 	      // check the submitted username and password
//	 	      if(authenticateUserRequest.getUsername().equals("nayan") && authenticateUserRequest.getPassword().equals("pass")){
//	 	          return new ResponseEntity<>(null, HttpStatus.OK);
//	 	      } else {
//	 	          return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//	 	      }
//	 	  }
////	 
	 	   
	 	   
//	 	  @RequestMapping(value = "/login", method = RequestMethod.POST)
//	 		public String doLogin(HttpServletRequest request, HttpServletResponse response, LoginDTO loginDto) {
//	 			RestTemplate restTemplate = new RestTemplate();
//
//	 			ResponseEntity<SecurityDTO> restResponse = restTemplate.postForEntity("http://localhost:8090/user/login",
//	 					loginDto, SecurityDTO.class);
//
//	 			if (restResponse.getStatusCode().equals(HttpStatus.OK)) {
//	 				LOGGER.info("@@@ Logged in as: " + restResponse.getBody().getUserAccountName());
//
//	 				response.addCookie(new Cookie("token", restResponse.getBody().getToken()));
//	 				response.addCookie(new Cookie("username", restResponse.getBody().getUserAccountName()));
//	 				response.addCookie(new Cookie("isAdmin", String.valueOf(restResponse.getBody().isAdmin())));
//
//	 				LOGGER.info("@@@ Go to home page");
//
//	 				return "secured/home";
//	 			} else {
//	 				throw new Exception();
//	 			}
//	 		}
//	    //-------------------Retrieve Single User--------------------------------------------------------
//	     
//	    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
//	        System.out.println("Fetching User with id " + id);
//	        User user = userService.findById(id);
//	        if (user == null) {
//	            System.out.println("User with id " + id + " not found");
//	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//	        }
//	        return new ResponseEntity<User>(user, HttpStatus.OK);
//	    }
//	 
//	     
//	     
//	    //-------------------Create a User--------------------------------------------------------
//	     
//	    @RequestMapping(value = "/user/", method = RequestMethod.POST)
//	    public ResponseEntity<Void> createUser(@RequestBody User user,    UriComponentsBuilder ucBuilder) {
//	        System.out.println("Creating User " + user.getName());
//	 
//	        if (userService.isUserExist(user)) {
//	            System.out.println("A User with name " + user.getName() + " already exist");
//	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//	        }
//	 
//	        userService.saveUser(user);
//	 
//	        HttpHeaders headers = new HttpHeaders();
//	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
//	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//	    }
//	 
//	     
//	    //------------------- Update a User --------------------------------------------------------
//	     
//	    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
//	    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
//	        System.out.println("Updating User " + id);
//	         
//	        User currentUser = userService.findById(id);
//	         
//	        if (currentUser==null) {
//	            System.out.println("User with id " + id + " not found");
//	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//	        }
//	 
//	        currentUser.setName(user.getName());
//	        currentUser.setAge(user.getAge());
//	        currentUser.setSalary(user.getSalary());
//	         
//	        userService.updateUser(currentUser);
//	        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
//	    }
//	 
//	    //------------------- Delete a User --------------------------------------------------------
//	     
//	    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
//	    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
//	        System.out.println("Fetching & Deleting User with id " + id);
//	 
//	        User user = userService.findById(id);
//	        if (user == null) {
//	            System.out.println("Unable to delete. User with id " + id + " not found");
//	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//	        }
//	 
//	        userService.deleteUserById(id);
//	        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//	    }
//	 
//	     
//	    //------------------- Delete All Users --------------------------------------------------------
//	     
//	    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
//	    public ResponseEntity<User> deleteAllUsers() {
//	        System.out.println("Deleting All Users");
//	 
//	        userService.deleteAllUsers();
//	        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//	    }
//	 
//}
	    
	    
	    
	    
	    
	    
	    

	    }
	    
