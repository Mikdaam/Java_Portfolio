package fr.uge.blockbuster.articles;

import java.time.Duration;
import java.util.Objects;

public record LaserDisc(String name) implements Article {
	public LaserDisc {
		Objects.requireNonNull(name, "name can't be null");
	}
	
	@Override
	public String toText() {
		return Article.LASER_DISC + ":" + name;
	}
	
	@Override
	public Duration duration() {
		return Duration.ofMillis(0);
	}
}
