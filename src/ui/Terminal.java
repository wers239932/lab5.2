package ui;

import server.fileManagement.LineReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * терминал, ввод и вывод текста
 */
public class Terminal implements LineReader {
    public Boolean running;
    private final Scanner sc;
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
