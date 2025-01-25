package org.diplom.NeedfullThings.model.market;

import lombok.Data;
import org.diplom.NeedfullThings.model.interfaces.ThingList;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class WishList implements ThingList {
    private List<Thing> wishlist = new ArrayList<>();
    private UUID id = UUID.randomUUID();

    public Thing addTo(Thing thing){
        if (wishlist.add(thing))
            return thing;
        return null;
    }

    public Thing remove(Thing thing){
        if (wishlist.remove(thing))
            return thing;
        return null;
    }
}
