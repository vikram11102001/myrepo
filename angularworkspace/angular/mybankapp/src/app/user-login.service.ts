import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpParams } from '@angular/common/http';
import { UserLogin } from './user-login';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http'; 

@Injectable({
  providedIn: 'root'
})
export class UserLoginService {

  private usersUrl: string;

  

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/user/getusers';
  }

  public login(user: UserLogin):Observable<Object> {
    let params = new HttpParams();
    params.set('username', "user1");
    params.set('password', "password1");
 
    return this.http.get('http://localhost:8080/user/getusers',
                  {params:params}
    );
  }


}
