package Server.fileManagement;


import objectSpace.City;
import objectSpace.exceptions.*;
import Server.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * загружает из csv-файла коллекцию объектов
 */
public class CSVLoader implements StorageLoader{
    private final FileReader reader;
    private final File file;
    public CSVLoader(File file) throws FileNotFoundException {
        this.file = file;
        this.reader=new FileReader(file);
    }
    private String readLine() throws IOException {
        String str = null;
        int ch = this.reader.read();
        if (ch != -1) str = "";
        else str = null;

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
    @Override
    public Storage<City> loadStorage() throws IOException, CoordinatesException, AreaException, GovernmentException, GovernorException, HeightException, CarCodeException, PopulationException, NameCityException, CapitalException {
        Storage<City> storage=new Storage<City>();
        String line=readLine();
        line=readLine();
        while(line!=null)
        {
            storage.add(City.parseCity(line.trim().split(",")));
            line=readLine();
        }
        reader.close();
        return storage;
    }
}
