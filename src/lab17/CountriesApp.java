package lab17;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountriesApp {
	private static String countryInput;
	private static int populationInput;
	private static int popWithCoronaInput;
	private static int popThatSurvivedCorona;
	
	private static FileHelper<Country> helper = new FileHelper<>("countries.txt", new CountryLineConverter());
	private static List<String> menu = new ArrayList<>();
	static {
		menu.add("See the countries list");
		menu.add("Add a country");
		menu.add("Delete a country");
		menu.add("Modify the population");
		menu.add("Exit");
	}
	private static int choice;
	private static Scanner scnr = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Countries Maitenence Application!");
		printMenu();
	makeChoice();
System.out.println("Bye Bye");
	}
private static void printMenu() {
	for (int index = 0; index < menu.size(); index++) {
		System.out.println( (index + 1) + " - " + menu.get(index) );
	}
}
private static void makeChoice() {
	choice = ValidatorHelper.getIntAtOrAbove(scnr, "\nEnter Menu number: ", 1);
	if (choice == 1) {
		ListCountries();	
		makeChoice();
	}else if (choice == 2) {
		writeCountry();
		makeChoice();
	}else if (choice == 3) {
		deleteCountry();
		makeChoice();
		}else if(choice == 4) {
		changePop();
		makeChoice();
		}else if (choice == 5) {
			return;
}
	
}
private static void writeCountry() {
	
	countryInput = ValidatorHelper.getString(scnr, "\nEnter a Country: ");
	scnr.nextLine();
	populationInput = ValidatorHelper.getInt(scnr, "\nWhat is the population: ");
	popWithCoronaInput = ValidatorHelper.getInt(scnr, "\nHow many people have been diagnosed with COVID-19?");
	popThatSurvivedCorona = ValidatorHelper.getInt(scnr, "\nHow many people have recovered?");
	helper.append(new Country(countryInput,populationInput,popWithCoronaInput,popThatSurvivedCorona));
	
	
}
private static void deleteCountry() {
	System.out.println();
	int input;
	List<Country> allCountries = helper.readAll();
	for(int index = 0; index < allCountries.size(); index++) {
		System.out.println((index + 1) + " - " + allCountries.get(index));
	}
	System.out.println();
	input = ValidatorHelper.getInt(scnr, "\nWhat country would you like to delete?");
	allCountries.remove(input - 1);
	helper.rewrite(allCountries);
	
}
private static void changePop() {
	System.out.println();
	int input;
	List<Country> allCountries = helper.readAll();
	for(int index = 0; index < allCountries.size(); index++) {
		System.out.println((index + 1) + " - " + allCountries.get(index));
	}
	System.out.println();
	input = ValidatorHelper.getInt(scnr, "\nWhich country's population do you want to change?");
	allCountries.get(input - 1).setPopulation(ValidatorHelper.getInt(scnr, "What is the new population?"));
	helper.rewrite(allCountries);
}
private static void ListCountries() {
	
	List<Country> printCountries = helper.readAll();
	for(int index = 0; index < printCountries.size(); index++) {
		System.out.println((index + 1) + " - " + printCountries.get(index));
		System.out.println();
	}
}
}
