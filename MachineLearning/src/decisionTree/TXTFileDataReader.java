package decisionTree;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TXTFileDataReader {
	public int[][] read(InputStream in, int numberOfVotes) throws Exception {
		ArrayList<String> stringsData = new ArrayList<String>(); // holder
		BufferedReader input = new BufferedReader(new InputStreamReader(in)); // reader

		String str; // temp string
		while (input.ready()) { // data reading
			str = input.readLine();
			if (str != null)
				stringsData.add(str);
		}
		
		return dataCast(stringsData,numberOfVotes);
	}
	public int[] getClassificationArr(int[][] arr) {
		int dataSize = arr.length;
		int[] classification = new int[dataSize];

		for (int i = 0; i < dataSize; i++) {
			classification[i] = arr[i][0];
		}

		return classification;
	}

	public int[][] getAttributesArr(int[][] arr, int attributesNum) {
		int dataSize = arr.length;
		int[][] data = new int[attributesNum][];

		for (int i = 1; i < attributesNum + 1; i++) {
			int[] temp = new int[dataSize];
			for (int j = 0; j < dataSize; j++)
				temp[j] = arr[j][i];
			data[i - 1] = temp;
		}

		return data;
	}
	private int[][] dataCast(ArrayList<String> arr, int numberOfVotes) throws Exception {
		int arrSize = arr.size();
		int[][] data = new int[arrSize][numberOfVotes];
		
		for (int i = 0; i < arrSize; i++) {
			String[] votes = arr.get(i).split(",");
			int len = votes.length;
			for(int j = 0; j < len; j++){
				switch (votes[j]) {
				case "y":	
					data[i][j] = 1;
					break;
				case "n":	
					data[i][j] = 2;
					break;
				case "?":	
					data[i][j] = 3;
					break;
				case "republican":	
					data[i][j] = 1;
					break;
				case "democrat":
					data[i][j] = 2;
					break;
				default:
					throw new Exception("unable to resolve the vote type  :  " + votes[j]);
				}
			}
		}

		return data;
	}
}
