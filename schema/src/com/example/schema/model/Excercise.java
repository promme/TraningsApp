package com.example.schema.model;

public class Excercise {
	
//	KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//	KEY_TITLE + " TEXT NOT NULL, " + 
//	KEY_TRAINING_NAME + " TEXT NOT NULL, " + 
//	KEY_SET + " INTEGER, " + 
//	KEY_REPITITIONS + " INTEGER, " + 
//	KEY_TRAINING_TYPE + " TEXT NOT NULL);");
	
	
	private int id;
	private String title;
	private String excerciseName;
	private int numberOfSets;
	private int numberOfRepititions;
	private String trainingType;
	private String muscleGroup;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getExcerciseName() {
		return excerciseName;
	}
	public void setExcersiseName(String trainingName) {
		this.excerciseName = trainingName;
	}
	public int getNumberOfSets() {
		return numberOfSets;
	}
	public void setNumberOfSets(int numberOfSets) {
		this.numberOfSets = numberOfSets;
	}
	public int getNumberOfRepititions() {
		return numberOfRepititions;
	}
	public void setNumberOfRepititions(int numberOfRepititions) {
		this.numberOfRepititions = numberOfRepititions;
	}
	public String getTrainingType() {
		return trainingType;
	}
	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}
	public String getMuscleGroup() {
		return muscleGroup;
	}
	public void setMuscleGroup(String muscleGroup) {
		this.muscleGroup = muscleGroup;
	}
	
	
	
	
	
	

}
