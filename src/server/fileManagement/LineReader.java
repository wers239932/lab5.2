package server.fileManagement;

import java.io.IOException;

public interface LineReader {
    String readLine() throws IOException;
    void closeStream() throws IOException;
}
