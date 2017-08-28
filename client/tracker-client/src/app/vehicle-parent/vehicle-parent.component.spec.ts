import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleParentComponent } from './vehicle-parent.component';

describe('VehicleParentComponent', () => {
  let component: VehicleParentComponent;
  let fixture: ComponentFixture<VehicleParentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VehicleParentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VehicleParentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
