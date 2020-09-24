package br.com.ifce.testes;

public class TesteLocalDate {
	
	public static void main(String[] args) {
		
		String dataString = "25/06/1994";
		
		int dia = Integer.parseInt(dataString.substring(0, 2));
		int mes = Integer.parseInt(dataString.substring(3, 5));
		int ano = Integer.parseInt(dataString.substring(6, 10));
		
		System.out.println(dia);
		System.out.println(mes);
		System.out.println(ano);
		
	}

}
