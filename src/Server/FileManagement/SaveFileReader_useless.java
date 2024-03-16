package Server.FileManagement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SaveFileReader_useless implements FileReaderer{


    FileReader reader;
    public SaveFileReader_useless() {}

    /*@Override*/
    public void openFile(String filename) throws FileNotFoundException {
        this.reader=new FileReader(filename);
    }

    /**
     * @throws FileNotFoundException
     */
    @Override
    public void openFile() throws FileNotFoundException {

    }

    @Override
    public String readLine() throws IOException {
        int ch;
        ch=reader.read();
        String line ="";
        while(ch!=-1)
        {
            if(ch==(int)'\n')
            {
                return line;
            }
            else {
                line+=ch;
            }
        }
        return null;
    }

    public ArrayList<String> getArgs() throws IOException {
        ArrayList<String> args = new ArrayList<String>();
        for(int i=0;i<10;i++)
        {
            args.add(readLine());
        }
        return args;
    }
    @Override
    public void close() throws IOException {
        reader.close();
    }
}
