package com.fortech.stm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.NamedQueries;

public class TeamEntity {
//rating score
	
	@Entity
	@NamedQueries({
			@NamedQuery(name = "TeamEntity.findTeamsByName", query = "SELECT e FROM TeamEntity e WHERE e.teamName = :teamName"),
			@NamedQuery(name = "TeamEntity.findPTeamsBySportsCategory", query = "SELECT e FROM TeamEntity e WHERE e.sportsCategory = :sportsCategory"),
			@NamedQuery(name = "TeamEntity.findTeamsByRatingScore", query = "SELECT e FROM TeamEntity e WHERE e.ratingScore = :ratingScore"),
			@NamedQuery(name = "TeamEntity.deleteTeam", query = "DELETE FROM TeamEntity e WHERE e.teamName = :teamName"),
			@NamedQuery(name = "TeamEntity.retrieveAllTeams", query = "SELECT e FROM TeamEntity e"),		
			@NamedQuery(name = "TeamEntity.deleteAllTeams", query = "DELETE FROM TeamEntity e"),
	})
	@Table(name = "teams")
	public class PlayerEntity {

			private static final long serialVersionUID = -6134776758947464648L;

			@Id
			@GeneratedValue(strategy = GenerationType.TABLE)
			@Column(name = "id")
			private long id;
			
			
			@NotNull
			@Column(name = "teamname", unique = true, length = 50)
			private String teamName;
			
			@Column(name = "foundedinyear")
			private int foundedInYear;
								
			@NotNull
			@Column(name = "sportscategory") /// does the team play football, handball etc
			private String sportsCategory;
					
			@NotNull
			@Column(name = "numberofplayers")
			private int numberOfPlayers;
			
			
			@NotNull
			@Column(name = "income")
			private int income;
			
			
			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getTeamName() {
				return teamName;
			}

			public void setTeamName(String teamName) {
				this.teamName = teamName;
			}

			public int getFoundedInYear() {
				return foundedInYear;
			}

			public void setFoundedInYear(int foundedInYear) {
				this.foundedInYear = foundedInYear;
			}

			public String getSportsCategory() {
				return sportsCategory;
			}

			public void setSportsCategory(String sportsCategory) {
				this.sportsCategory = sportsCategory;
			}

			public int getNumberOfPlayers() {
				return numberOfPlayers;
			}

			public void setNumberOfPlayers(int numberOfPlayers) {
				this.numberOfPlayers = numberOfPlayers;
			}

			public int getIncome() {
				return income;
			}

			public void setIncome(int income) {
				this.income = income;
			}

			public String getAddress() {
				return address;
			}

			public void setAddress(String address) {
				this.address = address;
			}

			public int getRatingScore() {
				return ratingScore;
			}

			public void setRatingScore(int ratingScore) {
				this.ratingScore = ratingScore;
			}

			public String getEmailAddress() {
				return emailAddress;
			}

			public void setEmailAddress(String emailAddress) {
				this.emailAddress = emailAddress;
			}

			public String getPhoneNumber() {
				return phoneNumber;
			}

			public void setPhoneNumber(String phoneNumber) {
				this.phoneNumber = phoneNumber;
			}

			@Column(name = "address", nullable = true, length = 100)
			private String address;
			
			
			@NotNull
			@Column(name = "ratingscore")// what rating does the team have, on a scale of 5 to 10
			private int ratingScore;
			
			
			@NotNull
			@Column(name="emailaddress")		
			private String emailAddress;
			
			@NotNull
			@Column(name="phonenumber")		
			private String phoneNumber;
			
			}
}