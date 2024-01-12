import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from './customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  private baseUrl = "http://localhost:8080/api/dashboard";

  constructor(private http: HttpClient) { }

  public getCustomerById(customerID : string):Observable<Customer>{
    return this.http.get<Customer>(`${this.baseUrl}/customer/${customerID}`);
  }
}
