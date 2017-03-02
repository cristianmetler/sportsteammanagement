package com.fortech.stm.JUnit;



import com.fortech.stm.controller.SportsTeamAuthentificationController;

import com.fortech.stm.persistence.UserCredentials;
import com.fortech.stm.persistence.UserCredentialsDAOImpl;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AuthentificationControllerJunit {
	
	
	private MockMvc mockMvc;

    @Mock
   //handles CRUD operations
    private UserCredentialsDAOImpl userCredentialsService;

    @InjectMocks
    //contains the REST end-points for GET, POST HTTP request methods
    private SportsTeamAuthentificationController sportsTeamAuthentificationController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(sportsTeamAuthentificationController)
         //       .addFilters(new CORSFilter())
                .build();
    }
	
	
    @Test
    public void testfirstPageMethod() throws Exception {

        mockMvc.perform(get("/").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(status().isPermanentRedirect())
//                .andExpect(status().isTemporaryRedirect())
                .andExpect(status().is(302))
             //   .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               	.andExpect(header().doesNotExist("/login/login.jsp"));
        verifyNoMoreInteractions(userCredentialsService);
    }
    
    
    @Test
    public void login() throws Exception {
    	
    	//user1 does not exist in DB
    	UserCredentials user1 = new UserCredentials();
    	user1.setUsername("tt666t");
    	user1.setPassword("12345");
    	
    	//user2 exists in DB
    	UserCredentials user2 = new UserCredentials();
    	user2.setUsername("ristianmetlerc");
    	user2.setPassword("012983");
    	

        when(userCredentialsService.findUser(user1.getUsername())).thenReturn(user1); // returns null
        when(userCredentialsService.findUser(user2.getUsername())).thenReturn(user2); // returns user2
        
        //user2 already exists, so do nothing when user2 mock is tried to be saved in DB
         
        doNothing().when(userCredentialsService).save(user1);  
    	
         
        Gson gson = new Gson();
        String authenticateUserRequest = gson.toJson(user2);

          
          
        mockMvc.perform(post("/ceva")
        		.contentType(MediaType.APPLICATION_JSON)
        		.secure(false)
        		.content(authenticateUserRequest) //convert user2 object to JSON object        
        		)     		
                .andExpect(status().isOk())
                .andExpect(status().is(200));

        //verify(userCredentialsService, times(1)).findUser(user1.getUsername());
        verify(userCredentialsService, times(1)).findUser(user2.getUsername());
        verify(userCredentialsService, times(1)).save(user2);
        verifyNoMoreInteractions(userCredentialsService);
    } 
 
    
    @Test
    public void performRegistrationyo() throws Exception {
    	
    	//user1 does not exist in DB
    	UserCredentials user1 = new UserCredentials();
    	user1.setUsername("tt666t");
    	user1.setPassword("12345");
    	

    	UserCredentials user233 = new UserCredentials();
    	user233.setUsername("tt666t");
    	user233.setPassword("12345");
    	

       // when(userCredentialsService.findUser(user1.getUsername())).thenReturn(user1); // returns null

        
         
       // doNothing().when(userCredentialsService).save(user1);  
    	
         
        Gson gson = new Gson();
        String authenticateUserRequest = gson.toJson(user233);

        ArgumentCaptor<UserCredentials> argument = ArgumentCaptor.forClass(UserCredentials.class);
        
        
        
        mockMvc.perform(post("/register")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(authenticateUserRequest) //convert user2 object to JSON object        
        		)     		
                .andExpect(status().isOk());

        verify(userCredentialsService).save(argument.capture());
        UserCredentials e = argument.getValue();
        assertEquals("tt666t", argument.getValue().getUsername());
        //verify(userCredentialsService, times(1)).findUser(user1.getUsername());
        verify(userCredentialsService, times(1)).save(any(UserCredentials.class));

        
        assertTrue(argument.getValue().getUsername().contains("tt666t"));
        assertEquals("tt666t", argument.getValue().getUsername());
        verify(userCredentialsService).save(eq(user233));
        verifyNoMoreInteractions(userCredentialsService);
    } 
    
    
    
}
