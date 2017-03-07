package com.fortech.stm.JUnit;

import com.fortech.stm.controller.SportsTeamPlayerController;
import com.fortech.stm.model.PlayerEntity;

import com.fortech.stm.services.impl.PlayerServiceImpl;
import com.google.gson.Gson;

import org.hamcrest.core.IsNull;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

public class SportsTeamPlayerControllerJunit {

	private static final PlayerEntity player1 = new PlayerEntity();
	private static final PlayerEntity player2 = new PlayerEntity(); 
	private static List<PlayerEntity> players = new ArrayList<>();
	
		
	
	private MockMvc mockMvc;

    @Mock
   //handles CRUD operations
    private PlayerServiceImpl playerServiceMock;

    @InjectMocks
    //contains the REST end-points for GET, POST HTTP request methods
    private SportsTeamPlayerController sportsTeamPlayerController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(sportsTeamPlayerController)
         //       .addFilters(new CORSFilter())
                .build();
        
        player1.setAddress("address");
    	player1.setAge(30);
    	player1.setChildrenDetails("");
    	player1.setEmailAddress("ceva@yahoo.com");
    	player1.setHasChildren(false);
    	player1.setIncome(10000);
    	player1.setMarried(false);
    	player1.setPhoneNumber("0747108762");
    	player1.setPlayerName("Michael Jordan");
    	player1.setRank("captain");
    	player1.setRatingScore(4);
    	player1.setSportsCategory("basketball");
    	player1.setSpouseName("");
    	player1.setTeamName("L.A. Lakers");
        
