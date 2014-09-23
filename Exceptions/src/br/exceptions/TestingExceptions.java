package br.exceptions;

public class TestingExceptions {

	public static void main(String[] args) {
		try {
			//dividePorZero();
			Animal animal = null;
			animal.setId(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Algo ocorreu!");
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void dividePorZero(){
		int numero = 5 / 0;
	}

}
