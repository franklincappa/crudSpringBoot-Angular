package com.datacode.crudAgenda.repository;

import com.datacode.crudAgenda.model.Contacto;

import java.util.List;

public interface IContactoRepository {
    public List<Contacto> findAll();
    public int save(Contacto contacto);
    public int update(Contacto contacto);
    public int deleteById(int id);

}
