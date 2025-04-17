import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    // Instance variables (if needed)
    Dog newDog;
    
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    // Instance variables (if needed)
    Monkey newMonkey;

    public static void main(String[] args) {
    	Scanner scnr = new Scanner(System.in);
        initializeDogList();
        initializeMonkeyList();
    
        String option = "";
        
        // A loop that displays the menu, accepts the users input
        // and takes the appropriate action.
        while (!option.equals("q")) {
            displayMenu();
            option = scnr.nextLine();
            
            switch(option) {

            case "1":
            	intakeNewDog(scnr);
            	break;

            case "2":
            	intakeNewMonkey(scnr);
            	break;

            case "3":
            	reserveAnimal(scnr);
            	break;

            case "4":
            	//printAnimals("Dog");
            	System.out.println("This option needs to be implemented");
            	break;

            case "5":
            	//printAnimals("Monkey");
            	System.out.println("This option needs to be implemented");
            	break;

            case "6":
            	printAnimals();
            	break;
            }
        }
    }
    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }
    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "in service", true, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "in service", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", false, "Canada");
        Dog dog4 = new Dog("Rupert", "Ridgeback", "female", "1", "25.6", "12-12-2020", "United States", "in service", false, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        dogList.add(dog4);
    }
    // Adds monkeys to a list for testing
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("Fluffy", "Squirrel Monkey", "Male", "3", "37.5", "22", "14", "8", "2-2-22", "United States", "in service", false, "United States");    	
    	Monkey monkey2 = new Monkey("Larry", "Mini-Monkey", "Male", "3", "37.5", "22", "14", "8", "2-2-22", "Canada", "in service", false, "Canada");    	

    	
    	monkeyList.add(monkey1);
    	monkeyList.add(monkey2);
    }
    // IntakeNewDog method
    // Input validation to check that the dog is not already in the list
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }                
        // Instantiate a new dog and add it to the appropriate list
			System.out.println("Please enter the following information for " + name + ":");
			System.out.println("Enter Breed");
			String breed = scanner.nextLine();
			System.out.println("Enter Gender");
			String gender = scanner.nextLine();			
			System.out.println("Enter Age");
			String age = scanner.nextLine();
			System.out.println("Enter Weight");
			String weight = scanner.nextLine();
			System.out.println("Enter acquisition date");
			String acquisitionDate = scanner.nextLine();			
			System.out.println("Enter acquisition country.");
			String acquisitionCountry = scanner.nextLine();			
			System.out.println("Enter training status.");
			String trainingStatus = scanner.nextLine();
			
			//Sets reserved status with input validation
			boolean reserved = false;
			//do-loop will execute while reservationValidation is false
			boolean reservationValidation = false;			
			do {
			System.out.println("Reserved: [1] NO  [2] Yes");
			String reservedStatus = scanner.nextLine();
				if (reservedStatus.equals("1")) {
					reserved = false;
					reservationValidation = true;
				}
				else if (reservedStatus.equals("2")) {
					reserved = true;    	
					reservationValidation = true;
				}
				else {
					System.out.println("Invalid Entry");
				}
			} while (!reservationValidation);
			
			
			System.out.println("Enter In Service Country.");
			String inServiceCountry = scanner.nextLine();
	
			Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
			//adds new dog to list
			dogList.add(newDog);
			System.out.println("You have added " + newDog.getName() + "!");
			return;  			
        }
    }
        // intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
        public static void intakeNewMonkey(Scanner scanner) {
            System.out.println("What is the monkey's name?");
            String name = scanner.nextLine();
            String species = "";
        	//make sure the monkey doesn't already exist and the species type is allowed
            for(Monkey monkey: monkeyList)
                if(monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system\n\n");
                    return; //returns to menu
                }                
            // Instantiate a new monkey and add it to the appropriate list
    			System.out.println("Please enter the following information for " + name + ":");

    			// species validation
    			boolean speciesValid = false;
    			do {
        			System.out.println("Enter Species");
        			species = scanner.nextLine();
    			if (!species.equalsIgnoreCase("Capuchin") 
    				&& !species.equalsIgnoreCase("Guenon") 
    				&& !species.equalsIgnoreCase("Macaque")
    				&& !species.equalsIgnoreCase("Marmoset")
    				&& !species.equalsIgnoreCase("Squirrel Monkey")
    				&& !species.equalsIgnoreCase("Tamarin"))   {
        			System.out.println("Invalid species");
        			return;
    				}    			    			
    			else { 
    				speciesValid = true;
    			}    			    				
    			} while (!speciesValid);
            
    			//user input for monkey's attributes
    			System.out.println("Enter Gender");
    			String gender = scanner.nextLine();			
    			System.out.println("Enter Age");
    			String age = scanner.nextLine();
    			System.out.println("Enter Height");
    			String height = scanner.nextLine();
    			System.out.println("Enter Weight");
    			String weight = scanner.nextLine();
    			System.out.println("Enter Body Length");
    			String bodyLength = scanner.nextLine();
    			System.out.println("Enter Tail Length");
    			String tailLength = scanner.nextLine();
    			System.out.println("Enter acquisition date");
    			String acquisitionDate = scanner.nextLine();			
    			System.out.println("Enter acquisition country.");
    			String acquisitionCountry = scanner.nextLine();			
    			System.out.println("Enter training status.");
    			String trainingStatus = scanner.nextLine();		
    			System.out.println("Reserved: [1] NO  [2] Yes");
    			String reservedStatus = scanner.nextLine();
    			boolean reserved = false;
    			//Sets reserved status with input validation
    				if (reservedStatus.equals("1")) 
    					reserved = false;    				
    				else if (reservedStatus.equals("2"))
    					reserved = true;    			    			
    				else {
    					System.out.println("Invalid Entry");
    					return; //returns to menu
    				}
    			System.out.println("Enter in Service Country.");
    			String inServiceCountry = scanner.nextLine();
    			
    			Monkey newMonkey = new Monkey(name, species, gender, age, height, weight, bodyLength, tailLength, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
    			// adds new monkey to list
    			monkeyList.add(newMonkey);
    			System.out.println("You have added " + newMonkey.getName() + "!");
    			return;          			
            }
        // FEEDBACK TOOL said to also check the training status in coop with country and reserved
        // reserve Animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("Please enter animal type of Monkey or Dog: ");
            String animalType = scanner.nextLine();
    		System.out.println("Enter Country");
    		String country = scanner.nextLine();
    		// checks to see if a dog is available matching user parameters
            if (animalType.equalsIgnoreCase("Dog")){
            	for(Dog dog: dogList)  {
            		if ( 
                      dog.getInServiceLocation().equalsIgnoreCase(country) &&
                      !dog.getReserved() && 
                      dog.getTrainingStatus().equals("in service")
                    ) {
            			// if dog is available, set that dog reserved status to true
                      dog.setReserved(true);
                      System.out.println(dog.getName() + " has been reserved!");
                      return; // returns to menu
                    }
            	}
            	// no dog found matching user parameters
                System.out.println("No dogs found in " + country);
            }  // checks to see if a monkey is available matching user parameters   	
            else if (animalType.equalsIgnoreCase("Monkey")){
            	for(Monkey monkey: monkeyList) {       			
            		if(
            		   monkey.getInServiceLocation().equalsIgnoreCase(country) && 
            	       !monkey.getReserved() &&
            	       monkey.getTrainingStatus().equals("in service")
            	       ) {
            			// if monkey is available, set that monkey reserved status to true
            		   monkey.setReserved(true);
            		   System.out.println(monkey.getName() + " has been reserved!");
            		   return;    // returns to menu         			             					
            		}            		            		            				
            	}
            	// no monkey found matching user parameters
            	System.out.println("No monkeys found in " + country);
            }
            // input validation for dog/monkey
            else {
            	System.out.println("Invalid selection");
            	}
        }    
        // loops to print all available animals   
        public static void printAnimals() {         	
            		System.out.println();
            		System.out.println("Available Dogs: ");
            		// prints available dogs
            	for(Dog dog: dogList)
            		// checks that dog reserved = false AND trainingStatus = in service
            		if (dog.getReserved() == false && dog.getTrainingStatus().equals("in service"))
            			System.out.println("Name: " + dog.getName() 
            			+ "  ||  Status: " + dog.getTrainingStatus()
            			+ "  ||  " + "Acquisition Country: " + dog.getAcquisitionLocation()
            			+ "  ||  " + "Animal Reserved: " + dog.getReserved());
        		// prints all available monkeys
            		System.out.println();
            		System.out.println("Available Monkeys: ");
            	for(Monkey monkey: monkeyList)
            		// checks that monkey reserved = false AND trainingStatus = in service
            		if (monkey.getReserved() == false && monkey.getTrainingStatus().equals("in service"))   
            			System.out.println("Name: " + monkey.getName() 
            			+ "  ||  " +  "Status: " + monkey.getTrainingStatus() 
            			+ "  ||  " + "Acquisition Country: " + monkey.getAcquisitionLocation()
            			+ "  ||  " + "Animal Reserved: " + monkey.getReserved());           		
            }
        }                                