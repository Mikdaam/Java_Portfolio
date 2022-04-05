package fr.uge.blockbuster.catalog;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
		if(catalog.putIfAbsent(article.name(), article) != null) {
			throw new IllegalStateException("article already exists");
		}
	}
	
	public Article lookup(String name) {
		Objects.requireNonNull(name, "name of article can't be null");
		return catalog.get(name);
	}
	
	public void load(Path path) throws IOException {
		Objects.requireNonNull(path, "path can't be null");
		load(path, StandardCharsets.UTF_8);
	}
	
	public void load(Path path, Charset encoding) throws IOException {
		Objects.requireNonNull(path, "path can't be null");
		Objects.requireNonNull(encoding, "encoding can't be null");
		try(var reader = Files.newBufferedReader(path, encoding)) {
			String line;
			while ((line = reader.readLine()) != null) {
				var article = Article.fromText(line);
				this.add(article);
			}
		}
	}
	
	public void save(Path path) throws IOException {
		Objects.requireNonNull(path, "path can't be null");
		save(path, StandardCharsets.UTF_8);
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
	
	public void loadFromBinary(Path path) throws IOException {
		Objects.requireNonNull(path, "path can't be null");
		try(var binaryReader = new DataInputStream(Files.newInputStream(path))) {
			var articlesNumber = binaryReader.readInt();
			
			for (int i = 0; i < articlesNumber; i++) {
				var article = Article.fromBinary(binaryReader);
				
				this.add(article);
			}
		}
	}
	
	public void saveInBinary(Path path) throws IOException {
		Objects.requireNonNull(path, "path can't be null");
		try(var binaryWriter = new DataOutputStream(Files.newOutputStream(path))) {
			binaryWriter.writeInt(catalog.size()); // Save the number of articles in catalog

			for (var article : catalog.values()) {
				article.saveInBinary(binaryWriter);
			}
		}
	}
}
