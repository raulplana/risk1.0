package judge;
import risk.DamRISK;
import utils.Utils;

import java.util.Scanner;

import inOut.InOut;

public class Judge {
	public static int primeraAsig(int tauler[][],int jugador,int tropasactuales){
		Scanner lector = new Scanner(System.in);
		System.out.println("");
		System.out.println("PRIMERA ASIGNACION");
		System.out.println("");
		for (int i = 0; i < tauler.length; i++) {
			if (tropasactuales==0){
				System.out.println("No te quedan tropas para repartir!");
				break;
			}
			else{
			if (tauler[i][0]==jugador){
			String numtropstr;
			int numtrop;
			do{
			do{
			System.out.println("Te quedan "+tropasactuales+" tropas.");
				System.out.print("Cuantas tropas quieres poner en "+DamRISK.territoris[i]+"?");
			numtropstr = lector.next();
			}while(Utils.comprobarNum(numtropstr));
			numtrop = Integer.parseInt(numtropstr);
			if(numtrop>tropasactuales){
				System.out.println("no tienes tantas tropas!");
			}
			}while(numtrop>tropasactuales);
			tauler[i][1]= tauler[i][1] + numtrop;
			tropasactuales = tropasactuales - numtrop;
			}
			}
		}
		return tropasactuales;
	}
	public static void Repartir(int numJugadors, int tauler[][],int jugador, int paisesJugador){
		if (numJugadors-jugador==1){
			for (int i = 0; i < tauler.length; i++) {
				if (tauler[i][0]==-1){
					tauler[i][0]=jugador;
					tauler[i][1]=1;
				}
			}
		}
		else{
		if (numJugadors != 4 && numJugadors != 5){
		for (int i = 0; i < paisesJugador; i++) {
			int pais;
			do{
			pais = Utils.randomizer(41);
			}while(tauler[pais][0] != -1);
			tauler[pais][0] = jugador;
			tauler[pais][1] = 1;
		}
		}
		else{
			if(numJugadors-jugador <= 2){
			for (int i = 0; i < paisesJugador+1; i++) {
				int pais;
				do{
				pais = Utils.randomizer(41);
				}while(tauler[pais][0] != -1);
				tauler[pais][0] = jugador;
				tauler[pais][1] = 1;
			}
			}
			else{
				for (int i = 0; i < paisesJugador; i++) {
					int pais;
					do{
					pais = Utils.randomizer(41);
					}while(tauler[pais][0] != -1);
					tauler[pais][0] = jugador;
					tauler[pais][1] = 1;
			}
			}
		}
		}
	}
	public static int asignarTropas(int tauler[][], String aspais, int acierto, boolean correcto, int numex, String paisjugador[], int tropasactuales){
		Scanner lector = new Scanner(System.in);
		acierto = -2;
		correcto = false;
		numex = 0;
		System.out.println("En que territorio quieres poner tropas?");
		aspais = lector.nextLine();
		for (int i = 0; i < paisjugador.length; i++) {
			if (aspais.equalsIgnoreCase(paisjugador[i])){
				acierto= i;
			}
		}
		if (acierto != -2){
			do{
			System.out.println("Cuantos ejercitos quieres poner?");
			numex = lector.nextInt();
			if (numex<=tropasactuales){
				correcto = true;
				for (int i = 0; i < tauler.length; i++) {
					if (aspais.equalsIgnoreCase(DamRISK.territoris[i])){
						tauler[i][1] = tauler[i][1] + numex; 
						tropasactuales = tropasactuales - numex;
						acierto= i;
					}
				} 
			}
			else{
				System.out.println("No tienes tantas tropas!");
			}
			}while(correcto == false);
		}
		else{
			System.out.println("Ese territorio no es tuyo o no existe!");
		}
		return tropasactuales;
	}
	public static int retirarTropas(int tauler[][], String aspais, int acierto, boolean correcto, int numex, String paisjugador[], int tropasactuales){
		Scanner lector = new Scanner(System.in);
		acierto = -2;
		correcto = false;
		numex = 0;
		System.out.println("De que territorio quieres quitar tropas?");
		aspais = lector.nextLine();
		for (int i = 0; i < paisjugador.length; i++) {
			if (aspais.equalsIgnoreCase(paisjugador[i])){
				acierto= i;
			}
		}
		if (acierto != -2){
			do{
			System.out.println("Cuantos ejercitos quieres quitar?");
			numex = lector.nextInt();
			for (int i = 0; i < tauler.length; i++) {
				if (aspais.equalsIgnoreCase(DamRISK.territoris[i])){
					if(tauler[i][1] == 1){
					correcto = true;
					break;
					}
					else{
						if (aspais.equalsIgnoreCase(DamRISK.territoris[i]) && tauler[i][1]>numex){
							tauler[i][1] = tauler[i][1] - numex;
							tropasactuales= tropasactuales + numex; 
							acierto= i;
							correcto = true;
						}
						else{
							System.out.println("No puedes retirar tantas tropas (tiene que haber 1 en cada territorio)");
						}
					}
			} 
			}
			}while(correcto == false);
			}
		
		else{
			System.out.println("Ese territorio no es tuyo o no existe!");
		}
		return tropasactuales;
	}
	public static int pasarTurno(int torn,int numJugadors){
		switch (numJugadors){
		case 3:
			if (torn<2){
				torn++;
			}
			else{
				torn = 0;
			}
			break;
		case 4:
			if (torn<3){
				torn++;
				torn = 0;
			}
			break;
		case 5:
			if (torn<4){
				torn++;
				torn = 0;
			}
			break;
		case 6:
			if (torn<5){
				torn++;
				torn = 0;
			}
			break;
		}
		return torn;
	}
	public static int calcularTropesAfegides(int [][] tauler,int torn){
		int numpaises = 0;
		for (int i = 0; i < tauler.length; i++) {
			if(tauler[i][0]==torn){
				numpaises++;
			}
		}
		numpaises = (int)Math.floor(numpaises/3);
		return numpaises;
	}
	public static int asignarTropas2(int tauler[][], int torn, int tropasactuales){
	Scanner lector = new Scanner(System.in);
	int acierto = -2;
	boolean correcto = false;
	int numex = 0;
	System.out.println("Tienes "+tropasactuales+" tropas por poner.");
	System.out.println("En que territorio quieres poner tropas?");
	String aspais = lector.nextLine();
	for (int i = 0; i < tauler.length; i++) {
		if (aspais.equalsIgnoreCase(DamRISK.territoris[i]) && tauler[i][0]==torn){
			acierto= i;
		}
	}
	if (acierto != -2){
		do{
		System.out.println("Cuantos ejercitos quieres poner?");
		numex = lector.nextInt();
		if (numex<=tropasactuales){
			correcto = true;
			for (int i = 0; i < tauler.length; i++) {
				if (aspais.equalsIgnoreCase(DamRISK.territoris[i])){
					tauler[i][1] = tauler[i][1] + numex; 
					tropasactuales = tropasactuales - numex;
					acierto= i;
				}
			} 
		}
		else{
			System.out.println("No tienes tantas tropas!");
		}
		}while(correcto == false);
	}
	else{
		System.out.println("Ese territorio no es tuyo o no existe!");
	}
	return tropasactuales;
}
	public static void atacar(int[][] tauler,int torn){
		Scanner lector = new Scanner(System.in);
		//Entrar pais origen y comprobar si es correcto
		boolean paiscorrecto = false;
		String paisorigen;
		String paisdestino;
		int paisog = 0;
		int paisde = 0;
		int numtropasorigen = 0;
		int numtropasdestino = 0;
		do{
		System.out.println("Desde que pais quieres atacar?");
		paisorigen = lector.nextLine();
		for (int i = 0; i < tauler.length; i++) {
			if (paisorigen.equalsIgnoreCase(DamRISK.territoris[i]) && tauler[i][0]==torn && tauler[i][1]>1){
				numtropasorigen = tauler [i][1];
				paisog = i;
				paiscorrecto = true;
			}
		}
		if (!paiscorrecto) {
			System.out.println("Ese pais no existe, no es tuyo o no tiene suficientes tropas!");
			System.out.println("");
		}
		}while(!paiscorrecto);
		
		 System.out.println("Tienes "+numtropasorigen+" tropas, asi que atacaras con "+(numtropasorigen-1));
		
		 // Entrar pais destino y comprobar si es correcto
		 paiscorrecto = false;
		 do{
				System.out.println("A que pais quieres atacar?");
				paisdestino = lector.nextLine();
				for (int i = 0; i < tauler.length; i++) {
					if(paisdestino.equalsIgnoreCase(DamRISK.territoris[i]) && tauler[i][0]!=torn){
					for (int j = 0; j < DamRISK.veins[i].length; j++) {
					if (DamRISK.veins[i][j]==paisog){
						numtropasdestino = tauler [i][1];
						paisde = i;
						paiscorrecto = true;
					}
					}
					}
				}
				if (!paiscorrecto) {
					System.out.println("Ese pais no existe o no es un posible objetivo!");
					System.out.println("");
				}
				}while(!paiscorrecto);
		 System.out.println("El defensor tiene "+numtropasdestino+" tropas.");
		
		 //realizar tirada de dados
		tiradaDados.tiradaDados(numtropasdestino, numtropasorigen, paisde, paisog, tauler);
		
		//TODO
		
	}
	public static void redistribuirTropes(int[][] tauler,int torn){
		Scanner lector = new Scanner(System.in);
		System.out.println("");
		System.out.println("De que pais quieres quitar tropas?");
		String pais = lector.nextLine();
		String pais2 = "";
		int paisint = 0;
		int paisint2 = 0;
		boolean correcto = false;
		for (int i = 0; i < tauler.length; i++) {
			if(pais.equalsIgnoreCase(DamRISK.territoris[i]) && tauler[i][0]==torn && tauler[i][1]>1){
				correcto = true;
				paisint=i;
			}
		}
		if (correcto){
			boolean correcto2 = false;
			int tropasMove;
			do{
			System.out.println("Cuantas tropas quieres mover?");
			tropasMove = lector.nextInt();
			if (tropasMove>=tauler[paisint][1] || tropasMove<=0){
				correcto2 = false;
				System.out.println("No hay tantas tropas en ese territorio o has puesto menos de 1!");
			}
			else{
				correcto2 = true;
			}
			}while(!correcto2);
			do{
			correcto2 = false;
			System.out.println("A que pais quieres mover tropas?");
			lector.nextLine();
			pais2 = lector.nextLine();
			for (int i = 0; i < tauler.length; i++) {
				if(pais2.equalsIgnoreCase(DamRISK.territoris[i]) && tauler[i][0]==torn){
					paisint2 = i;
					for (int j = 0; j < DamRISK.veins[paisint].length; j++) {
						if (paisint2==DamRISK.veins[paisint][j]){
							correcto2 = true;
							System.out.println("Se mueven "+tropasMove+" tropas de "+DamRISK.territoris[paisint]+" a "+DamRISK.territoris[paisint2]);
							tauler[paisint][1] = tauler[paisint][1] - tropasMove;
							tauler[paisint2][1]= tauler[paisint2][1] + tropasMove;
						}
					}
				} 
			}
			if (!correcto2){
				System.out.println("Ese pais no existe, no es tuyo o no es vecino del primer pais introducido!");
			}
			}while(!correcto2);
		}
		else{
			System.out.println("El pais no existe, no es tuyo o no tiene suficientes tropas");
		}
		System.out.println(" ");
	}
	public static boolean hiHaGuanyador(int[][] tauler,int[][] infoJugadors){
		for (int i = 0; i < infoJugadors.length; i++) {
			int paisescount = 0;
			for (int j = 0; j < tauler.length; j++) {
				if (tauler[j][0]==i){
					paisescount++;
				}
			}
			if(paisescount==tauler.length){
				return true;
			}
		}
		return false;
	}	
}
