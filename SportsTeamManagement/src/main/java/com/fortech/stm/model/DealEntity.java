package com.fortech.stm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



	@Entity
	@Table(name = "deals")
	public class DealEntity {

			private static final long serialVersionUID = -6134776758947464648L;

		
			// name
			
			@Id
			@GeneratedValue(strategy = GenerationType.TABLE)
			@Column(name = "id")
			private long id;			
			
			@NotNull
			@Column(name = "dealname", unique = true, length = 50)
			private String dealname;
			
			@Column(name = "valability") // valability of the deal , expressed in months
			private int valability;
			
			@NotNull
			@Column(name = "numberofplayersbought") 
			private int numberOfPlayersBought;
			
			@NotNull
			@Column(name = "numberofplayerssold") 
			private int numberOfPlayerssold;
			
			@NotNull
			@Column(name = "sportscategory") /// the deal is concerning the following sport
			private String sportsCategory;
					
			@NotNull
			@Column(name = "amounttransactioned")
			private double amountTransactioned;

			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getDealname() {
				return dealname;
			}

			public void setDealname(String dealname) {
				this.dealname = dealname;
			}

			public int getValability() {
				return valability;
			}

			public void setValability(int valability) {
				this.valability = valability;
			}

			public int getNumberOfPlayersBought() {
				return numberOfPlayersBought;
			}

			public void setNumberOfPlayersBought(int numberOfPlayersBought) {
				this.numberOfPlayersBought = numberOfPlayersBought;
			}

			public int getNumberOfPlayerssold() {
				return numberOfPlayerssold;
			}

			public void setNumberOfPlayerssold(int numberOfPlayerssold) {
				this.numberOfPlayerssold = numberOfPlayerssold;
			}

			public String getSportsCategory() {
				return sportsCategory;
			}

			public void setSportsCategory(String sportsCategory) {
				this.sportsCategory = sportsCategory;
			}

			public double getAmountTransactioned() {
				return amountTransactioned;
			}

			public void setAmountTransactioned(double amountTransactioned) {
				this.amountTransactioned = amountTransactioned;
			}
			
			


}
