import { MapType } from '@angular/compiler';

export class MapLocation {
  latitude: number;
  longitude: number;
  mapType?: string;
  zoom?: number;
  marker?: Marker;
}
export class Marker {
lat: number;
lng: number;

}
