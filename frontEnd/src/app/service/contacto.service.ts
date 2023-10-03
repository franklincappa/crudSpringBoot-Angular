import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { contactoModel } from '../model/contacto-model';

@Injectable({
  providedIn: 'root'
})
export class ContactoService {

  constructor(private httpClient:HttpClient ) {     
  }

  getContactos: Observable<contactoModel[]>{
    return 0; 
  }
}
