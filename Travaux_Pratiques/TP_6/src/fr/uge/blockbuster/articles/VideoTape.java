package fr.uge.blockbuster.articles;

import java.time.Duration;
import java.util.Objects;

public record VideoTape(String name, Duration duration) implements Article {
	public VideoTape {
		Objects.requireNonNull(name, "name can't be null");
		Objects.requireNonNull(duration, "duration can't be null");
	}
	
	@Override
	public String toText() {
		return Article.VIDEO_TAPE + ":" + name + ":" + duration.toMinutes();
	}
	
	
	@Override
	public boolean isVideoTape() {
		return true;
	}
}
