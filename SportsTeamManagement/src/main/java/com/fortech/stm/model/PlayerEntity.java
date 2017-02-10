package com.fortech.stm.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@NamedQueries({
		@NamedQuery(name = "PlayerEntity.findPlayersByName", query = "SELECT e FROM PlayerEntity e WHERE e.playerName = :playerName"),
		
		@NamedQuery(name = "PlayerEntity.PlayerEntity.findPlayersByNameorTeamorCategory", query = "SELECT e FROM PlayerEntity e WHERE e.playerName = :playerName OR e.teamName= :teamName OR e.sportsCategory= :sportsCategory")
})
//		@NamedQuery(name = "PlayerEntity.findPlayersByIncome", query = "SELECT e FROM PlayerEntity e WHERE e.income = :income"),
//		@NamedQuery(name = "PlayerEntity.findPlayersByTeamName", query = "SELECT e FROM PlayerEntity e WHERE e.teamName = :teamName"),
//		@NamedQuery(name = "PlayerEntity.findPlayersByRank", query = "SELECT e FROM PlayerEntity e WHERE e.rank = :rank"),		
//		@NamedQuery(name = "PlayerEntity.retrieveAllPlayers", query = "SELECT e FROM UserEntity e"),
//		@NamedQuery(name = "PlayerEntity.deleteAllPlayers", query = "DELETE FROM UserEntity e"),
//		@NamedQuery(name = "PlayerEntity.deletePlayer", query = "DELETE from PlayerEntity e where e.playerName=:playerName"),
//		@NamedQuery(name = "PlayerEntity.isPlayerExistent", query = "SELECT e from PlayerEntity e where e.playerName=:playerName")	
//})
@Table(name = "players")
public class PlayerEntity {

		private static final long serialVersionUID = -6134776758947464648L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private long id;
		
		
		@NotNull
		@Column(name = "playername", unique = true, length = 50)
		private String playerName;
		
		@Column(name = "age")
		private int age;
		
		@NotNull
		@Column(name = "rank") //the position occupied within the team: captain, goalkeeper, pivot etc
		private String rank;
		
		@NotNull
		@Column(name = "teamname")// in what team does he play
		private String teamName;
		
		
		@NotNull
		@Column(name = "sportscategory") /// does his team play football, handball etc
		private String sportsCategory;
		
		
		@NotNull
		@Column(name = "income")
		private long income;
		
		@NotNull
		@Column(name = "isMarried")
		private boolean isMarried;
		
		
		@Column(name = "spousename", nullable = true)
		private String spouseName;
		
		@NotNull
		@Column(name = "haschildren")
		private boolean hasChildren;
		
		
		@Column(name = "childrendetails", nullable = true, length = 200)
		private String childrenDetails;	
		
		
		@Column(name = "address", nullable = true, length = 100)
		private String address;
		
		
		@NotNull
		@Column(name = "ratingscore")// what rating does he have, on a scale of 5 to 10
		private int ratingScore;
		
		
		@NotNull
		@Column(name="emailaddress")		
		private String emailAddress;
		
		@NotNull
		@Column(name="phonenumber")		
		private String phoneNumber;
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getPlayerName() {
			return playerName;
		}

		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getRank() {
			return rank;
		}

		public void setRank(String rank) {
			this.rank = rank;
		}

		public String getTeamName() {
			return teamName;
		}

		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}

		public String getSportsCategory() {
			return sportsCategory;
		}

		public void setSportsCategory(String sportsCategory) {
			this.sportsCategory = sportsCategory;
		}

		public long getIncome() {
			return income;
		}

		public void setIncome(long income) {
			this.income = income;
		}

		public boolean isMarried() {
			return isMarried;
		}

		public void setMarried(boolean isMarried) {
			this.isMarried = isMarried;
		}

		public String getSpouseName() {
			return spouseName;
		}

		public void setSpouseName(String spouseName) {
			this.spouseName = spouseName;
		}

		public boolean isHasChildren() {
			return hasChildren;
		}

		public void setHasChildren(boolean hasChildren) {
			this.hasChildren = hasChildren;
		}

		public String getChildrenDetails() {
			return childrenDetails;
		}

		public void setChildrenDetails(String childrenDetails) {
			this.childrenDetails = childrenDetails;
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
	

	}


