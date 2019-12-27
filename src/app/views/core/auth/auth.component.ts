import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StorageService } from '../../../data-store/store/storage.service';
import { isNullOrUndefined } from 'util';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  constructor(
    private lcStorage: StorageService,
    private route: Router
  ) { }

  ngOnInit() {
    this.initAuth(this.lcStorage, this.route);
  }

  initAuth(lc: StorageService, rt: Router) {
    console.log(typeof (lc.isLoggedIn));

    if (lc.isLoggedIn == 'true' || lc.isLoggedIn == undefined) {
      rt.navigate(['/login']);
    } else {
      rt.navigate(['/home']);
    }
  }
}
