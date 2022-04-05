package fr.uge.blockbuster.articles;

import java.io.DataOutputStream;
import java.io.IOException;
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
	public void saveInBinary(DataOutputStream output) throws IOException {
		Objects.requireNonNull(output, "output can't be null");
		
		output.writeByte(Article.LASER_DISC_BINARY_CODE);
		output.writeUTF(name);
	}
	
}
