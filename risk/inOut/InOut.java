package inOut;
import risk.DamRISK;
import java.util.Scanner;

public class InOut {

	public static void mostrarTauler(int tauler[][], String nomsJugadors[]) {
		System.out.println("");
		System.out.println("Asi queda el tablero:");
		for(int territori=0;territori<tauler.length;territori++){
			System.out.println(DamRISK.territoris[territori]+"-"+nomsJugadors[tauler[territori][0]]+"-"+tauler[territori][1]);
		}
	}
	public static void mostrarTerritoris(String paisjugador[]) {
		for (int i = 0; i < paisjugador.length; i++) {
			System.out.print(paisjugador[i]+", ");
		}
	}
	public static void mostrarTropas(int tauler[][],int jugador) {
		System.out.println("");
		System.out.println("Asi estan distribuidas tus tropas:");
		System.out.println("");
		for(int territori=0;territori<tauler.length;territori++){
			if(tauler[territori][0]==jugador){
			System.out.println(DamRISK.territoris[territori]+"- Tropas - "+tauler[territori][1]);
			}
			}
	}
	public static void printGuanyador(int tauler[][],int torn,String[] nomJugadors){
		System.out.println("El guanyador es "+nomJugadors[(torn)]);
	}
	public static void printTerritorisAtacables(int[][] tauler,int torn){
		System.out.println("Estos son tus territorios y los posibles objetivos:");
		System.out.println("");
		for (int i = 0; i < tauler.length; i++) {
			if (tauler[i][0]==torn){
				System.out.println(DamRISK.territoris[i]+" - Tropas:"+tauler[i][1]);
				for (int j = 0; j < DamRISK.veins[i].length; j++) {
					if (tauler[DamRISK.veins[i][j]][0]!=torn){
					System.out.println("      "+DamRISK.territoris[DamRISK.veins[i][j]]+" - Tropas: "+tauler[DamRISK.veins[i][j]][1]);
					}
				}
				System.out.println("");
			}
		}
	}
	public static void printTerritorisVecinos(int[][] tauler,int torn){
		System.out.println("Estos son tus territorios y sus vecinos aliados:");
		System.out.println("");
		for (int i = 0; i < tauler.length; i++) {
			if (tauler[i][0]==torn){
				System.out.println(DamRISK.territoris[i]+" - Tropas:"+tauler[i][1]);
				for (int j = 0; j < DamRISK.veins[i].length; j++) {
					if (tauler[DamRISK.veins[i][j]][0]==torn){
					System.out.println("      "+DamRISK.territoris[DamRISK.veins[i][j]]+" - Tropas: "+tauler[DamRISK.veins[i][j]][1]);
					}
				}
				System.out.println("");
			}
		}
	}
}
