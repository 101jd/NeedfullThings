package org.diplom.NeedfullThings.repository.objrepos;

import org.diplom.NeedfullThings.model.interfaces.Obj;
import org.diplom.NeedfullThings.model.market.Thing;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class ThingsRepo extends ObjRepo {
    public ThingsRepo() {
        super("things", 7);
    }


    /**
     * INSERT INTO things VALUES(
     * id, name, image, description, price, is, quantity
     * )
     * @param thing
     */
    public void addThing(Thing thing) {
        super.addObj(Arrays.asList(thing.getId(), thing.getName(),
                thing.getImage(), thing.getDescription(),
                thing.getPrice(), thing.isIs(), thing.getQuantity()));
    }

    public void refreshQuantity(Thing thing){
        jdbc.update("UPDATE " + table + " SET quantity=? WHERE id=?", thing.getId(), thing.getId());
    }

    public List<Obj> getAll() {
        RowMapper<Thing> mapper = (r, i) -> {
            Thing thing = new Thing();
            thing.setId(UUID.fromString(r.getString("id")));
            thing.setName(r.getString("name"));
            thing.setImage(r.getString("image"));
            thing.setDescription(r.getString("description"));
            thing.setPrice(r.getDouble("price"));
            thing.setIs(r.getBoolean("is"));
            thing.setQuantity(r.getInt("quantity"));
            return thing;
        };
        return super.getAll(mapper);
    }

    public Thing getThingById(UUID id){
        ResultSetExtractor<Thing> extractor = (r) -> {
            Thing thing = new Thing();
            thing.setId(UUID.fromString(r.getString("id")));
            thing.setName(r.getString("name"));
            thing.setImage(r.getString("image"));
            thing.setDescription(r.getString("description"));
            thing.setPrice(r.getDouble("price"));
            thing.setIs(r.getBoolean("is"));
            thing.setQuantity(r.getInt("quantity"));
            return thing;
        };
        return super.getById(extractor, id);
    }
}
