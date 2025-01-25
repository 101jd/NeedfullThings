package org.diplom.NeedfullThings.repository.objrepos;

import lombok.AllArgsConstructor;
import org.diplom.NeedfullThings.model.interfaces.Obj;
import org.diplom.NeedfullThings.model.interfaces.ThingList;
import org.diplom.NeedfullThings.model.market.Thing;
import org.diplom.NeedfullThings.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.UUID;


public abstract class ObjRepo {
    @Autowired
    protected JdbcTemplate jdbc;
    protected String table;

    private int valuesNumber;

    public ObjRepo(String table, int valuesNumber){
        this.table = table;
        this.valuesNumber = valuesNumber;
    }
    public ObjRepo(){

    }

    public void addObj(List<Object> values){
        try {
            jdbc.update("INSERT INTO " + table + " VALUES " + valuesQuery(), values);
        } catch (DataAccessException e){

        }
    }

    public <T extends Obj> List<T> getAll(RowMapper mapper){
        try {
            return jdbc.query("SELECT * FROM " + table, mapper);
        }catch (DataAccessException e){
            throw e;
        }
    }


      private String valuesQuery(){
        StringBuilder sb = new StringBuilder().append("(");
        for (int i = 0; i < valuesNumber; i++) {
            sb.append("?");
            if (i < valuesNumber)
                sb.append(", ");
        }
        return sb.append(")").toString();
    }

    public <T extends Obj> T getById(ResultSetExtractor<T> extractor, UUID id){
        try {
            return jdbc.query("SELECT * FROM " + table + " WHERE id = ?", new Object[]{id}, extractor);
        }catch (DataAccessException e){
            throw e;
        }
    }



}
