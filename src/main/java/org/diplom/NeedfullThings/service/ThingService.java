package org.diplom.NeedfullThings.service;

import org.diplom.NeedfullThings.model.market.Thing;
import org.diplom.NeedfullThings.model.users.User;
import org.diplom.NeedfullThings.repository.listrepos.CartRepo;
import org.diplom.NeedfullThings.repository.listrepos.WishListRepo;
import org.diplom.NeedfullThings.repository.objrepos.ThingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ThingService {
    @Autowired
    ThingsRepo thingsRepo;
    @Autowired
    CartRepo cartRepo;
    @Autowired
    WishListRepo wishListRepo;


    private boolean setIs(Thing thing){
        if (thing.getQuantity() == 0){
            thing.setIs(false);
        } else thing.setIs(true);
        return thing.isIs();
    }

    public boolean addThingToCart(User user, Thing thing){
        if (setIs(thing)){
            thing.decrementQuantity();
            cartRepo.addToDB(user, thing, user.getCart());
            thingsRepo.refreshQuantity(thing);
            return true;
        }
        return false;
    }

    public boolean addToWishList(User user, Thing thing){
        wishListRepo.addToDB(user, thing, user.getWishList());
        return true;
    }

    public Thing getById(UUID id){
        return thingsRepo.getThingById(id);
    }

    public void removeFromCart(User user, Thing thing){
        thing.incrementQuantity();
        cartRepo.removeFrom(user, user.getCart(), thing);
        thingsRepo.refreshQuantity(thing);
        setIs(thing);
    }

    public void removeFromWishList(User user, Thing thing){
        wishListRepo.removeFrom(user, user.getWishList(), thing);
    }

    public List<Thing> getAllCart(User user){
        return cartRepo.getAllThings(user);
    }

    public List<Thing> getAllWishList(User user){
        return wishListRepo.getAllThings(user);
    }

    public Double getTotalPrice(User user){
        return cartRepo.getTotalPrice(user);
    }
}
