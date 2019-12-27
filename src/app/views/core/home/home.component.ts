import { Component, OnInit } from '@angular/core';
import { User } from '../../../data-store/models/user.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  user = new User();

  constructor() { }

  ngOnInit() {

  }

}
