package net.azib.java.students.t020632.homework;

import java.util.List;

/**
 * ConsoleOutput prints results to the console
 *
 * @author Marek Soobik t020632
 */
public class ConsoleOutput implements Output {

	/**
	 * Prints results to console
	 */
	public void write(List<AthleteResults> results) {
		
		int i = 0;
		int j = 0;
		
		AthleteResults result;
		
		System.out.print("Place \t");
		System.out.print("Score \t");
		System.out.print("Name \t\t\t");
		System.out.print("Date Of Birth \t");
		System.out.print("Country \t");
		System.out.print("100m \t\t");
		System.out.print("Long Jump \t");
		System.out.print("Shot Put \t");
		System.out.print("High jump \t");
		System.out.print("400m \t\t");
		System.out.print("110m hurdles \t");
		System.out.print("Discus Throw \t");
		System.out.print("Pole Vault \t");
		System.out.print("Javelin Throw \t");
		System.out.println("1500m \t");
		
		while(j < results.size()){
			result = results.get(j);
			System.out.print(result.getPosition() + "\t");
			System.out.print(result.getScore() + "\t");
			if(result.getName().length() > 15)
				System.out.print(result.getName() + "\t");
			else
				System.out.print(result.getName() + "\t\t");
			System.out.print(result.getDateOfBirth() + "\t");
			System.out.print(result.getCountry() + "\t\t");
			i = 0;
			while(i < 10 ){
				System.out.print(result.getEvent(i).getResult() + "\t\t");
				i++;
			}
			System.out.println();
			j++;
			
		}
	}

}
