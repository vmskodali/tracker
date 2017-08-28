import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {VehicleService} from "../vehicle-service/vehicle.service";

@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.css']
})
export class VehicleListComponent implements OnInit {
  vehicles;

  constructor(private route: ActivatedRoute, private vehicleService: VehicleService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.vehicleService.getVehicles()
        .subscribe(vehicles => this.vehicles = vehicles);
    });
  }

}
