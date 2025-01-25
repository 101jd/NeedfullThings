package org.diplom.NeedfullThings.service;

import org.diplom.NeedfullThings.model.market.Thing;
import org.diplom.NeedfullThings.model.users.RequestUser;
import org.diplom.NeedfullThings.model.users.User;
import org.diplom.NeedfullThings.repository.listrepos.CartRepo;
import org.diplom.NeedfullThings.repository.listrepos.MapLists;
import org.diplom.NeedfullThings.repository.listrepos.WishListRepo;
import org.diplom.NeedfullThings.repository.objrepos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private WishListRepo wishListRepo;
    @Autowired
    private UserRepo userRepo;

    public User addUser(RequestUser requestUser){
        try {
            User user = new User(requestUser.getEmail(), requestUser.getCity());
            userRepo.addUser(user);
            MapLists.addToList(user.getCart());
            MapLists.addToList(user.getWishList());
            return user;
        } catch (DataAccessException e){
            return null;
        }

    }

    public User getById(UUID id){
        return userRepo.getUserById(id);
    }
}
