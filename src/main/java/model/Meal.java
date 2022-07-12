package model;

import java.time.LocalDate;

public class Meal {
private int mealID;
private String mealName;
private String mealType;
private String mealDay;


public Meal(String mealName, String mealType, String mealDay) {
	super();
	this.mealName = mealName;
	this.mealType = mealType;
	this.mealDay = mealDay;
}


public Meal(int mealID, String mealName, String mealType, String mealDay) {
	super();
	this.mealID = mealID;
	this.mealName = mealName;
	this.mealType = mealType;
	this.mealDay = mealDay;
}


public int getMealID() {
	return mealID;
}
public void setMealID(int mealID) {
	this.mealID = mealID;
}
public String getMealName() {
	return mealName;
}
public void setMealName(String mealName) {
	this.mealName = mealName;
}
public String getMealType() {
	return mealType;
}
public void setMealType(String mealType) {
	this.mealType = mealType;
}
public String getMealDay() {
	return mealDay;
}
public void setMealDay(String mealDay) {
	this.mealDay = mealDay;
}


@Override
public String toString() {
return this.getMealName();
}


}
