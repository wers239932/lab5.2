package Server.Terminal;
@FunctionalInterface
public interface ArgumentCheker<String> {
    boolean check(String arg);
}