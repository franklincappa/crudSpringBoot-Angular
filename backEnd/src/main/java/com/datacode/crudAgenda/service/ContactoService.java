package com.datacode.crudAgenda.service;

import com.datacode.crudAgenda.model.Contacto;
import com.datacode.crudAgenda.repository.IContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService implements IContactoService{
    @Autowired
    private IContactoRepository iContactoRepository;
    @Override
    public List<Contacto> findAll() {
        List<Contacto> list;
        try{
            list=iContactoRepository.findAll();
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public int save(Contacto contacto) {
        int row;
        try{
            row=iContactoRepository.save(contacto);
        }catch(Exception ex){
            throw ex;
        }
        return row;

    }

    @Override
    public int update(Contacto contacto) {
        int row;
        try{
            row=iContactoRepository.update(contacto);
        }catch(Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int deleteById(int id) {
        int row;
        try{
            row=iContactoRepository.deleteById(id);
        }catch(Exception ex){
            throw ex;
        }
        return row;
    }
}
