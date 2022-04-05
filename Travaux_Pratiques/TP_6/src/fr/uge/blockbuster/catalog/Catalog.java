package fr.uge.blockbuster.catalog;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Objects;

import fr.uge.blockbuster.articles.Article;

public class Catalog {
	private final HashMap<String, Article> catalog;
	
	public Catalog() {
		catalog = new HashMap<>();
	}
	
	public void add(Article article) {
		Objects.requireNonNull(article, "article can't be null");
		if(catalog.getOrDefault(article.name(), null) != null) {
			throw new IllegalArgumentException("article already exists");
		}
		catalog.put(article.name(), article);
	}
	
	public Article lookup(String name) {
		Objects.requireNonNull(name, "name of article can't be null");
		return catalog.get(name);
	}
	
	/**
	 * Yenh, peut êtr pas très bon mon while
	 * ? avoir avec le prof
	 * @param path
	 * @throws IOException
	 */
	public void load(Path path) throws IOException {
		Objects.requireNonNull(path, "path can't be null");
		try(var reader = Files.newBufferedReader(path)) {
			String line;
			while ((line = reader.readLine()) != null) {
				var article = Article.fromText(line);
				catalog.put(article.name(), article);
			}
		}
	}
	
	public void load(Path path, Charset encoding) throws IOException {
		Objects.requireNonNull(path, "path can't be null");
		Objects.requireNonNull(encoding, "encoding can't be null");
		try(var reader = Files.newBufferedReader(path, encoding)) {
			String line;
			while ((line = reader.readLine()) != null) {
				var article = Article.fromText(line);
				catalog.put(article.name(), article);
			}
		}
	}
	
	public void save(Path path) throws IOException {
		Objects.requireNonNull(path, "path can't be null");
		try(var writer = Files.newBufferedWriter(path)) {
			for (var article : catalog.values()) {
				writer.write(article.toText());
				writer.newLine();
			}
		}
	}
	
	public void save(Path path, Charset encoding) throws IOException {
		Objects.requireNonNull(path, "path can't be null");
		Objects.requireNonNull(encoding, "encoding can't be null");
		try(var writer = Files.newBufferedWriter(path, encoding)) {
			for (var article : catalog.values()) {
				writer.write(article.toText());
				writer.newLine();
			}
		}
	}
	
	
}
