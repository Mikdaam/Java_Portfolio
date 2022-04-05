/**
 * @author Mick Cool
 * @version v1
 */
package fr.uge.blockbuster.articles;

import java.io.DataOutputStream;
import java.io.IOException;
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
	public void saveInBinary(DataOutputStream output) throws IOException {
		Objects.requireNonNull(output, "output can't be null");
		
		output.writeByte(Article.VIDEO_TAPE_BINARY_CODE);
		output.writeUTF(name);
		output.writeLong(duration.toSeconds());
	}
	
}
