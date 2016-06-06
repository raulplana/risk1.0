package judge;
import risk.DamRISK;
import utils.Utils;

import java.util.Scanner;

public class tiradaDados {
	public static final int defLimit = 2;
	public static final int atcLimit = 3;
	public static void tiradaDados(int tropasdef, int tropasatc,int paisdef, int paisatc, int [][] tauler) {
		Scanner lector = new Scanner(System.in);
		do{
		int[] tiradaatc;
		int[] tiradadef;
		if(tropasatc<=3 && tropasdef<=2){
		tiradaatc = new int [tropasatc];
		tiradadef = new int [tropasdef];
		rellenar(tiradaatc,tiradadef);
		ordenar(tiradaatc);
		ordenar(tiradadef);
		mostrar(tiradaatc,tiradadef);
		}
		else{
			if (tropasatc<=3 && tropasdef>2){
				tiradaatc = new int [tropasatc];
				tiradadef = new int [defLimit];
				rellenar(tiradaatc,tiradadef);
				ordenar(tiradaatc);
				ordenar(tiradadef);
				mostrar(tiradaatc,tiradadef);
			}
			else{
				if (tropasatc>3 && tropasdef<=2){
					tiradaatc = new int [atcLimit];
					tiradadef = new int [tropasdef];
					rellenar(tiradaatc,tiradadef);
					ordenar(tiradaatc);
					ordenar(tiradadef);
					mostrar(tiradaatc,tiradadef);
				}
				else{
					tiradaatc = new int [atcLimit];
					tiradadef = new int [defLimit];
					rellenar(tiradaatc,tiradadef);
					ordenar(tiradaatc);
					ordenar(tiradadef);
					mostrar(tiradaatc,tiradadef);
				}
			}
		}
		if (tiradaatc.length < tiradadef.length){
			for (int i = 0; i < tiradaatc.length; i++) {
				if (tiradaatc[i]==tiradadef[i]){
					tropasatc--;
					System.out.println(DamRISK.territoris[paisatc]+" pierde un soldado");
				}
				else{
					if (tiradaatc[i] < tiradadef[i]){
						tropasatc--;
						System.out.println(DamRISK.territoris[paisatc]+" pierde un soldado");
					}
					else{
						tropasdef--;
						System.out.println(DamRISK.territoris[paisdef]+" pierde un soldado");
					}
				
				}
			}
		}
		else{
			for (int i = 0; i < tiradadef.length; i++) {
				if (tiradaatc[i]==tiradadef[i]){
					tropasatc--;
					System.out.println(DamRISK.territoris[paisatc]+" pierde un soldado");
				}
				else{
					if (tiradaatc[i] < tiradadef[i]){
						tropasatc--;
						System.out.println(DamRISK.territoris[paisatc]+" pierde un soldado");
					}
					else{
						tropasdef--;
						System.out.println(DamRISK.territoris[paisdef]+" pierde un soldado");
					}
				
				}
			}
		}
		}while(finalizar(tropasatc,tropasdef,DamRISK.territoris,paisatc,paisdef,tauler));
	}
	public static void rellenar(int [] tiradaatc, int [] tiradadef){
		for (int i = 0; i < tiradaatc.length; i++) {
			tiradaatc[i] = Utils.randomizer(6);
		}
		for (int i = 0; i < tiradadef.length; i++) {
			tiradadef[i] = Utils.randomizer(6);
		}
	}
	public static void ordenar(int [] tiradaatc){
		int menor, pos, tmp;
		for (int i = 0; i < tiradaatc.length - 1; i++) {  
			menor = tiradaatc[i]; 
			pos = i; 
			for (int j = i + 1; j < tiradaatc.length; j++){ 
				if (tiradaatc[j] > menor) { 
					menor = tiradaatc[j]; 
					pos = j;
				}
			}
			if (pos != i){ 
				tmp = tiradaatc[i];
				tiradaatc[i] = tiradaatc[pos];
				tiradaatc[pos] = tmp;
			}
		}
	}
	public static void mostrar(int [] tiradaatc, int [] tiradadef){
		System.out.print("Los resultados del atacante son: ");
		for (int i = 0; i < tiradaatc.length; i++) {
			System.out.print((tiradaatc[i]+1));
			if (i==tiradaatc.length-1){
				System.out.println("");
			}
			else{
			System.out.print(", ");
			}
		}
		System.out.println("");
		System.out.print("Los resultados del defensor son: ");
		for (int i = 0; i < tiradadef.length; i++) {
			System.out.print((tiradadef[i]+1));
			if (i==tiradadef.length-1){
				System.out.println("");
			}
			else{
			System.out.print(", ");
			}
		}
		System.out.println("");
	}
	public static boolean finalizar(int tropasatc, int tropasdef, String [] territorios, int paisatc, int paisdef, int [][] tauler){
		Scanner lector = new Scanner(System.in);
		System.out.println("");
		System.out.println("A "+territorios[paisatc]+" le quedan "+tropasatc+" tropas");
		System.out.println("A "+territorios[paisdef]+" le quedan "+tropasdef+" tropas");
		System.out.println("");
		tauler [paisatc][1] = tropasatc+1;
		tauler [paisdef][1] = tropasdef;
		String seguir = "";
		if (tropasatc > 0 && tropasdef > 0){
		do{
		System.out.println("Quieres seguir atacando? (S/N)");
		seguir = lector.next();
		if (seguir.equalsIgnoreCase("s")){
			return true;
		}
		else{
			if(seguir.equalsIgnoreCase("n")){
				System.out.println("El combate ha terminado");
				return false;
			}
		}
		}while(!(seguir.equalsIgnoreCase("S") || seguir.equalsIgnoreCase("N")));
		}
		else{
			System.out.println("El combate ha terminado");
			if(tropasdef==0){
				tauler[paisdef][0]=tauler[paisatc][0];
				int numtropasmov = 0;
				do{
				System.out.println("");
				System.out.println("Cuantas tropas quieres poner en "+DamRISK.territoris[paisdef]+"?");
				numtropasmov = lector.nextInt();
				if(numtropasmov<=0){
					System.out.println("Tienes que poner por lo menos 1!");
				}
				if(numtropasmov>tropasatc){
					System.out.println("No tienes tantas tropas!");
				}
				}while(numtropasmov>tropasatc || numtropasmov<=0);
				tauler[paisdef][1]=numtropasmov;
				tauler[paisatc][1]=tauler[paisatc][1]-numtropasmov;
			}
		}
		
		return false;
	}
}


