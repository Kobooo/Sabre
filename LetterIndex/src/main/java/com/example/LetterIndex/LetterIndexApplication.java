package com.example.LetterIndex;

import com.example.LetterIndex.logic.Indexer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LetterIndexApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LetterIndexApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    //Place for playground
		Indexer indexer = new Indexer();
		indexer.indexWordsToLetters("ala ma kota, kot koduje w Javie Kota");
	}
}
