package ThreadMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// F O R  R E A D M E
// my solution assumes that a user would always prefer an exact match or closest match, it does not give a user the option to choose.
// implementation for this logic is included in the commented out 'F I R S T   S O L U T I O N'

public class ThreadMatcher {

	public static void main(String[] args) {
		//build an array of thread spools that exist on a machine	
		List<Thread> machineThreads = new ArrayList<>(); 
		machineThreads.add(new Thread("ThreadCo", "Fire Engine", 1234, 0.5));
		machineThreads.add(new Thread("ThreadCo", "Midnight", 5678, 2.7));
		machineThreads.add(new Thread("EmbroideryInc", "Sunlight", 900, 17.5));
	    
		//'listen' or collect user input for values
		Scanner scanner = new Scanner(System.in);

		//implement method logic
	     run(machineThreads, scanner);     
	 
	     
	     scanner.close();
	               
	}
	
	public static void run(List<Thread> machineThreads, Scanner scanner) {               
		System.out.println("PROBLEM 1: Thread Matching");
	    
	//collect thread type to compare     
	     System.out.print("Manufacturer: ");
	     String manufacturer = scanner.next();
	     
	     System.out.print("Name: ");
	     String name = scanner.next();
	     scanner.nextLine();
	     
	     System.out.print("Code: ");
	     int code = scanner.nextInt();
	     
	     System.out.print("Color: ");
	     double color = scanner.nextDouble();
	     
	   //create a thread from user inputs  
	     Thread designThread = new Thread(manufacturer, name, code, color);
	     
	     int exactMatchIndex = exactMatch(designThread, machineThreads);
	     
	     if(exactMatchIndex != -1) {
	    	 System.out.println("exact match found index: "+ exactMatchIndex);
	     } else {
	    	 int closestMatchIndex = closestMatch(designThread, machineThreads);
	    	 	if(closestMatchIndex != -1) {
	    	 		System.out.print("closest match found index: "+closestMatchIndex);
	    	 	} else {
	    	 		System.err.print("no match available, check inputs");
	    	 	}
	     }
	
	}
		
	
	
	
	public static int exactMatch(Thread designThread, List<Thread> machineThreads) {
	    for (int i = 0; i < machineThreads.size(); i++) {
	        Thread machineThread = machineThreads.get(i);
	        if (designThread.getManufacturer().equals(machineThread.getManufacturer())
	                && designThread.getName().equals(machineThread.getName())
	                && designThread.getCode() == machineThread.getCode()) {
	            return i;
	        }
	    }
	    return -1;
	}

	public static int closestMatch(Thread designThread, List<Thread> machineThreads) {
	    int closestMatchIndex = -1;
	    double minDifference = Double.MAX_VALUE;

	    for (int i = 0; i < machineThreads.size(); i++) {
	        Thread machineThread = machineThreads.get(i);
	        double difference = designThread.difference(machineThread);
	        if (difference < minDifference) {
	            closestMatchIndex = i;
	            minDifference = difference;
	        }
	    }

	    return closestMatchIndex;
	}
	
//	F I R S T   S O L U T I O N 
//  i chose to separate the exactMatch and closestMatch
//	public static int matchingThread(Thread designThread, boolean useExactMatch, List<Thread> machineThreads) {
//		
//		int closestMatchIndex = -1;
//		
//		double minimumDifference = Double.MAX_VALUE;
//		
//		for(int i = 0; i < machineThreads.size(); i++) {
//			
//			Thread machineThread = machineThreads.get(i);
//			
//			if ((useExactMatch && designThread.getManufacturer().equals(machineThread.getManufacturer())
//                    && designThread.getName().equals(machineThread.getName())
//                    && designThread.getCode() == machineThread.getCode())
//                    || (!useExactMatch && designThread.difference(machineThread) < minimumDifference))
//				{
//				closestMatchIndex = i;
//				minimumDifference = designThread.difference(machineThread);
//				}
//					}
//	
//	return closestMatchIndex;
//	}
	

}


//  M A T C H I N G   T H R E A D   C O L O R S
//Each embroidery design file specifies the thread colors that should be used by the design. 
//The machine’s GUI software also specifies which thread colors are presently physically loaded on the
//machine. 
//When loading a design to the machine, the user has the option of manually designating which
//of the machine’s colors will be used to represent each of the design colors, but we also implement a
//function to automatically make the best selection for them. The user can choose whether to use an
//‘exact match’ or ‘closest match’.