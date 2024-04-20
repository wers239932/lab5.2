package server.utilities;
@FunctionalInterface
public interface ArgumentParser<T, String> {
T parse(String arg) throws Exception;
}