package com.yoganakaar;

import java.util.ArrayList;
import java.util.Collection;

public class Generics{

	void printCollection(Collection<? extends String> c) {
	    Collection<? super Integer> c1 = null;
	    c1.add(2);
	    //c1.add(new Object());
		for (String e : c) {
	        System.out.println(e);
	    }
	}
	private static int roundUpToPowerOfTwo(int i) {
		         i--; // If input is a power of two, shift its high-order bit right
		         // "Smear" the high-order bit all the way to the right
		         i |= i >>>  1;
		         i |= i >>>  2;
		         i |= i >>>  4;
		         i |= i >>>  8;
		         i |= i >>> 16;
		 
		         return i + 1;
		     }
	
	private static int nextPowerOf2(int i){
		i--;
		i = ~i;
		i = i >>> 1;
		return i+1;
	}
	
	public static void main(String[] args) {
		System.out.println(roundUpToPowerOfTwo(8));
		System.out.println(nextPowerOf2(9));
	}
		 

}
