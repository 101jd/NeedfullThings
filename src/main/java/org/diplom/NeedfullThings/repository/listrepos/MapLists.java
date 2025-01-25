package org.diplom.NeedfullThings.repository.listrepos;

import org.diplom.NeedfullThings.model.interfaces.ThingList;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MapLists {
    private static final Map<UUID, ThingList> map = new HashMap<>();

    public static void addToList(ThingList thingList){
        map.put(thingList.getId(), thingList);
    }

    public static ThingList getList(UUID uuid){
        return map.get(uuid);
    }
}
