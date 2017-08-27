import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleReadingsComponent } from './vehicle-readings.component';

describe('VehicleReadingsComponent', () => {
  let component: VehicleReadingsComponent;
  let fixture: ComponentFixture<VehicleReadingsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VehicleReadingsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VehicleReadingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
