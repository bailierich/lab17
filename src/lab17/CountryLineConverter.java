package lab17;

public class CountryLineConverter implements LineConverter<Country> {
	
	@Override
	public String toLine(Country object) {
		
		// return object attributes separated with a delimeter
		return object.getName()+","+object.getPopulation()+ "," + object.getInfectedWithCorona() + "," + object.getSurvivedCorona();
	}

	@Override
	public Country fromLine(String line) {
		
		// delimeter separates object's attributes
		String[] parts = line.split(",");
		String name = parts[0];
		int population = Integer.parseInt(parts[1]);
		int hasCorona = Integer.parseInt(parts[2]);
		int recovered = Integer.parseInt(parts[3]);
		return new Country(name, population , hasCorona, recovered);
	}

}
	
	
	

