import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';

import { Customer } from './customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private customersUrl: string;

  constructor(private http: HttpClient) {
    this.customersUrl = 'http://localhost:8080/customer/customers';
  }

  

  public save(customer: Customer):Observable<Object> {
    return this.http.post(`${this.customersUrl}`, customer,{responseType: 'text'});
  }
}
