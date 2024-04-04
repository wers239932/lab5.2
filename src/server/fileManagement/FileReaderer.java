package server.fileManagement;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileReaderer extends LineReader{
    void openFile() throws FileNotFoundException;


    String readLine() throws IOException;

    void closeStream() throws IOException;
}
