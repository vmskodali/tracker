import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ReadingsService} from "../readings-service/readings.service";

@Component({
  selector: 'app-vehicle-readings',
  templateUrl: './vehicle-readings.component.html',
  styleUrls: ['./vehicle-readings.component.css']
})
export class VehicleReadingsComponent implements OnInit {
  readings: any[];
  constructor(private route: ActivatedRoute, public readingService: ReadingsService) {
    this.readings = this.readingService.readings;
  }

  ngOnInit() {
    console.log(this.readingService.vin);
    console.log(this.readingService.timeinmins);
    console.log(this.readingService.readingType);
    console.log(this.route.snapshot.queryParams);
  }


}
