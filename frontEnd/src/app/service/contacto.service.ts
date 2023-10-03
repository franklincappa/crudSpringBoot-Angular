import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { contactoModel } from '../model/contacto-model';

@Injectable({
  providedIn: 'root'
})
export class ContactoService {
  url = 'http://localhost:8090/api/v1/contacto'

  constructor(private httpClient:HttpClient ) {     
  }

  getContactos(): Observable<contactoModel[]>{
    return this.httpClient.get<contactoModel[]>(this.url+'/list').pipe(map(res=> res ));
  }

  saveContacto(request: any):Observable<any>{
    return this.httpClient.post<any>(this.url+'/insert', request).pipe(map(res=>res));
  } 

  updateContacto(request: any):Observable<any> {
    return this.httpClient.post<any>(this.url+'/update', request).pipe(map(res=> res));
  }

  deleteContacto(id: number):Observable<any>{
    return this.httpClient.get<any>(this.url+'/delete/'+id).pipe(map(res=>res));
  } 
}
