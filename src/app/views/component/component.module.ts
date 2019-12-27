import { NgModule } from '@angular/core';
import { AgmCoreModule } from '@agm/core';
import { CommonModule } from '@angular/common';
import { GoogleMapComponent } from './google-map/google-map.component';
import { MarkersListComponent } from './markers-list/markers-list.component';
import { ComponentRoutingModule } from './component-routing.module';


@NgModule({
  declarations: [GoogleMapComponent, MarkersListComponent],
  imports: [
    CommonModule,
    ComponentRoutingModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyA-QlvggM5hFejsLpS_qy7LxCyaLtsNrmw'
    })
  ],
  exports: [AgmCoreModule, GoogleMapComponent, MarkersListComponent]
})
export class ComponentModule { }
