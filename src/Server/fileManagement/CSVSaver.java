package Server.fileManagement;

import objectSpace.City;
import Server.Storage;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

/**
 * сохраняет в csv-файл коллекцию
 */

public class CSVSaver implements FileSaver{
    private Queue<String> createContsentsOfFile(Collection<City> storage)
    {
        Queue<String> contents = new LinkedList<>();
        contents.add("id,name,coordinate_x,coordinate_y,creationDate,area,population,metersAboveSeaLevel,capital,carCode,government,governor_birthday\n");
        for(City city : storage)
        {
            contents.add(city.toString());
        }
        return contents;
    }
    /**
     * @param filename
     * @param cities
     * @throws IOException
     */
    @Override
    public void save(String filename, Storage<City> cities) throws IOException {
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filename));
        Queue<String> contents = createContsentsOfFile(cities);
        for(String line : contents)
        {
            line=line+"\n";
            outputStream.write(line.getBytes());
            outputStream.flush();
        }
        outputStream.close();
    }


}
