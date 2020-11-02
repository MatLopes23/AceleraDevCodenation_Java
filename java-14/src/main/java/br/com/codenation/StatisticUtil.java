package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		return (int) Arrays
				.stream(elements)
				.average()
				.getAsDouble();
	}

	public static int mode(int[] elements) {
		int mode = 0;
		int currentTimes = 0;
		int currenteAux = 0;

		for (int elementOut : elements){
			for (int elementInto : elements){
				if (elementOut == elementInto)
					currenteAux++;
			}

			if (currenteAux > currentTimes)
			{
				mode = elementOut;
				currentTimes = currenteAux;
			}
			currenteAux = 0;
		}

		return mode;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);

		if(elements.length % 2 != 0){
			int middle = (elements.length + 1) / 2;
			return elements[middle - 1];
		}else {
			int first = elements.length / 2;
			int second = first + 1;

			return (elements[first - 1] + elements[second - 1]) / 2;
		}
	}
}