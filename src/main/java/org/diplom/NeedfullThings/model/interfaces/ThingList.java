package org.diplom.NeedfullThings.model.interfaces;

import org.diplom.NeedfullThings.model.market.Thing;

import java.util.UUID;

public interface ThingList {
    Thing addTo(Thing thing);
    UUID getId();
    Thing remove(Thing thing);
}
