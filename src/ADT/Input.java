package ADT;

import java.io.IOException;
import java.util.List;

public interface Input {
	int readInput(List<String> inputLines, List<String> ignoreWords) throws IOException;
}
