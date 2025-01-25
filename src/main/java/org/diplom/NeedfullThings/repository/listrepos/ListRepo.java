package org.diplom.NeedfullThings.repository.listrepos;

import lombok.AllArgsConstructor;
import org.diplom.NeedfullThings.model.market.Thing;
import org.diplom.NeedfullThings.model.interfaces.ThingList;
import org.diplom.NeedfullThings.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public abstract class ListRepo {
    @Autowired
    protected JdbcTemplate jdbc;
    protected String table;

    public ListRepo(String table) {
        this.table = table;
    }

    public ListRepo() {
    }

    public void addToDB(User user, Thing thing, ThingList thingList){
        jdbc.update("INSERT INTO " + table + " VALUES (?, ?)",
                user.getId().toString(), thingList.addTo(thing).getId().toString());
    }

    public List<Thing> getAllThings(User user){
        RowMapper<Thing> mapper = (r, i) -> {
            Thing row = new Thing();
            row.setId(UUID.fromString(r.getString("id")));
            row.setIs(r.getBoolean("is"));
            row.setName(r.getString("name"));
            row.setDescription(r.getString("description"));
            row.setPrice(r.getDouble("price"));
            return row;
        };
        return jdbc.query("SELECT * FROM " + table + " JOIN things WHERE user_id=?",
                new Object[]{ user.getId().toString()}, mapper);
    }

    public void removeFrom(User user, ThingList thingList, Thing thing){
        jdbc.update("DELETE FROM " + table + " WHERE user_id = ? AND thing_id = ?",
                user.getId().toString(), thingList.remove(thing).getId().toString());
    }
}
