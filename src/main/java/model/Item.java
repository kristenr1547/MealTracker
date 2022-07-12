package model;

public class Item {
	private int itemID;
	private String itemName;
	private int itemAmount;
	private double itemCost;
	private int mealID;
	
	
	
	public Item(String itemName, int itemAmount, double itemCost, int mealID) {
		super();
		this.itemName = itemName;
		this.itemAmount = itemAmount;
		this.itemCost = itemCost;
		this.mealID = mealID;
	}
	public Item(int itemID, String itemName, int itemAmount, double itemCost, int mealID) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemAmount = itemAmount;
		this.itemCost = itemCost;
		this.mealID = mealID;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemAmount() {
		return itemAmount;
	}
	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount;
	}
	public double getItemCost() {
		return itemCost;
	}
	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}
	public int getMealID() {
		return mealID;
	}
	public void setMealID(int mealID) {
		this.mealID = mealID;
	}

	
	
}
