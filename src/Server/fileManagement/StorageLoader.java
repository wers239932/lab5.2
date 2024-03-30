package Server.fileManagement;

import objectSpace.exceptions.*;
import Server.Storage;

import java.io.IOException;

public interface StorageLoader {
    Storage loadStorage() throws IOException, CoordinatesException, AreaException, GovernmentException, GovernorException, HeightException, CarCodeException, PopulationException, NameCityException, CapitalException;
}
