import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { contactoModel } from 'src/app/model/contacto-model';
import { ContactoService } from 'src/app/service/contacto.service';

@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.sass']
})
export class ContactoComponent {
  listaContactos: contactoModel[]=[];
  formContacto: FormGroup=new FormGroup({});
  isUpdate: Boolean = false;

  constructor(private contactoService: ContactoService){}
  ngOnInit():void{
    this.listar();
    this.formContacto= new FormGroup({
      id:new FormControl(''),
      nombres: new FormControl(''),
      apellidos: new FormControl(''),
      celular: new FormControl(''),
      email: new FormControl(''),
      direccion: new FormControl(''),
      estado: new FormControl('')
    })
  }

  listar(){
    this.contactoService.getContactos().subscribe(resp=>{
      if(resp){
        this.listaContactos=resp;
      }
    })
  }

  nuevoContacto(){
    this.isUpdate=false;
    this.formContacto.reset();
  }

  selectItem(item: any){
    this.isUpdate=true;
    this.formContacto.controls['id'].setValue(item.id);
    this.formContacto.controls['nombres'].setValue(item.nombres);
    this.formContacto.controls['apellidos'].setValue(item.apellidos);
    this.formContacto.controls['celular'].setValue(item.celular);
    this.formContacto.controls['email'].setValue(item.email);
    this.formContacto.controls['direccion'].setValue(item.direccion);
  }

  save(){
    this.formContacto.controls['estado'].setValue('1');
    this.contactoService.saveContacto(this.formContacto.value).subscribe(resp=>{
      if(resp){
        this.listar();
        this.formContacto.reset();
      }  
    })
  }

  update(){
    this.contactoService.updateContacto(this.formContacto.value).subscribe(resp=>{
      if(resp){
        this.listar();
        this.formContacto.reset();
      }  
    })
  }

  delete(id: any){
    this.contactoService.deleteContacto(id).subscribe(resp=>{
      if(resp){
        this.listar();
        this.formContacto.reset();
      }  
    })
  }

}
