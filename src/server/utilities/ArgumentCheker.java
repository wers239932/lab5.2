package server.utilities;
@FunctionalInterface
public interface ArgumentCheker<String> {
    boolean check(String arg);
}