package com.jaga;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.stream.IntStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipFiles {
	public static void main(String[] args) {
		String fileName = "files/archive.zip";
		try(OutputStream os = new FileOutputStream(new File(fileName));
			ZipOutputStream zos = new ZipOutputStream(os);
			DataOutputStream dos = new DataOutputStream(zos);
				){
			
			ZipEntry dirEntry = new ZipEntry("bin/");
			zos.putNextEntry(dirEntry);
			ZipEntry fileEntry = new ZipEntry("bin/int.bin");
			zos.putNextEntry(fileEntry);
			
			IntStream.range(0,1000)
			.forEach(i->{try {
						dos.writeInt(i);
					} catch (Exception e) {
						e.printStackTrace();
					}});
			
			ZipEntry dirEntry1 = new ZipEntry("file/");
			zos.putNextEntry(dirEntry1);
			ZipEntry fileEntry1 = new ZipEntry("file/some.txt");
			zos.putNextEntry(fileEntry1);
			
			dos.writeUTF("This is jaga");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
