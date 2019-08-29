package com.jaga;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ReadingZipFiles {
	public static void main(String[] args) {
		String fileName = "files/archive.zip";
		try(InputStream is = new FileInputStream(new File(fileName));
			ZipInputStream zis = new ZipInputStream(is);
			DataInputStream dis = new DataInputStream(zis);
		){
			ZipEntry  file = zis.getNextEntry();
			while(file != null) {
				if(file.isDirectory()) {
					System.out.println(file);
				}else{
					if(file.getName().endsWith(".bin")) {
//						while(true) {
//							try{
//							System.out.println(dis.readInt());
//							}catch(EOFException e) {
//								//e.printStackTrace();
//							}
//						}
					}else {
						System.out.println(dis.readUTF());
					}
				}
				file = zis.getNextEntry();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
