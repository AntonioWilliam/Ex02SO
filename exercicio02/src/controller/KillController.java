package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
 public KillController(){
	 super();
 }
 public String os() {
	 String os = System.getProperty("os.name");
	return "Sistema operacional: " + os;
	 }
 	
public String listaProcessos (String processo) {
	String os = System.getProperty("os.name");
	if (os.contains("Windows")) {
	try {
		// ctrl + 1 = Criar variavel
		Process p = Runtime.getRuntime().exec(processo);
		//Fluxo de bits
		InputStream fluxo = p.getInputStream();
		// Leitura e conversão de String
		InputStreamReader leitor = new InputStreamReader(fluxo);
		// Informações sem parar e descartando 
		BufferedReader buffer = new BufferedReader(leitor);
		// Leitura de linha por linha, leu-> escreveu -> esqueceu REPEAT
		String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			// fechar os elementos fora 
			buffer.close();
			leitor.close();
			fluxo.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}else if(os.contains("Linux")){
		try {
			// ctrl + 1 = Criar variavel
			Process p = Runtime.getRuntime().exec(processo);
			//Fluxo de bits
			InputStream fluxo = p.getInputStream();
			// Leitura e conversão de String
			InputStreamReader leitor = new InputStreamReader(fluxo);
			// Informações sem parar e descartando 
			BufferedReader buffer = new BufferedReader(leitor);
			// Leitura de linha por linha, leu-> escreveu -> esqueceu REPEAT
			String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				// fechar os elementos fora 
				buffer.close();
				leitor.close();
				fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
	}
}
	return os;
}

 
public String mataPid (int mata) {
	String os = System.getProperty("os.name");
	if (os.contains("Windows")) {
	String cmdPid = "TASKKILL /PID";
	int pid=0;
	StringBuffer buffer = new StringBuffer();
	try {
		pid =mata;
		buffer.append(cmdPid);
		buffer.append(" ");
		buffer.append(pid);
	} catch(NumberFormatException e){
		System.err.println("PID inválido");
	}
	try {
		Runtime.getRuntime().exec(buffer.toString());
	} catch (IOException e) {
		e.printStackTrace();
	}
	}else if (os.contains("Linux")) {
		String cmdPid = "kill -9";
		int pid=0;
		StringBuffer buffer = new StringBuffer();
		try {
			pid =mata;
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
		} catch(NumberFormatException e){
			System.err.println("PID inválido");
		}
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	return os;

}

public String mataNome (String mata) {
	String os = System.getProperty("os.name");
	
	
	StringBuffer buffer = new StringBuffer();
	if (os.contains("Windows")) {
		String cmdNome = "TASKKILL /IM";
	try {	
		buffer.append(cmdNome);
		buffer.append(" ");
		buffer.append(mata);
	} catch(NumberFormatException e){
		System.err.println("Nome.exe inválido");
	}
	try {
		Runtime.getRuntime().exec(buffer.toString());
	} catch (IOException e) {
		e.printStackTrace();
		
	}}else if (os.contains("Linux")) {
		String cmdNome = "p kill -f";
		try {	
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(mata);
		} catch(NumberFormatException e){
			System.err.println("Nome.exe inválido");
		}
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
	}
	return cmdNome;
}
	return os;


}
}
