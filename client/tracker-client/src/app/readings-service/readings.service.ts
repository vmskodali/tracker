import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ReadingsService {
  private _readingType;
  private _timeinmins;
  private _vin;
  private _readings;
  private _geoLocations;
  readings12: any[];

  constructor(private http: Http) { }
  getReadingsByVin(vin: string, time: string): Observable<any[]> {
    console.log(`vin : ${this.vin}`);
    console.log(this.timeinmins);
    return this.http.get(`http://localhost:8080/api/readings/history?vin=${this.vin}&timeinmins=${this.timeinmins}`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }

  getGeoLocation(): Observable<any[]> {
    return this.http.get(`http://localhost:8080/api/readings/geolocation/vehicle/${this.vin}`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }

  setGeoLocation() {
    this.getGeoLocation().subscribe(geoLocations => {
      this.geoLocations = geoLocations;
    });
  }
  assignReadings() {
    this.getReadingsByVin(this.vin, this.timeinmins)
      .subscribe(readings => {
        this.readings = readings;
        console.log(readings);
      });
  }

  get readingType() {
    return this._readingType;
  }

  set readingType(value) {
    this._readingType = value;
  }

  get vin() {
    return this._vin;
  }

  set vin(value) {
    this._vin = value;
  }

  get timeinmins() {
    return this._timeinmins;
  }

  set timeinmins(value) {
    this._timeinmins = value;
  }

  get readings() {
    return this._readings;
  }

  set readings(value) {
    this._readings = value;
  }

  get geoLocations() {
    return this._geoLocations;
  }

  set geoLocations(value) {
    this._geoLocations = value;
  }
}
