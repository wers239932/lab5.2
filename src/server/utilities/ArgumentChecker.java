package server.utilities;
@FunctionalInterface
public interface ArgumentChecker<String> {
    boolean check(String arg);
}