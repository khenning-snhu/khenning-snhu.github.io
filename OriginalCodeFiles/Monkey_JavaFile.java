
public class Monkey extends RescueAnimal {

	// Instance Variables
	private String species;
	private String tailLength;
	private String height;
	private String bodyLength;
	
	// Constructor
	public Monkey(String name, String species, String gender, String age, 
	String height, String weight, String bodyLength, String tailLength,
	String acquisitionDate, String acquisitionCountry, String trainingStatus,
	boolean reserved, String inServiceCountry) {
		setName(name);
		setSpecies(species);
		setGender(gender);
		setAge(age);
		setHeight(height);
		setWeight(weight);
		setBodyLength(bodyLength);
		setTailLength(tailLength);
		setAcquisitionDate(acquisitionDate);
		setAcquisitionLocation(acquisitionCountry);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);
		setInServiceCountry(inServiceCountry);
		
	}
	
	
	
	// Accessor Method
	public String getSpecies() {
		return species;
	}
	
	// Mutator Method
	public void setSpecies(String species) {
		this.species = species;
	}
	
	// Accessor Method
	public String getTailLength() {
		return tailLength;
	}
	
	// Mutator Method
	public void setTailLength(String tailLength) {
		this.tailLength = tailLength;
	}
	
	// Accessor Method
	public String getHeight() {
		return height;
	}
	
	// Mutator Method
	public void setHeight(String height) {
		this.height = height;
	}
	
	// Accessor Method
	public String getBodyLength() {
		return bodyLength;
	}
	
	// Mutator Method
	public void setBodyLength(String bodyLength) {
		this.bodyLength = bodyLength;
	}
}
