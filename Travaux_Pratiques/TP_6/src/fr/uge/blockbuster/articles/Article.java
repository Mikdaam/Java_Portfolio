package fr.uge.blockbuster.articles;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

public sealed interface Article permits LaserDisc, VideoTape {
	
	static final String LASER_DISC = "LaserDisc";
	static final String VIDEO_TAPE = "VideoTape";
	static final byte VIDEO_TAPE_BINARY_CODE = 1;
	static final byte LASER_DISC_BINARY_CODE = 2;
	
	String name();
	
	String toText();
	
	static Article fromText(String line) {
		Objects.requireNonNull(line, "string can't be null");
		var components = line.split(":");

		return switch (components[0]) {
		case LASER_DISC -> {
			yield new LaserDisc(components[1]);			
		}
		case VIDEO_TAPE -> {
			yield new VideoTape(components[1], Duration.ofMinutes(Long.parseLong(components[2])));
		}
		default -> 
			throw new IllegalArgumentException("Unexpected article: " + components[0]);
		};
	}
	
	void saveInBinary(DataOutputStream output) throws IOException;
	
	static Article fromBinary(DataInputStream input) throws IOException {
		Objects.requireNonNull(input, "input can't be null");
		var articleType = input.readByte();
		
		return switch (articleType) {
		case VIDEO_TAPE_BINARY_CODE -> {
			var name = input.readUTF();
			var duration = input.readLong();
			yield new VideoTape(name, Duration.ofSeconds(duration));
		}
		case LASER_DISC_BINARY_CODE -> {
			var name = input.readUTF();
			yield new LaserDisc(name);
		}
		default ->
			throw new IllegalArgumentException("Unexpected article: " + articleType);
		};
	}
	
}
