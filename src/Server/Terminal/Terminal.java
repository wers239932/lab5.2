package Server.Terminal;

import Server.FileManagement.FileReaderer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Terminal implements FileReaderer {
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
    public void openFile() throws FileNotFoundException {

    }

    @Override
    public String readLine()
    {
        return this.sc.nextLine();
    }

    /**
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        sc.close();
    }


}
