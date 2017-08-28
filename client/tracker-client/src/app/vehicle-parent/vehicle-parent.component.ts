import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {VehicleService} from "../vehicle-service/vehicle.service";
import {ReadingsService} from "../readings-service/readings.service";
import {AlertService} from "../alert-service/alert.service";

@Component({
  selector: 'app-vehicle-parent',
  templateUrl: './vehicle-parent.component.html',
  styleUrls: ['./vehicle-parent.component.css']
})
export class VehicleParentComponent implements OnInit {

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
        .subscribe(vehicle => {
          this.vehicle = vehicle;
          this.router.navigate([`vehicleDetail/${params.vin}/alerts/vehicle`]);
          this.readingService.vin = params.vin;
          this.alertService.vin = params.vin;
          this.vehicleService.currentVehicle = this.vehicle;
        });
    });
    this.readingService.setGeoLocation();
    this.alertService.setAlerts();
  }

}
