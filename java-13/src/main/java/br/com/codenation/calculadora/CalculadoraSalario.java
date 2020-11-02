package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		if(salarioBase < 1039)
			return Math.round(0.0);

		double salarioDescontadoInss = salarioBase - calcularInss(salarioBase);
		double salarioLiquido = salarioDescontadoInss - calcularIrrf(salarioDescontadoInss);

		return Math.round(salarioLiquido);
	}

	private double calcularInss(double salarioBase) {
		double inss;

		if(salarioBase <= 1500){
			inss = salarioBase * 0.08;
		}
		else if(salarioBase > 1500 && salarioBase <= 4000){
			inss = salarioBase * 0.09;
		}
		else{
			inss = salarioBase * 0.11;
		}

		return inss;
	}

	private double calcularIrrf(double salarioDescontado){
		double irrf;

		if(salarioDescontado <= 3000){
			irrf = 0;
		}
		else if(salarioDescontado > 3000 && salarioDescontado <= 6000){
			irrf = salarioDescontado * 0.075;
		}
		else{
			irrf = salarioDescontado * 0.15;
		}

		return irrf;

	}

}