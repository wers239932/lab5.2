package Server.utilities;

import Server.ui.Terminal;
import objectSpace.Government;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * проверка типов данных при вводе различных типов данных
 */
public class ArgumentValidator{
    private final Terminal terminal;
    public ArgumentValidator(Terminal terminal)
    {
        this.terminal=terminal;
    }
    public boolean checkId(String idToCheck){
        if(!idToCheck.matches("[1-9]\\d*\\s*")) {
            this.terminal.writeLine("id должен быть целым неотрицательным числом");
            return false;
        }
        try {
            Integer.parseInt(idToCheck);
        } catch (Exception e) {
            this.terminal.writeLine("Слишком большое значение id, невозможно  выполнить команду");
            return false;
        }
        return true;
    }
    public boolean checkName(String nameToCheck){
        if(nameToCheck=="")
        {
            this.terminal.writeLine("название должно быть не null");
            return false;
        }
        return true;
    }
    public boolean checkCoordinates(String[] coordinates){
        if(coordinates.length!=2)
        {
            this.terminal.writeLine("координаты должно быть две");
            return false;
        }
        return (checkFloat(coordinates[0]) && checkLong(coordinates[1]));
    }
    public boolean checkFloat(String x){
        try
        {
            float y = Float.parseFloat(x);
            if(!Float.isFinite(y)) return false;
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean checkLong(String x){
        try
        {
            long y = Long.parseLong(x);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean checkDouble(String x){
        try
        {
            double y = Double.parseDouble(x);
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean checkDate(String date){
        try
        {
            ZonedDateTime y = ZonedDateTime.parse(date);
        }
        catch (Exception e)
        {this.terminal.writeLine("некорректный формат даты");
            return false;
        }
        return true;
    }
    public boolean checkArea(String area){
        try
        {
            long y = Long.parseLong(area);
            if(y<0) return false;
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean checkPopulation(String population){
        try
        {
            int y = Integer.parseInt(population);
            if(y<0) return false;
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean checkCapital(String capital){
        try
        {
            if(capital!="") {
                Boolean y = Boolean.parseBoolean(capital);
            }
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean checkCarCode(String carcode){
        try
        {
            if(carcode!="") {
                Long carcode1=Long.parseLong(carcode);
                if(carcode1<=0 || carcode1>1000) return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean checkGovernment(String government){
        try
        {
            if(government!="") {
                Government government1 = Government.valueOf(government);
            }
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean checkGovernor(String governor){
        try
        {
            if(governor!="") {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime date = LocalDateTime.parse(governor,formatter);
            }
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
}
