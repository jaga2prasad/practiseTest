package com.jaga;

public class A2 {
	public static void main(String[] args) {
		String a = "CISCO IOS IMAGE,";
		String b = "Cisco IOS Software";
		
		String c = "Cisco IOS Software, CSR1000V Software (X86_64_LINUX_IOSD-UNIVERSALK9-M), Version 15.5(3)S2, RELEASE SOFTWARE (fc2)";
		String d = "Cisco IOS Software , CSR1000V Software (X86_64_LINUX_IOSD-UNIVERSALK9-M), Version 15.5(3)S2, RELEASE SOFTWARE (fc2)";
		
		if(c.contains(b))
			System.out.println(b +" is in c");
		
		if(d.contains(b))
			System.out.println(b +" is in d");
		
		if("Cisco IOS Software, ISR Software (X86_64_LINUX_IOSD-UNIVERSAL-M), Version 15.5(3)S0c, RELEASE SOFTWARE (fc1)".contains("Cisco IOS Software,")){
			System.out.println("it contains");
		}
		
		
		//String z = "Voice & Video Voice & Video Voice & Video";
		String z = "";
		System.out.println(z.replaceAll("\\s+", ""));
	}
}
