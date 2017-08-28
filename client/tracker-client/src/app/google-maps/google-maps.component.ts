import { Component, OnInit } from '@angular/core';
import {ReadingsService} from "../readings-service/readings.service";
@Component({
  selector: 'app-google-maps',
  styles: [`
    agm-map {
      height: 300px;
      width: 700px;
    }
  `],
  templateUrl: './google-maps.component.html'
})
export class GoogleMapsComponent implements OnInit {
  lat = 30.4937;
  lng = 112.1082;
  constructor(public readingService: ReadingsService) { }

  ngOnInit() {
  }
  logToConsole(m) {
    console.log(m);
  }

}
