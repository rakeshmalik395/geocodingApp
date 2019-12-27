import { Injectable, OnInit } from '@angular/core';
import { CoreModule } from '../../views/core/core.module';

@Injectable()
export class StorageService {

  // tslint:disable-next-line: variable-name
  private _isLoggedIn = 'false';

  constructor() { }

  set isLoggedIn(isLoggedIn: string) {
    // check isLoggedIn
    this._isLoggedIn = isLoggedIn;
    localStorage.setItem('isLoggedIn', this._isLoggedIn);
  }
  get isLoggedIn() {
    this._isLoggedIn = localStorage.getItem('isLoggedIn');
    return this._isLoggedIn;
  }
}
