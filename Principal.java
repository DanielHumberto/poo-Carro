import java.util.Scanner;
public class Principal {
	public static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {	
		Carro carro = new Carro();
		String help = "\t============= help =====================\n"+
				  "\tin: embarca uma pessoa\n"+
				  "\tout: desembarca uma pessoa\n"+
				  "\tfuel _a: adiciona a de gasolina\n"+
				  "\tdrive _a: anda a km\n"+
				  "\tshow: mostra a quantidade de pessoas, gasolina e km\n"+
				  "\tsair: sai do programa\n"+
				  "\t========================================\n";
		while(true){
			System.out.print("Digite um comando"+
						"(help para ver os comandos): ");
			String comando = in.nextLine();
			if(comando.equals("help")){
				System.out.println(help);
			} else if(comando.equals("sair")){
				System.out.println("\tAté a próxima :)");
				break;
			} else {
				String c[] = comando.split(" ");
				boolean resposta;
				switch(c[0]){
				case "in":
					resposta  = carro.in();
					if(resposta==true){
						System.out.println("Pessoa embarcada");
					}else{
						System.out.println("Limite de pessoas atingido");
					}
					break;
				case "out":
					resposta  = carro.out();
					if(resposta==true){
						System.out.println("Pessoa desembarcada");
					}else{
						System.out.println("Nao ha ninguem no carro");
					}
					break;
				case"fuel":
					float value = Float.parseFloat(c[1]);
					carro.fuel(value);
					System.out.println("Carro abastecido");	
					break;
				case"drive":
					float distance = Float.parseFloat(c[1]);
					if(carro.drive(distance)==true) {
						System.out.println("Andou com sucesso");
					}else if(carro.pass==0){
						System.out.println("Nao ha ninguem no carro");
					}else {
						System.out.println("Gasolina insuficiente");
					}
					break;
				case "show":
					System.out.println(carro.show());
					break;
				default:
					System.out.println("\tComando inválido.");
				}
			}	
		}		
	}
}