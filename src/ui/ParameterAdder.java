package ui;

import objectSpace.*;
import server.commands.*;
import server.fileManagement.LineReader;
import server.utilities.ArgumentChecker;
import server.utilities.ArgumentValidator;
import objectSpace.exceptions.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * наполняет команду необходимым содержимым: память, терминал, другие параметры
 */
public class ParameterAdder {
    LineReader lineReader;
    private final Terminal terminal;

    public ParameterAdder(Terminal terminal, LineReader lineReader){
        this.terminal=terminal;
        this.lineReader=lineReader;
    }
    public void addParams(Command command, ArrayList<String> commandContents) throws CoordinatesException, AreaException, GovernmentException, GovernorException, HeightException, CarCodeException, PopulationException, NameCityException, CapitalException, IOException {

        if(command instanceof CommandUsingLine)
        {
            command.addParam(commandContents.get(0));
        }
        if(command instanceof CommandUsingObject)
        {


            Parser<String> parserName = new Parser();
            String name = parserName.getArgumentWithRules("введите название города", terminal, lineReader,
                    arg -> City.parseName((String) arg));
            Parser<Float> parserX = new Parser();
            float x = parserX.getArgumentWithRules("введите число в формате float, первую координату", terminal, lineReader,
                    arg -> Coordinates.parseXCoord((String) arg));
            Parser<Long> parserY = new Parser();
            long y = parserY.getArgumentWithRules("введите число в формате long, вторую координату", terminal, lineReader,
                    arg -> Coordinates.parseYCoord((String) arg));
            Parser<Long> parserArea = new Parser();
            Long area = parserArea.getArgumentWithRules("введите площадь в формате Long, площадь должна быть больше 0", terminal, lineReader,
                    arg -> City.parseArea((String) arg));
            Parser<Integer> parserPopulation = new Parser();
            int population = parserPopulation.getArgumentWithRules("введите население, должно быть больше 0", terminal, lineReader, arg -> City.parsePopulation((String) arg));
            Parser<Double> parserMetersAbove = new Parser();
            double deep = parserMetersAbove.getArgumentWithRules("введите высоту над уровнем моря в формате double", terminal, lineReader, arg -> City.parseMetersAboveSeaLevel((String) arg));
            Parser<Boolean> parserCapital = new Parser();
            Boolean capital  = parserCapital.getArgumentWithRules("введите true если у города есть столица, что угодно другое в ином случае", terminal, lineReader, arg -> City.parseCapital((String) arg));
            Parser<Long> parserCarCode = new Parser();
            Long carcode = parserCarCode.getArgumentWithRules("введите carCode - целое число от 0 до 1000", terminal, lineReader, arg -> City.parseCarCode((String) arg));
            Parser<Government> parserGovernment = new Parser();
            Government government = parserGovernment.getArgumentWithRules("введите тип правительства: KLEPTOCRACY, CORPORATOCRACY или PATRIARCHY", terminal, lineReader, arg -> City.parseGovernment((String) arg));
            Parser<Human> parserGovernor = new Parser();
            Human governor = parserGovernor.getArgumentWithRules("введите дату в формате yyyy-MM-dd<английская буква T>HH:mm:ss", terminal, lineReader, arg -> Human.parseGovernor((String) arg));

            City city =new City(name,new Coordinates(x,y),area,population,deep,capital,carcode,government,governor);
            command.addObject(city);
            System.out.println("введен объект:  " + city);

        }

    }
}