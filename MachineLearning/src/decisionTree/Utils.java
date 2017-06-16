package decisionTree;

public class Utils {

	public double entropy(double a, double b) {
		double ent = 0.0;
		if (a == 0 || b == 0)
			return ent;
		
		double n = a + b;
		ent = ((a / n) * logBase2(a / n)) + ((b / n) * logBase2(b / n));
		ent *= -1;

		return ent;
	}

	public double infoGain(int[] classify, int[] attribute) {
		int yes = 0, no = 0;
		int len = classify.length;
		for (int i = 0; i < len; i++)
			if (classify[i] == 1)
				yes++;
			else
				no++;

		double entropyY = entropy(no, yes);

		double x1 = 0, x2 = 0, x3 = 0;
		double n = attribute.length;

		for (int i = 0; i < attribute.length; i++)
			switch (attribute[i]) {
			case 1:
				x1++;
				break;
			case 2:
				x2++;
				break;
			case 3:
				x3++;
				break;
			default:
				break;
			}
		
		double p_x1 = 0, p_x2 = 0, p_x3 = 0;
		p_x1 = x1 / n;
		p_x2 = x2 / n;
		p_x3 = x3 / n;

		double conditionalEntropyY_X = p_x1 * specificConditionalEntropy(classify, attribute, 1)
				+ p_x2 * specificConditionalEntropy(classify, attribute, 2)
				+ p_x3 * specificConditionalEntropy(classify, attribute, 3);

		return entropyY - conditionalEntropyY_X;
	}

	private double specificConditionalEntropy(int[] classify, int[] attribute, int value) {
		int a = 0, b = 0;
		int len = attribute.length;
		for (int i = 0; i < len; i++)
			if (attribute[i] == value)
				if (classify[i] == 1)
					a++;
				else
					b++;
		return entropy(a, b);
	}
	
	private double logBase2(double x) {
		if (x <= 0)
			return (-1) * Double.MAX_VALUE;
		return Math.log(x) / Math.log(2);
	}
/*
	private double conditionalProbability(int[] A, int[] B, int valueA, int valueB) {
		double P_AAndB = 0;
		double P_B = 0;

		double n = B.length;
		double timesBequalsValueB = 0;
		for (int i = 0; i < n; i++)
			if (B[i] == valueB)
				timesBequalsValueB++;
		P_B = timesBequalsValueB / n;

		n = A.length;
		double timeAequalsValueAANDBequalsValueB = 0;
		for (int i = 0; i < n; i++)
			if (A[i] == valueA && B[i] == valueB)
				timeAequalsValueAANDBequalsValueB++;

		P_AAndB = timeAequalsValueAANDBequalsValueB / n;

		if (P_B == 0)
			return 0;
		else
			return P_AAndB / P_B;
	}
*/
}
