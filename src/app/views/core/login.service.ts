import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../../data-store/models/user.model';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
const httpHeader = {
  headders: new HttpHeaders({ 'content-type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private httpClient: HttpClient) { }

  loginUser(user: User): Observable<User[]> {
    const subUrl = `${environment.baseUrl}`;
    return this.httpClient.post<User[]>(subUrl, user);
  }
}