    	player2.setAddress(" another address");
    	player2.setAge(35);
    	player2.setChildrenDetails("Anthony - 5 years, Selena 3 years");
    	player2.setEmailAddress("email@yahoo.com");
    	player2.setHasChildren(true);
    	player2.setIncome(100000);
    	player2.setMarried(true);
    	player2.setPhoneNumber("0743308508");
    	player2.setPlayerName("Kobe Bryant");
    	player2.setRank("defence player");
    	player2.setRatingScore(5);
    	player2.setSportsCategory("basketball");
    	player2.setSpouseName("Lorena");
    	player2.setTeamName("Chicago Bulls");
    	
       	
    	players.add(player1);
    	players.add(player2);
    	
    }
	
	
    @Test
    public void testAddPlayer() throws Exception {

when(playerServiceMock.searchPlayer(player1)).thenReturn(player1);
doNothing().when(playerServiceMock).createPlayer(player1);
when(playerServiceMock.searchPlayer(player2)).thenReturn(player2);
doNothing().when(playerServiceMock).createPlayer(player2);


Gson gson = new Gson();
String authenticateUserRequest = gson.toJson(player2);
    	
mockMvc.perform(
        post("/addplayer")
                .contentType(MediaType.APPLICATION_JSON)
               .content(authenticateUserRequest))
       .andExpect(status().isCreated())
       .andExpect(status().isOk())
	   .andExpect(status().isConflict());

ArgumentCaptor<PlayerEntity> argument = ArgumentCaptor.forClass(PlayerEntity.class);
verify(playerServiceMock).createPlayer(argument.capture());
assertEquals("L.A. Lakers", argument.getValue().getTeamName());
assertEquals("Chicago Bulls", argument.getValue().getTeamName());
assertTrue(argument.getValue().getEmailAddress().contains("ceva"));
assertTrue(argument.getValue().getEmailAddress().contains("email"));

verify(playerServiceMock, times(1)).createPlayer(player1);
verify(playerServiceMock, times(1)).createPlayer(player2);

verifyNoMoreInteractions(playerServiceMock);
    	
    	
    }
    
    
    @Test
    public void testRetrieveAllPlayers() throws Exception {

    	when (playerServiceMock.findAllPlayers()).thenReturn(players);
    	
    	
        mockMvc.perform(get("/searchallplayers"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
       
        .andExpect(jsonPath("$[0].password").doesNotExist())
        .andExpect(jsonPath("$[0].sportsCategory").isString())
        .andExpect(jsonPath("$[0].sportsCategory").value("basketball"))
        .andExpect(jsonPath("$[0].address").value("address"))
        .andExpect(jsonPath("$[0].teamName").value("L.A. Lakers"))
        .andExpect(jsonPath("$[0].playerName").value("Michael Jordan"))

        .andExpect(jsonPath("$[1].hasChildren").isBoolean())
        .andExpect(jsonPath("$[1].hasChildren").value("true"))
        .andExpect(jsonPath("$[1].phoneNumber").value("0743308508"))
        .andExpect(jsonPath("$[1].rank").value("defence player"))
        .andExpect(jsonPath("$[1].playerName").value("Michael Jordan"));
     
        
        verify(playerServiceMock, times(1)).findAllPlayers();
        verifyNoMoreInteractions(playerServiceMock);
    }
    
    
    
    
    @Test
    public void testUpdatePlayer() throws Exception {
    	
    	player1.setPlayerName("Shaquille O'Neal");
    	player1.setTeamName("Boston Eagles");
    	
    	
    	Gson gson = new Gson();
    	String authenticateUserRequest = gson.toJson(player1);

        mockMvc.perform(post("/updateplayer").contentType(MediaType.APPLICATION_JSON)
        .content(authenticateUserRequest))
        .andExpect(status().isOk());
        
        ArgumentCaptor<PlayerEntity> argument = ArgumentCaptor.forClass(PlayerEntity.class);
        verify(playerServiceMock).updatePlayer(argument.capture());
        assertNotEquals("L.A. Lakers", argument.getValue().getTeamName());
        assertEquals("Boston Eagles", argument.getValue().getTeamName());
        assertEquals("Shaquille O'Neal", argument.getValue().getPlayerName());
        assertTrue(argument.getValue().getTeamName().contains("Eagles"));
        assertTrue(argument.getValue().getPlayerName().contains("O'Neal"));
        assertNotEquals("basketball", argument.getValue().getSportsCategory());
        assertEquals("football", argument.getValue().getSportsCategory());
       
        verify(playerServiceMock, times(1)).updatePlayer(player1);
        verify(playerServiceMock, times(1)).updatePlayer(player2);
        
        verifyNoMoreInteractions(playerServiceMock);
    }
    
    
    
    @Test
    public void testDeletePlayer() throws Exception {

    	
    	Gson gson = new Gson();
    	String authenticateUserRequest = gson.toJson(player2);
    	
    	
        mockMvc.perform(post("/deleteplayer").contentType(MediaType.APPLICATION_JSON)
        .content(authenticateUserRequest))
        .andExpect(status().isOk());
        
        
        ArgumentCaptor<PlayerEntity> argument = ArgumentCaptor.forClass(PlayerEntity.class);
        verify(playerServiceMock).deletePlayer(argument.capture());
        assertNotEquals("L.A. Lakers", argument.getValue().getTeamName());
        assertEquals("Boston Eagles", argument.getValue().getTeamName());
        assertEquals("Shaquille O'Neal", argument.getValue().getPlayerName());
        assertTrue(argument.getValue().getTeamName().contains("Eagles"));
        assertTrue(argument.getValue().getPlayerName().contains("O'Neal"));
        assertNotEquals("basketball", argument.getValue().getSportsCategory());
        assertEquals("football", argument.getValue().getSportsCategory());
       
        verify(playerServiceMock, times(1)).updatePlayer(player1);
        verify(playerServiceMock, times(1)).updatePlayer(player2);

        verifyNoMoreInteractions(playerServiceMock);
    }
   
     
    @Test
    public void testSearchPlayer() throws Exception {

    	
    	Gson gson = new Gson();
    	String authenticateUserRequest = gson.toJson(players.get(0));
    	when (playerServiceMock.searchPlayer(player1)).thenReturn(player1);
    	
        mockMvc.perform(post("/searchplayer").contentType(MediaType.APPLICATION_JSON)
        .content(authenticateUserRequest))
        .andExpect(status().isOk())
        
        
        .andExpect(jsonPath("$.password").doesNotExist())
        .andExpect(jsonPath("$.password").value(IsNull.nullValue()))
        .andExpect(jsonPath("$.sportsCategory").isString())
        .andExpect(jsonPath("$.sportsCategory").value("basketball"))
        .andExpect(jsonPath("$.address").value("address"))
        .andExpect(jsonPath("$.teamName").value("L.A. Lakers"))
        .andExpect(jsonPath("$.playerName").value("Michael Jordan"))
        .andExpect(jsonPath("$.hasChildren").isBoolean())
        .andExpect(jsonPath("$.hasChildren").value("false"))
        .andExpect(jsonPath("$.phoneNumber").value("0747108762"))
        .andExpect(jsonPath("$.rank").value("captain"))
        .andExpect(jsonPath("$.playerName").value("Michael Jordan"));
         
        
        verify(playerServiceMock, times(1)).searchPlayer(player1);
        verify(playerServiceMock, times(1)).searchPlayer(player2);

        verifyNoMoreInteractions(playerServiceMock);
    }
    	
}
