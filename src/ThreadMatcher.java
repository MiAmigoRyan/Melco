package ThreadMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadMatcher {

	public static void main(String[] args) {
		// build an array of thread spools that exist on a machine
		List<Thread> machineThreads = new ArrayList<>();
		machineThreads.add(new Thread("ThreadCo", "Fire Engine", 1234, new double[] {1.0, 0.0, 0.0}));
		machineThreads.add(new Thread("ThreadCo", "Midnight", 5678, new double[] {0.0, 0.0, 1.0}));
		machineThreads.add(new Thread("EmbroideryInc", "Sunlight", 900, new double[] {0.5, 0.5, 0.0}));

		// 'listen' or collect user input for values
		Scanner scanner = new Scanner(System.in);

		// implement method logic
		run(machineThreads, scanner);

		scanner.close();

	}

	public static void run(List<Thread> machineThreads, Scanner scanner) {
		System.out.println("PROBLEM 1: Thread Matching");

		// collect thread type to compare
		System.out.print("Manufacturer: ");
		String manufacturer = scanner.next();

		System.out.print("Name: ");
		String name = scanner.next();
		scanner.nextLine();

		System.out.print("Code: ");
		int code = scanner.nextInt();

		System.out.print("Red (0.0-1.0): ");
		double red = scanner.nextDouble();

		System.out.print("Green (0.0-1.0): ");
		double green = scanner.nextDouble();

		System.out.print("Blue (0.0-1.0): ");
		double blue = scanner.nextDouble();

		double[] color = { red, green, blue };
		// basic solution
//	     System.out.print("Color: ");
//	     double color = scanner.nextDouble();
		
	    // Ask user for matching preference
	    System.out.print("Exact match (true/false): ");
	    boolean exactMatch = scanner.nextBoolean();

		// create a thread from user inputs
		Thread designThread = new Thread(manufacturer, name, code, color);

		int matchIndex = findMatchingThread(designThread, exactMatch, machineThreads);

		if (matchIndex != -1) {
			System.out.println("exact match found index: " + matchIndex);
		} else {
			int closestMatchIndex = findMatchingThread(designThread, exactMatch, machineThreads);
			if (closestMatchIndex != -1) {
				System.out.print("closest match found index: " + closestMatchIndex);
			} else {
				System.err.print("no match available, check inputs");
			}
		}

	}

	public static int findMatchingThread(Thread designThread, boolean exactMatch, List<Thread> machineThreads) {
	    int matchIndex = -1;
	    double minDifference = Double.MAX_VALUE;

	    for (int i = 0; i < machineThreads.size(); i++) {
	        Thread machineThread = machineThreads.get(i);
	        boolean isExactMatch = designThread.getManufacturer().equals(machineThread.getManufacturer())
	                && designThread.getName().equals(machineThread.getName())
	                && designThread.getCode() == machineThread.getCode();

	        double difference = designThread.difference(machineThread);

	        if ((exactMatch && isExactMatch) || (!exactMatch && difference < minDifference)) {
	            matchIndex = i;
	            minDifference = difference;
	        }
	    }

	    return matchIndex;
	}
	
}

