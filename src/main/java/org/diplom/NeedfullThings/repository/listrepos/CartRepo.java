package org.diplom.NeedfullThings.repository.listrepos;

import lombok.AllArgsConstructor;
import org.diplom.NeedfullThings.model.users.User;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepo extends ListRepo {
    public CartRepo() {
        super("cart");
    }

    public double getTotalPrice(User user){
        return user.getCart().getTotalPrice();
    }
}
