import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AlertService} from "../alert-service/alert.service";

@Component({
  selector: 'app-high-alert',
  templateUrl: './high-alert.component.html',
  styleUrls: ['./high-alert.component.css']
})
export class HighAlertComponent implements OnInit {
  highAlerts

  constructor(private route: ActivatedRoute, private alertService: AlertService) { }

  ngOnInit() {
    this.alertService.getHighAlerts().subscribe(highAlerts => this.highAlerts = highAlerts);
  }

}
