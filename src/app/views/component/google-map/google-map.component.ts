
import { Component, OnInit, NgZone } from '@angular/core';
import { MouseEvent, MapsAPILoader } from '@agm/core';
import { MapService } from './map.service';

@Component({
  selector: 'app-google-map',
  templateUrl: './google-map.component.html',
  styleUrls: ['./google-map.component.css']
})

export class GoogleMapComponent implements OnInit {

  private geoCoder;
   latitude: number;
  longitude: number;
  zoom = 8;
  address: string;
  map: google.maps.Geocoder;

  constructor(
    private readonly mapsAPILoader: MapsAPILoader,
    private readonly ngZone: NgZone,
    private mapServ: MapService
  ) { }

  ngOnInit() {
    //console.log(this.mapServ.getMap());
     this.setCurrentLocation();
     console.log(this.setCurrentLocation());

    //this.mapServ.getMap();
    this.geoCoder = new google.maps.Geocoder();
  }

  private setCurrentLocation() {
    if ('geolocation' in navigator) {
      navigator.geolocation.getCurrentPosition((position) => {
        this.latitude = position.coords.latitude;
        this.longitude = position.coords.longitude;
        this.zoom = 20;
      });
    }
  }
  getAddress(latitude, longitude) {
    new google.maps.Geocoder().geocode({ 'location': {
      lat: latitude,
      lng: longitude }
     }, (results, status) => {
      console.log(results);
      console.log(status);
      if (status === 'OK') {
        if (results[0]) {
          this.zoom = 12;
          this.address = results[0].formatted_address;
        } else {
          alert('No results found');
        }
      } else {
          alert('Geocoder failed due to: ' + status);
      }

    });
  }
  markerDragEnd($event: MouseEvent) {
    //console.log($event);
    this.latitude = $event.coords.lat;
    this.longitude = $event.coords.lng;
    this.getAddress(this.latitude, this.longitude);
    console.log(this.address);
  }

}
