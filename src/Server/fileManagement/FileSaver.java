package Server.fileManagement;

import objectSpace.City;
import Server.Storage;

import java.io.IOException;

public interface FileSaver {
    void save(String filename, Storage<City> cities) throws IOException;
}
