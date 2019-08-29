package com.jaga;

import java.io.FileInputStream;
import java.io.InputStream;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

public class Test {
	public static void main(String[] args) {
		try {
			new Test().sentenceDetect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sentenceDetect() throws Exception{
		String paragraph = "Apache openNLP supports the most common NLP tasks, such as tokenization, sentence segmentation, part-of-speech tagging, named entity extraction, chunking, parsing, and coreference resolution. These tasks are usually required to build more advanced text processing services. OpenNLP also includes maximum entropy and perceptron based machine learning.";
		InputStream in = new FileInputStream("en-sent.bin");
		SentenceModel model = new SentenceModel(in);
		
		SentenceDetectorME sDetect = new SentenceDetectorME(model);
		
		//String paragraph = "jaga is jaga is jaga is jaga";
		String sentences[] = sDetect.sentDetect(paragraph);
		
		for(String words : sentences){
			System.out.println(words);
		}
		
//		for(int i=0;i<sentences.length;i++){
//            System.out.println(sentences[i]);
//        }
		
		in.close();
		
	}
}
