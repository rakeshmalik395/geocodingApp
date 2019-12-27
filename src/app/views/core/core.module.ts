import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AuthComponent } from './auth/auth.component';
import { RouterModule } from '@angular/router';
import { StorageService } from '../../data-store/store/storage.service';
import { FormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    LoginComponent,
    HomeComponent,
    AuthComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    StorageService
  ],
  exports: [
    LoginComponent,
    HomeComponent,
    AuthComponent
  ]
})
export class CoreModule { }
