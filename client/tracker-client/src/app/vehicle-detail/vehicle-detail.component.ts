import { Component, OnInit } from '@angular/core';
import {VehicleService} from "../vehicle-service/vehicle.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ReadingsService} from "../readings-service/readings.service";
import {AlertService} from "../alert-service/alert.service";

@Component({
  selector: 'app-vehicle-detail',
  templateUrl: './vehicle-detail.component.html',
  styleUrls: ['./vehicle-detail.component.css']
})
export class VehicleDetailComponent implements OnInit {
  vehicle;
  readingType;
  readingTime;
  isGeoSelected = false;
  isAlertSelected = false;
  isReadingsSelected = false;

  constructor(private route: ActivatedRoute, private vehicleService: VehicleService,
              private readingService: ReadingsService, private alertService: AlertService, private router: Router) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.vehicleService.getVehicle(params.vin)
        .subscribe(vehicle => this.vehicle = vehicle);
      this.readingService.vin = params.vin;
      this.alertService.vin = params.vin;
    });
    this.vehicleService.currentVehicle = this.vehicle;
    this.readingService.setGeoLocation();
    this.alertService.setAlerts();
  }
  getReadings() {
    this.isReadingsSelected = true;
    this.isAlertSelected = false;
    this.isGeoSelected = false;
    this.readingService.readingType = this.readingType;
    this.readingService.vin = this.vehicle.vin;
    this.readingService.timeinmins = this.readingTime;
    this.readingService.assignReadings();
  }
  check_if_is_integer(value) {
    if ((parseFloat(value) === parseInt(value, 0)) && !isNaN(value)) {
      // I can have spacespacespace1 - which is 1 and validators pases but
      // spacespacespace doesn't - which is what i wanted.
      // 1space2 doesn't pass - good
      // of course, when saving data you do another parseInt.
      return true;
    } else {
      return false;
    }
  }

}
