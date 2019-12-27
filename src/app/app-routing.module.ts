import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NotFoundComponent } from './views/component/not-found/not-found.component';
import { MarkersListComponent } from './views/component/markers-list/markers-list.component';
import { HomeComponent } from './views/core/home/home.component';
import { LoginComponent } from './views/core/login/login.component';
import { AuthComponent } from './views/core/auth/auth.component';


const appRoutes: Routes = [
  { path: '', redirectTo: '/auth', pathMatch: 'full' },
  {
    path: 'map',
    loadChildren: () => import('./views/component/component.module').then(m => m.ComponentModule)
  },
  { path: 'auth', component: AuthComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
