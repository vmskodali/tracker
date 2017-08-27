import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { VehicleDetailComponent } from './vehicle-detail/vehicle-detail.component';
import { RouterModule, Routes } from "@angular/router";
import {VehicleService} from "./vehicle-service/vehicle.service";
import {Http, HttpModule} from "@angular/http";
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { AlertDetailComponent } from './alert-detail/alert-detail.component';
import {AlertService} from "./alert-service/alert.service";
import {FormsModule} from '@angular/forms';
import { VehicleReadingsComponent } from './vehicle-readings/vehicle-readings.component';
import {ReadingsService} from "./readings-service/readings.service";
import { AgmCoreModule } from '@agm/core';
import { GoogleMapsComponent } from './google-maps/google-maps.component';
const appRoutes: Routes = [
  {path: 'vehicles/:vin', component: VehicleDetailComponent},
  {path: 'vehicles', component: VehicleListComponent},
  {path: 'alerts/vehicle/:vin', component: AlertDetailComponent},
  {path: 'readings/history', component: VehicleReadingsComponent},
  {path: 'maps', component: GoogleMapsComponent},
  {path: '', redirectTo: '/vehicles', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    VehicleDetailComponent,
    VehicleListComponent,
    AlertDetailComponent,
    VehicleReadingsComponent,
    GoogleMapsComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyA6Q7hAJvblHNL3ADHtzVU2BLM1rrbHA6Q'
    })
  ],
  providers: [VehicleService, AlertService, ReadingsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
