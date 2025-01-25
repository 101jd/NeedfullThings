package org.diplom.NeedfullThings.repository.objrepos;

import org.diplom.NeedfullThings.model.interfaces.Obj;
import org.diplom.NeedfullThings.model.market.Cart;
import org.diplom.NeedfullThings.model.market.WishList;
import org.diplom.NeedfullThings.model.users.Cities;
import org.diplom.NeedfullThings.model.users.User;
import org.diplom.NeedfullThings.repository.listrepos.CartRepo;
import org.diplom.NeedfullThings.repository.listrepos.MapLists;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepo extends ObjRepo {
    public UserRepo() {
        super("users", 5);
    }

    /**
     * INSERT INTO users VALUES(
     * id, email, city, cart, wishList
     * @param user
     */
    public void addUser(User user) {
        super.addObj(Arrays.asList(user.getId(), user.getEmail(),
                user.getCity(), user.getCart().getId(), user.getWishList().getId()));
    }


    public List<Obj> getAll() {
        RowMapper<User> mapper = (r, i) -> {
          User user = new User();
          user.setId(UUID.fromString(r.getString("id")));
          user.setEmail(r.getString("email"));
          user.setCity((Cities) r.getObject("city"));
          user.setCart((Cart) MapLists.getList(UUID.fromString(r.getString("cart"))));
          user.setWishList((WishList) MapLists.getList(UUID.fromString(r.getString("wishList"))));
          return user;
        };
        return super.getAll(mapper);
    }

    public User getUserById(UUID id){
        ResultSetExtractor<User> extractor = (r) -> {
            User user = new User();

            user.setId(UUID.fromString(r.getString("id")));
            user.setEmail(r.getString("email"));
            user.setCity(Cities.valueOf(r.getString("city")));
            user.setCart((Cart) MapLists.getList(UUID.fromString(r.getString("cart"))));
            user.setWishList((WishList) MapLists.getList(UUID.fromString(r.getString("wishList"))));

            return user;
        };
        return super.getById(extractor, id);
    }
}
