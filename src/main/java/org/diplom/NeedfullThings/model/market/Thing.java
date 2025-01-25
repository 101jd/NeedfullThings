package org.diplom.NeedfullThings.model.market;

import lombok.Data;
import org.diplom.NeedfullThings.model.interfaces.Obj;

import java.util.UUID;

@Data
public class Thing implements Obj {
    private int quantity;

    private UUID id = UUID.randomUUID();
    private String name;
    private double price;
    private String image;
    private String description;
    private boolean is;


    public void decrementQuantity(){
        --quantity;
    }

    public void incrementQuantity(){
        ++quantity;
    }
}
