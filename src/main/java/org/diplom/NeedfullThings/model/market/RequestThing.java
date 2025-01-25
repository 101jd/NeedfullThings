package org.diplom.NeedfullThings.model.market;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestThing {
    private UUID userID;
    private UUID thingID;
}
