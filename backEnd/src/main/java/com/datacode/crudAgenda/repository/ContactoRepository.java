package com.datacode.crudAgenda.repository;

import com.datacode.crudAgenda.model.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactoRepository implements IContactoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Contacto> findAll() {
        String query="Select * from contactos where estado=1";
        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Contacto.class));
    }

    @Override
    public int save(Contacto contacto) {
        String query ="Insert into contactos (nombres, apellidos, celular, email, direccion, estado) values(?,?,?,?,?,?)";
        return jdbcTemplate.update(query, new Object[]{contacto.getNombres(),contacto.getApellidos(), contacto.getCelular(), contacto.getEmail(), contacto.getDireccion(), contacto.getEstado()});
    }

    @Override
    public int update(Contacto contacto) {
        String query="Update contactos set nombres=?, apellidos=?, celular=?, email=?, direccion=? where id=?;";
        return jdbcTemplate.update(query, new Object[]{contacto.getNombres(), contacto.getApellidos(), contacto.getCelular(), contacto.getEmail(), contacto.getDireccion(), contacto.getId()} );
    }

    @Override
    public int deleteById(int id) {
        String query="Update contactos set estado=0 where id=? ";
        return jdbcTemplate.update(query, new Object[]{id});
    }
}
