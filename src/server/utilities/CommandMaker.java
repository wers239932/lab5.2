package server.utilities;

import ui.Terminal;
import server.commands.*;
import server.fileManagement.LineReader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * наполняет команду необходимым содержимым: память, терминал, другие параметры
 */
public class CommandMaker {
    LineReader lineReader;
    private final Terminal terminal;
    private final ArrayList<String> command;
    private final CommandExecuter commandExecuter;

    public CommandMaker(Terminal terminal, LineReader lineReader, CommandExecuter commandExecuter){
        command=new ArrayList<>();
        this.terminal=terminal;
        this.lineReader=lineReader;
        this.commandExecuter=commandExecuter;
    }
    public void addParams(Command command)
    {
        if(command instanceof CommandUsingCommandExecuter)
        {
            command.addCommandExecuter(this.commandExecuter);
        }
        if(command instanceof CommandUsingStorage)
        {
            command.addStorage(this.commandExecuter.getStorage());
        }
        if(command instanceof CommandUsingTerminal)
        {
            command.addTerminal(terminal);
        }

            /*
            ArrayList<String> args = new ArrayList<String>();
            Boolean fileEmpty = false;

            Boolean checker = false;
            String arg = "";
            this.terminal.writeLine("введите название города");

            arg = this.lineReader.readLine();
            if (arg==null) fileEmpty=true;
            String name=arg;
            while (checker && !fileEmpty)
            {
                checker=false;
                try {
                    arg = this.lineReader.readLine();
                    if (arg==null) fileEmpty=true;
                    if(name.equals("")) checker=true;
                } catch (NumberFormatException e) {
                    checker=true;
                }
            }
            args.add(arg);

            checker = false;
            arg = "";
            this.terminal.writeLine("введите число в формате float, первую координату");

            arg = this.lineReader.readLine();
            if (arg==null) fileEmpty=true;
            float x = 0;
            try {
                 x = Float.parseFloat(arg);
            } catch (NumberFormatException e) {
                checker=true;
            }
            while (checker && !fileEmpty)
            {
                checker=false;
                try {
                    arg = this.lineReader.readLine();
                    if (arg==null) fileEmpty=true;
                     x = Float.parseFloat(arg);
                } catch (NumberFormatException e) {
                    checker=true;
                }
            }
            args.add(arg);

            checker = false;
            arg = "";
            this.terminal.writeLine("введите число в формате long, вторую координату");
            arg = this.lineReader.readLine();
            if (arg==null) fileEmpty=true;
            long y = 0;
            try {
                y = Long.parseLong(arg);
            } catch (NumberFormatException e) {
                checker=true;
            }
            while (checker && !fileEmpty)
            {
                checker=false;
                try {
                    arg = this.lineReader.readLine();
                    if (arg==null) fileEmpty=true;
                    y = Long.parseLong(arg);
                } catch (NumberFormatException e) {
                    checker=true;
                }
            }
            args.add(arg);

            checker = false;
            arg = "";
            this.terminal.writeLine("введите площадь в формате Long, площадь должна быть больше 0");
            arg = this.lineReader.readLine();
            if (arg==null) fileEmpty=true;
            Long area = null;
            try {
                area = Long.parseLong(arg);
                if(area<=0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                checker=true;
            }
            while (checker && !fileEmpty)
            {
                checker=false;
                try {
                    arg = this.lineReader.readLine();
                    if (arg==null) fileEmpty=true;
                    area = Long.parseLong(arg);
                    if(area<=0) throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    checker=true;
                }
            }
            args.add(arg);

            checker = false;
            arg = "";
            this.terminal.writeLine("введите население, должно быть больше 0");
            arg = this.lineReader.readLine();
            if (arg==null) fileEmpty=true;
            int population = 0;
            try {
                population = Integer.parseInt(arg);
                if(population<=0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                checker=true;
            }
            while (checker && !fileEmpty)
            {
                checker=false;
                try {
                    arg = this.lineReader.readLine();
                    if (arg==null) fileEmpty=true;
                    population = Integer.parseInt(arg);
                    if(population<=0) throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    checker=true;
                }
            }
            args.add(arg);

            checker = false;
            arg = "";
            this.terminal.writeLine("введите высоту над уровнем моря в формате double");
            arg = this.lineReader.readLine();
            if (arg==null) fileEmpty=true;
            double deep = 0;
            try {
                deep = Double.parseDouble(arg);
            } catch (NumberFormatException e) {
                checker=true;
            }
            while (checker && !fileEmpty)
            {
                checker=false;
                try {
                    arg = this.lineReader.readLine();
                    if (arg==null) fileEmpty=true;
                    population = Integer.parseInt(arg);
                } catch (NumberFormatException e) {
                    checker=true;
                }
            }
            args.add(arg);


            checker = false;
            arg = "";
            this.terminal.writeLine("введите true если у города есть столица, что угодно другое в ином случае");
            arg = this.lineReader.readLine();
            if (arg==null) fileEmpty=true;
            Boolean capital = null;
            try {
                capital = Boolean.parseBoolean(arg);
            } catch (NumberFormatException e) {
                checker=true;
            }
            while (checker && !fileEmpty)
            {
                checker=false;
                try {
                    arg = this.lineReader.readLine();
                    if (arg==null) fileEmpty=true;
                    capital = Boolean.parseBoolean(arg);
                } catch (NumberFormatException e) {
                    checker=true;
                }
            }
            args.add(arg);

            checker = false;
            arg = "";
            this.terminal.writeLine("введите carCode - целое число от 0 до 1000");
            arg = this.lineReader.readLine();
            if (arg==null) fileEmpty=true;
            Long carCode = null;
            try {
                carCode = Long.parseLong(arg);
                if(carCode<=0 || carCode>1000) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                checker=true;
            }
            while (checker && !fileEmpty)
            {
                checker=false;
                try {
                    arg = this.lineReader.readLine();
                    if (arg==null) fileEmpty=true;
                    carCode = Long.parseLong(arg);
                    if(carCode<=0 || carCode>1000) throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    checker=true;
                }
            }
            args.add(arg);

            checker = false;
            arg = "";
            this.terminal.writeLine("введите тип правительства: KLEPTOCRACY, CORPORATOCRACY или PATRIARCHY");
            arg = this.lineReader.readLine();
            if (arg==null) fileEmpty=true;
            Government government = null;
            try {
                government = Government.valueOf(arg);
            } catch (IllegalArgumentException e) {
                checker=true;
            }
            while (checker && !fileEmpty)
            {
                checker=false;
                try {
                    arg = this.lineReader.readLine();
                    if (arg==null) fileEmpty=true;
                    government = Government.valueOf(arg);
                } catch (IllegalArgumentException e) {
                    checker=true;
                }
            }
            args.add(arg);

            checker = false;
            arg = "";
            this.terminal.writeLine("введите дату в формате yyyy-MM-dd HH:mm:ss ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            arg = this.lineReader.readLine();
            if (arg==null) fileEmpty=true;
            LocalDateTime date = null;
            try {
                date = LocalDateTime.parse(arg,formatter);
            } catch (Exception e) {
                checker=true;
            }
            while (checker && !fileEmpty)
            {
                checker=false;
                try {
                    arg = this.lineReader.readLine();
                    if (arg==null) fileEmpty=true;
                    date = LocalDateTime.parse(arg,formatter);
                } catch (Exception e) {
                    checker=true;
                }
            }
            args.add(arg);
            City city =new City(name,new Coordinates(x,y),area,population,deep,capital,carCode,government,new Human(date));
            command.addObject(city);
            System.out.println("введен объект:  " + city.toString());
             */


    }
    private String getArgumentWithRules(String msg, ArgumentChecker<String> checker) throws IOException {
        String arg = "";
        this.terminal.writeLine(msg);
        arg = this.lineReader.readLine();
        while (!checker.check(arg)){

            this.terminal.writeLine("Неверный формат ввода. Попробуйте еще раз.");
            this.terminal.writeLine(msg);
            arg = this.lineReader.readLine();
        }
        return arg;
    }
}
