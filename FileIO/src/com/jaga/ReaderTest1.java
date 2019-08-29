package com.jaga;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReaderTest1 {
	public static void main(String[] args) {
		File file = new File("files/jaga.txt");
		try(Reader reader = new FileReader(file);) {
			BufferedReader br = new BufferedReader(reader);
			String line = br.readLine();
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Path path = Paths.get("files/jaga.txt");
		try(BufferedReader br = Files.newBufferedReader(path,StandardCharsets.UTF_8);) {
			String line = br.readLine();
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}catch(IOException e) {
			
		}
		
		try(BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
			while(br.readLine() != null) {
				System.out.println(br.readLine());
				//br.readLine() = br.readLine();
			}
		}catch(IOException e) {
			
		}
	}
}
