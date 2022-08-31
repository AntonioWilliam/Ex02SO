package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {
 public static void main(String[] args) {
	KillController processo = new KillController();
	String oss = System.getProperty("os.name");
	int opc = 0;
	while (opc != 9) {
		opc = Integer.parseInt(JOptionPane.showInputDialog("1- System \n 2-Lista de processos \n 3-Matar com PID \n 4- Matar com o nome \n 9- Fechar"));
		switch (opc) {
		case 1: 
			String os = processo.os();
			System.out.println(os);
			break;
		case 2:
			if (oss.contains("Windows")) {
			String process = "TASKLIST /FO TABLE";
			processo.listaProcessos(process);
			}else if (oss.contains("Linux")){
				String process = "ps -ef";
				processo.listaProcessos(process);
			}
			break;
		case 3:
			int mata = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do PID"));
		    processo.mataPid(mata);
			break;
		case 4:
			String matarNome =JOptionPane.showInputDialog("Digite o nome do executavel");
			processo.mataNome(matarNome);
			break;
		case 9:
			System.exit(0);
		default:
			JOptionPane.showMessageDialog(null, "opçao invalida");
			break;
		}
	}
}
 
}
