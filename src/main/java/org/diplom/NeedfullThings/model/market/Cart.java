package org.diplom.NeedfullThings.model.market;

import lombok.Data;
import org.diplom.NeedfullThings.model.interfaces.ThingList;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Cart implements ThingList {
    private UUID id = UUID.randomUUID();
    private List<Thing> things = new ArrayList<>();

    public Thing addTo(Thing thing){
        if (things.add(thing))
            return thing;
        return null;
    }

    public double getTotalPrice() {
        return things.stream()
                .mapToDouble(Thing::getPrice)
                .sum();
    }

    public Thing remove(Thing thing){
        if (things.remove(thing))
            return thing;
        return null;
    }
}
