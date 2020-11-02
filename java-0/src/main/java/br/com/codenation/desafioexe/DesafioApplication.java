package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> listFibo = new ArrayList<>();

		int fib1 = 0;
		int fib2 = 1;

		listFibo.add(fib1);
		listFibo.add(fib2);

		int fibN;

		do{
			fibN = fib1 + fib2;
			fib1 = fib2;
			fib2 = fibN;

			listFibo.add(fibN);
		}while (fibN <= 350);

		return listFibo;
	}

	public static Boolean isFibonacci(Integer n) {
		List<Integer> lisFibo = fibonacci();

		return lisFibo.contains(n);
	}

}
