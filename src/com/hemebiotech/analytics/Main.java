package com.hemebiotech.analytics;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ReaderCounter symptoms = new ReaderCounter("symptoms.txt");
		symptoms.GetList();
		symptoms.WriteList();
	}
}