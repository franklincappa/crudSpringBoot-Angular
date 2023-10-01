package com.datacode.crudAgenda.controller;

import com.datacode.crudAgenda.model.Contacto;
import com.datacode.crudAgenda.model.ServiceResponse;
import com.datacode.crudAgenda.service.IContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contacto")
@CrossOrigin("*")
public class ContactoController {
    @Autowired
    private IContactoService iContactoService;
    @GetMapping("/list")
    public ResponseEntity<List<Contacto>> list(){
        var result=iContactoService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<ServiceResponse> save(@RequestBody Contacto contacto){
        ServiceResponse serviceResponse= new ServiceResponse();
        int result= iContactoService.save(contacto);
        if(result==1){
            serviceResponse.setMessage("Item guardado con éxito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Contacto contacto){
        ServiceResponse serviceResponse= new ServiceResponse();
        int result= iContactoService.update(contacto);
        if(result==1){
            serviceResponse.setMessage("Item actualizado con éxito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> update(@PathVariable int id){
        ServiceResponse serviceResponse= new ServiceResponse();
        int result= iContactoService.deleteById(id);
        if(result==1){
            serviceResponse.setMessage("Item eliminado con éxito");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

}
