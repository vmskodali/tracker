import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AlertService} from "../alert-service/alert.service";

@Component({
  selector: 'app-alert-detail',
  templateUrl: './alert-detail.component.html',
  styleUrls: ['./alert-detail.component.css']
})
export class AlertDetailComponent implements OnInit {

  alerts;
  displayedAlerts = new Array();
  pages = new Array();
  curAlertPage;
  constructor(private route: ActivatedRoute, private alertService: AlertService) {

  }
  ngOnInit() {

    this.route.params.subscribe(params => {
      this.alertService.getAlertsByVin(params.vin)
        .subscribe(alerts => {
          this.alerts = alerts;
          let i;
          console.log(`Alerts length : ${alerts.length}`)
          for (i = 0; i < alerts.length / 10 - 1; i++) {
            this.displayedAlerts[i] = alerts.slice(i * 10, i * 10 + 9);
            this.pages[i] = i;
            console.log(`Current Index ${i}`);
          }
          this.displayedAlerts[i] = alerts.slice(i * 10, alerts.length - 1);
          if (this.displayedAlerts.length !== 0) {
            this.curAlertPage = this.displayedAlerts[0];
          }
          console.log(`pagination size ${this.displayedAlerts.length}`);
          console.log(this.displayedAlerts);
          console.log(this.pages);
        });
    });
  }

  page(i: number) {
    this.curAlertPage = this.displayedAlerts[i];
  }
}

