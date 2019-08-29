package com.jaga;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReaderTest3 {
	public static void main(String[] args) {
		Path path = Paths.get("files/p.txt");
		try{
			BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,StandardOpenOption.WRITE);
			PrintWriter pw = new PrintWriter(writer);
			pw.println("Hello World!");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
