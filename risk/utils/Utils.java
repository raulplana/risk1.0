package utils;
import risk.DamRISK;

import java.util.Random;
import java.util.Scanner;
public class Utils {

	public static int randomizer(int num){
		Random rdn = new Random();
		int numerorandom = rdn.nextInt(num);
		return numerorandom;
	}
	public static boolean comprobarNum(String a) {
		if (a == null || a.isEmpty()){
			System.out.println("Tiene que ser un numero! introduce otra vez");
			return true;
		}
		int i = 0;
		if (a.charAt(0) == '-'){
			if (a.length() > 1){
				i++;
			} else {
				System.out.println("Tiene que ser un numero! introduce otra vez");
				return true;
			}
		}
		for (; i < a.length(); i++) {
			if (!Character.isDigit(a.charAt(i))){
				System.out.println("Tiene que ser un numero! introduce otra vez");
				return true;
			}
		}
	    	return false;
	}

}
