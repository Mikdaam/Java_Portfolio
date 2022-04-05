# Pratical Exercices N° 6 - Debriefing

1. **Write `VideoTape` and `LaserDisc`**

```java
package fr.uge.blockbuster.articles;

import java.time.Duration;
import java.util.Objects;

public record VideoTape(String name, Duration duration) implements Article {
	public VideoTape {
		Objects.requireNonNull(name, "name can't be null");
		Objects.requireNonNull(duration, "duration can't be null");
	}
}
```

```java
package fr.uge.blockbuster.articles;

import java.time.Duration;
import java.util.Objects;

public record LaserDisc(String name) implements Article {
	public LaserDisc {
		Objects.requireNonNull(name, "name can't be null");
	}
}
```

2. **Write `Catalog` class**

```java
package fr.uge.blockbuster.catalog;


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

}
```

#### Add a common type `Article`
```java
package fr.uge.blockbuster.articles;

import java.time.Duration;
import java.util.Objects;

public sealed interface Article permits LaserDisc, VideoTape {
	
	String name();

}
```

3. **Write `fromText()` and `toTest()` method**
```java
package fr.uge.blockbuster.articles;

import java.time.Duration;
import java.util.Objects;

public sealed interface Article permits LaserDisc, VideoTape {
	...

    String toText();

	static Article fromText(String line) {
		Objects.requireNonNull(line, "string can't be null");
		var components = line.split(":");
		if(components[0].equals(LASER_DISC)) {
			return new LaserDisc(components[1]);
		} else {
			return new VideoTape(components[1], Duration.ofMinutes(Long.parseLong(components[2])));
		}
	}
}
```

4. **Write `save()` and `load()` methods.**

```java
public class Catalog {
	...
    public void save(Path path) throws IOException {
		Objects.requireNonNull(path, "path can't be null");
		try(var writer = Files.newBufferedWriter(path)) {
			for (var article : catalog.values()) {
				writer.write(article.toText());
				writer.newLine();
			}
		}
	}

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
}
```

5. **Write an overload of `save()` and `load()` methods**
```java
public class Catalog {
	...
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
				catalog.put(article.name(), article);
			}
		}
	}
	
	public void save(Path path) throws IOException {
		Objects.requireNonNull(path, "path can't be null");
		load(path, StandardCharsets.UTF_8);
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
```

