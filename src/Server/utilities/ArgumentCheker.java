package Server.utilities;
@FunctionalInterface
public interface ArgumentCheker<String> {
    boolean check(String arg);
}