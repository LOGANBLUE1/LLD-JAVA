package expense;

import lombok.AllArgsConstructor;
import lombok.Data;
import user.User;

@Data
@AllArgsConstructor
public class Split {
    private User user;
    private double amount;
}
