package server.fileManagement;

import objectSpace.City;
import server.Storage;

import java.io.IOException;

public interface FileSaver {
    void save(String filename, Storage<City> cities) throws IOException;
}
