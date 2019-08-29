package com.jaga;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class ReadingBytes {
	public static void main(String[] args) {
		String fileName = "files/int.bin.gz";
		try(InputStream is = new FileInputStream(new File(fileName));
				GZIPInputStream gzip = new GZIPInputStream(is);
				DataInputStream dis = new DataInputStream(gzip);) {
			
			
			try{
				while(true) {
					System.out.println(dis.readInt());
				}
			}catch(Exception e) {
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
