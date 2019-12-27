import { Injectable } from '@angular/core';
import { NgZone } from '@angular/core';
import { MouseEvent, MapsAPILoader } from '@agm/core';
import { MapLocation } from '../../../data-store/models/location.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MapService {
  mapLocation = new MapLocation();
  map: google.maps.Geocoder;

  constructor(private readonly mapsAPILoader: MapsAPILoader,
              private readonly ngZone: NgZone) { }
  getMap(): Observable<MapLocation>{
    if ('geolocation' in navigator) {
     return  navigator.geolocation.getCurrentPosition((position) => {
        this.location.latitude = position.coords.latitude;
        this.location.longitude = position.coords.longitude;
        this.location.zoom = 20;
      });
    }
  }
}
