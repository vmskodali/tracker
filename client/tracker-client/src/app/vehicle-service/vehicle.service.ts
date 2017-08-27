import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";

@Injectable()
export class VehicleService {
  private _vehicles;
  private _currentVehicle;

  constructor(private http: Http) { }
  getVehicles(): Observable<any[]> {
    return this.http.get('http://localhost:8080/api/vehicles')
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }

  getVehicle(vin): Observable<any> {
    return this.http.get(`http://localhost:8080/api/vehicles/${vin}`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }


  get vehicles() {
    return this._vehicles;
  }

  set vehicles(value) {
    this._vehicles = value;
  }

  get currentVehicle() {
    return this._currentVehicle;
  }

  set currentVehicle(value) {
    this._currentVehicle = value;
  }
}
