package lab17;

public class Country {
private String name;
private int population;
private int infectedWithCorona;
private int survivedCorona;


public Country() {}

public Country(String name, int population, int infectedWithCorona, int survivedCorona) {
	super();
	this.name = name;
	this.population = population;
	this.infectedWithCorona = infectedWithCorona;
	this.survivedCorona = survivedCorona;
}

public Country(String name, int population) {
	super();
	this.name = name;
	this.population = population;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPopulation() {
	return population;
}
public void setPopulation(int population) {
	this.population = population;
}
public int getInfectedWithCorona() {
	return infectedWithCorona;
}

public void setInfectedWithCorona(int infectedWithCorona) {
	this.infectedWithCorona = infectedWithCorona;
}

public int getSurvivedCorona() {
	return survivedCorona;
}

public void setSurvivedCorona(int survivedCorona) {
	this.survivedCorona = survivedCorona;
}

@Override
public String toString() {
	return name + " (population: " + population + ")" + "\nPopulation diagnosed with COVID-19: " + infectedWithCorona + 
			" \nPopulation that has recovered from COVID-19: " + survivedCorona;
}
}
