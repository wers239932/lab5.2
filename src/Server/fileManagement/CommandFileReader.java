package Server.fileManagement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * считывает строки из файла для перевода в команды
 */
public class CommandFileReader implements FileReaderer{
    private FileReader reader;
    String scriptName;
    public CommandFileReader(String scriptName) {
        this.scriptName=scriptName;
    }

    /**
     *
     * @throws FileNotFoundException
     */
    @Override
    public void openFile() throws FileNotFoundException {
        this.reader=new FileReader(scriptName);
    }

    /**
     * @return
     * @throws IOException
     */
    @Override
    public String readLine() throws IOException {
        String str = null;
        int ch = this.reader.read();
        if (ch != -1) str = "";

        while (ch != (int)'\r' && ch != -1) {

            if(ch != (int)'\n') {
                str += (char) ch;
            }
            else if(!str.equals("")) {
                break;
            }
            ch = this.reader.read();

        }
        return str;
    }

    /**
     * @throws IOException
     */
    @Override
    public void closeStream() throws IOException {
        reader.close();
    }
}
