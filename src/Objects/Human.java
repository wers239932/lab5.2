package Objects;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Класс всего полезного о человеке - дата рождения
 */

public class Human {
    private final LocalDateTime birthday;

    public Human(LocalDateTime date)
    {
        this.birthday=date;
    }
    @Override
    public String toString()
    {
        return this.birthday.toString();
    }
}
