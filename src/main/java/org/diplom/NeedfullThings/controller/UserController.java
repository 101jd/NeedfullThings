package org.diplom.NeedfullThings.controller;

import org.diplom.NeedfullThings.model.market.RequestThing;
import org.diplom.NeedfullThings.model.market.Thing;
import org.diplom.NeedfullThings.model.users.RequestUser;
import org.diplom.NeedfullThings.model.users.User;
import org.diplom.NeedfullThings.service.MailGateway;
import org.diplom.NeedfullThings.service.ThingService;
import org.diplom.NeedfullThings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private ThingService thingService;
    @Autowired
    private UserService userService;

    @Autowired
    private MailGateway gateway;

    @PostMapping("/reg")
    public ResponseEntity<User> register(@RequestBody RequestUser user){
        if (gateway.sendEmail("e.janedoe.87@gmail.com", user.getEmail(), "Test", "test email") != null)
            return ResponseEntity.ok(userService.addUser(user));
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/addc")
    public ResponseEntity<Boolean> addToCart(@RequestBody RequestThing request){
        return ResponseEntity.ok(thingService.addThingToCart(userService.getById(request.getUserID()),
                thingService.getById(request.getThingID())));
    }

    @PostMapping("/addwl")
    public ResponseEntity<Boolean> addToWishList(@RequestBody RequestThing request){
        return ResponseEntity.ok(thingService.addToWishList(userService.getById(request.getUserID()),
                thingService.getById(request.getThingID())));
    }

    @PostMapping("/remc")
    public ResponseEntity<Void> removeFromCart(@RequestBody RequestThing request){
        thingService.removeFromCart(userService.getById(request.getThingID()),
                thingService.getById(request.getThingID()));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/remwl")
    public ResponseEntity<Void> removeFromWishList(@RequestBody RequestThing request){
        thingService.removeFromWishList(userService.getById(request.getUserID()),
                thingService.getById(request.getThingID()));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cart")
    public ResponseEntity<List<Thing>> getCart(@RequestBody RequestThing request){
        return ResponseEntity.ok(thingService.getAllCart(userService.getById(request.getUserID())));
    }

    @PostMapping("/wishlist")
    public ResponseEntity<List<Thing>> getWishList(@RequestBody RequestThing request){
        return ResponseEntity.ok(thingService.getAllWishList(userService.getById(request.getUserID())));
    }

    @PostMapping("total")
    public ResponseEntity<Double> getTotalPrice(@RequestBody RequestThing request){
        return ResponseEntity.ok(thingService.getTotalPrice(userService.getById(request.getUserID())));
    }
}
