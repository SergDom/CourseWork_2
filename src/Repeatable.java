import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Repeatable {
    boolean nextTime(LocalDateTime localDate);

}
