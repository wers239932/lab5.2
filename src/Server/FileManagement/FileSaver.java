package Server.FileManagement;

import Objects.City;
import Server.Storage;

import java.io.IOException;
import java.util.ArrayList;

public interface FileSaver {
    void save(String filename, Storage<City> cities) throws IOException;
}
