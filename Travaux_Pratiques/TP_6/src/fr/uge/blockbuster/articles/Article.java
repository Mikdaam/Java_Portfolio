package fr.uge.blockbuster.articles;

import java.time.Duration;
import java.util.Objects;

public sealed interface Article permits LaserDisc, VideoTape {
	
	static final String LASER_DISC = "LaserDisc";
	static final String VIDEO_TAPE = "VideoTape";
	
	String name();
	
	Duration duration();
	
	String toText();
	
	/**
	 * Ce n'est pas probablement la bonne chose à faire
	 * ? A demender au prof
	 * @param line
	 * @return
	 */
	static Article fromText(String line) {
		Objects.requireNonNull(line, "string can't be null");
		var components = line.split(":");
		if(components[0].equals(LASER_DISC)) {
			return new LaserDisc(components[1]);
		} else {
			return new VideoTape(components[1], Duration.ofMinutes(Long.parseLong(components[2])));
		}
	}
	
	default boolean isVideoTape() {
		return false;
	};
	
}
