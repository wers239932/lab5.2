package Server.Terminal;
@FunctionalInterface
public interface ArgumentCheker<String> {
    public boolean check(String arg);
}