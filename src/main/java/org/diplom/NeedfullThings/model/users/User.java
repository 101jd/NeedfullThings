package org.diplom.NeedfullThings.model.users;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.diplom.NeedfullThings.model.interfaces.Obj;
import org.diplom.NeedfullThings.model.market.Cart;
import org.diplom.NeedfullThings.model.market.WishList;

import java.util.UUID;

@NoArgsConstructor
@Data
public class User implements Obj {
    private UUID id = UUID.randomUUID();
    private String email;
    private Cities city;
    private Cart cart;
    private WishList wishList;

    public User(String email, Cities city){
        this.email = email;
        this.city = city;
        this.cart = new Cart();
        this.wishList = new WishList();
    }

}
