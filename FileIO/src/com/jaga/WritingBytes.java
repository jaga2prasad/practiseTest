package com.jaga;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.zip.GZIPOutputStream;

public class WritingBytes {
	public static void main(String[] args) {
		File file = new File("files/int.bin.gz");
		try(OutputStream os = new FileOutputStream(file);
				GZIPOutputStream gos = new GZIPOutputStream(os);
				DataOutputStream dos = new DataOutputStream(gos);
				){
			
			//dos.writeInt(10);
			//dos.writeUTF("HELLO");
			IntStream.range(0,1000)
			.forEach(i->{try {
						dos.writeInt(i);
					} catch (Exception e) {
						e.printStackTrace();
					}});
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Path path = Paths.get("files/int.bin.gz");
		try {
			long size = Files.size(path);
			System.out.println(size);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
