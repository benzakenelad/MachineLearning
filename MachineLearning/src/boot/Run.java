package boot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import decisionTree.TXTFileDataReader;
import decisionTree.Utils;

public class Run {

	final static int attributesNum = 16;

	public static void main(String[] args) {
		
		int[][] dataTemp = null;
		Utils utils = new Utils();
		TXTFileDataReader loader = new TXTFileDataReader();
		try {
			dataTemp = loader.read(new FileInputStream("traningData.txt"), attributesNum + 1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// question 1
		int[][] data = loader.getAttributesArr(dataTemp, attributesNum);																														// array
		int[] classification = loader.getClassificationArr(dataTemp); 

		// question 2
		int republicans = 0;
		int democrats = 0;
		for (int i = 0; i < classification.length; i++)
			if (classification[i] == 1)
				republicans++;
			else
				democrats++;
		
		double entropyY = utils.entropy(republicans, democrats);


		System.out.println("republicans & democrats entropy : " + entropyY + "\n\n");

		// question 3
		System.out.println("Attributes Information Gain :\n");
		System.out.println("handicapped infants information gain : " + utils.infoGain(classification, data[0]));
		System.out.println("water project cost sharing information gain : " + utils.infoGain(classification, data[1]));
		System.out.println("adoption of the budget resolution information gain : " + utils.infoGain(classification, data[2]));
		System.out.println("physician fee freeze information gain : " + utils.infoGain(classification, data[3]));
		System.out.println("el salvador aid information gain : " + utils.infoGain(classification, data[4]));
		System.out.println("religious groups in schools information gain : " + utils.infoGain(classification, data[5]));
		System.out.println("anti satellite test ban information gain : " + utils.infoGain(classification, data[6]));
		System.out.println("aid to nicaraguan contras information gain : " + utils.infoGain(classification, data[7]));
		System.out.println("mx missile information gain : " + utils.infoGain(classification, data[8]));
		System.out.println("immigration information gain : " + utils.infoGain(classification, data[9]));
		System.out.println("synfuels corporation cutback information gain : " + utils.infoGain(classification, data[10]));
		System.out.println("education spending information gain : " + utils.infoGain(classification, data[11]));
		System.out.println("superfund right to sue information gain : " + utils.infoGain(classification, data[12]));
		System.out.println("crime information gain : " + utils.infoGain(classification, data[13]));
		System.out.println("duty free exports information gain : " + utils.infoGain(classification, data[14]));
		System.out.println("export administration act south africa information gain : " + utils.infoGain(classification, data[15]));  
		

	}

}
