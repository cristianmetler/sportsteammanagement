package pojo;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;


@Service
public class PlayerPojo {
	
	
	@NotNull
	private String playerName;
	private int age;
	
	
	@NotNull
	//the position occupied within the team: captain, goalkeeper, pivot etc
	private String rank;
	
	@NotNull
	// in what team does he play
	private String teamName;
	
	
	@NotNull
	/// does his team play football, handball etc
	private String sportsCategory;
	
	
	@NotNull
	private long income;
	
	@NotNull
	private boolean isMarried;
	
	
	private String spouseName;
	
	@NotNull
	private boolean hasChildren;
	
	@NotNull
	private String childrenDetails;	
	@NotNull
	private String address;
	
	
	@NotNull
	private int ratingScore;
	
	
	@NotNull	
	private String emailAddress;
	
	@NotNull
	private String phoneNumber;
	
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
