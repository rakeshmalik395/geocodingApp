import { Component, OnInit } from '@angular/core';
import { User } from '../../../data-store/models/user.model';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router) { }
  user = new User();
  resUser: any;
  subject = new BehaviorSubject<User>(this.user);
  ngOnInit() {

  }

  onLogin() {

    this.loginService.loginUser(this.user).subscribe((res) => {
      this.resUser = res;
      console.log(this.resUser);
      this.subject.next(this.resUser);
      //localStorage.setItem('username', this.resUser.emailId);
      if (this.resUser) {
        this.router.navigate(['/home']);
      }
    });




    // check user name pass
    // call API login -- logInApi --> authenticate() --> obsevable
    // on success
    // storage service set method('true');
    // route.navigate -> home

    // on error
    // storage service set method('false');
    // user message --> reset form
  }

}
