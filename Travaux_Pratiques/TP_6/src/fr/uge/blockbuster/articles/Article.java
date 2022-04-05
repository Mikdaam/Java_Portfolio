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
	
	void saveInBinary(DataOutputStream output) throws IOException;
	
	static Article fromText(String line) {
		Objects.requireNonNull(line, "string can't be null");
		var components = line.split(":");
		if(components[0].equals(LASER_DISC)) {
			return new LaserDisc(components[1]);
		} else {
			return new VideoTape(components[1], Duration.ofMinutes(Long.parseLong(components[2])));
		}
	}
	
	static Article fromBinary(DataInputStream input) throws IOException {
		Objects.requireNonNull(input, "input can't be null");
		var articleType = input.readByte();
		
		if (articleType == VIDEO_TAPE_BINARY_CODE) {
			var name = input.readUTF();
			var duration = input.readLong();
			return new VideoTape(name, Duration.ofSeconds(duration));
		} else {
			var name = input.readUTF();
			return new LaserDisc(name);
		}
	}
	
}
