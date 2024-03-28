package Server.Terminal;

import Server.FileManagement.FileReaderer;
import Server.FileManagement.LineReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Terminal implements LineReader {
    public Boolean running;
    private Scanner sc;
    public void writeLine(String line)
    {
        System.out.println(line);
    }
    public Terminal()
    {

        this.running=true;
        this.sc=new Scanner(System.in);
    }

    /**
     * @throws FileNotFoundException
     */


    @Override
    public String readLine()
    {
        return this.sc.nextLine();
    }

    /**
     * @throws IOException
     */
    @Override
    public void closeStream() throws IOException {
        sc.close();
    }


}
