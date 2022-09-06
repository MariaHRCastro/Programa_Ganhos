package aplicativo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Departamento;
import entidades.Funcionario;
import entidades.HoraContrato;
import entidades.enums.NivelFuncionario;

public class Programa {

	public static void main(String[] args) throws ParseException {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner (System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
	System.out.print("Nome do departamento do funcionário: ");	
	String dept = sc.nextLine();
	
	System.out.println("Entre com os dados do funcionário");
	System.out.print("Nome: ");
	String nome = sc.nextLine();
	System.out.print("Nível: ");
	String nivel= sc.next();
	System.out.print("Salario base: ");
	Double salario = sc.nextDouble();
	

	Funcionario func = new Funcionario(nome,NivelFuncionario.valueOf(nivel),salario,new Departamento(dept));
	
	System.out.println();
	System.out.print("Quantos contratos esse funcionário possui? ");
	int n = sc.nextInt();
	
	for (int i=1;i<=n;i++) {
		System.out.println("DADOS DO CONTRATO #"+i);
		System.out.print("Data (DD/MM/YYYY): ");
		Date data = sdf.parse(sc.next());
		System.out.print("Valor hora: ");
		double valorHora = sc.nextDouble();
		System.out.print("Duração (horas): ");
		int horas = sc.nextInt();
		
		HoraContrato contrato = new HoraContrato(data,valorHora,horas);
		
		func.addContrato(contrato);
	}
	
	System.out.println();
	
	System.out.print("Gostaria de fazere uma consulta (S/N)?");
	char escolha = sc.next().charAt(0);
	
	while ( escolha == 'S'|| escolha == 's') {
	
	System.out.print("Entre com o mês e ano para cálculo dos ganhos (MM/YYYY): ");
	String mesano = sc.next();
	int mes = Integer.parseInt(mesano.substring(0,2));
	int ano = Integer.parseInt(mesano.substring(3));
	
	System.out.println("Nome: "+func.getNome());
	System.out.println("Departamento: "+func.getDepartamento().getNome());
	System.out.println("Ganhos em "+ mesano+": R$"+ String.format("%.2f",func.ganhos(mes, ano)));
	
	System.out.println();
	System.out.print("Gostaria de fazer uma consulta (S/N)?");
	escolha = sc.next().charAt(0);
	System.out.println();

	}
	System.out.println("OBRIGADA!");			
	sc.close();
	}

}
