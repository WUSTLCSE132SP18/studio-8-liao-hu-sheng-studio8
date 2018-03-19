package studio8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// TODO: Develop an algorithm to count steps in accelerometer data
//    Major steeps:
//       1. Create a class and main method.
//       2. Using a Scanner and File object, read data from your .csv file.
//       3. Develop and test algorithms to count the "peaks" in the data.

public class CountSteps{
	// We count the peak on the z side
	public static int count(String path) {
		List<Double> list = new LinkedList<>();
		File file = new File(path);
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String[] s = sc.nextLine().split(",");
				if(s.length == 3) {
					double num = Double.parseDouble(s[2]);
					list.add(num);
				}
			}
			sc.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int count = 0;
		for(int i = 1; i < list.size()-1; i++) {
			if(list.get(i) > list.get(i-1) && list.get(i) < list.get(i+1)) count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		String path = "data/data.txt";
		System.out.println(count(path));
	}
	
	

}