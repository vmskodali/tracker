import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http} from "@angular/http";

@Injectable()
export class AlertService {
private _alerts;
private _vin;
private _goingToBeDisplayed;
  constructor(private http: Http) { }


  getAlertsByVin(vin): Observable<any> {
    return this.http.get(`http://localhost:8080/api/alerts/vehicle/${vin}`)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  setAlerts() {
    this.getAlertsByVin(this.vin).subscribe(alerts => this.alerts = alerts);
  }

  get alerts() {
    return this._alerts;
  }

  set alerts(value) {
    this._alerts = value;
  }

  get vin() {
    return this._vin;
  }

  set vin(value) {
    this._vin = value;
  }

  get goingToBeDisplayed() {
    return this._goingToBeDisplayed;
  }

  set goingToBeDisplayed(value) {
    this._goingToBeDisplayed = value;
  }
}
