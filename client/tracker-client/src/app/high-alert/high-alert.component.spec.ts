import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HighAlertComponent } from './high-alert.component';

describe('HighAlertComponent', () => {
  let component: HighAlertComponent;
  let fixture: ComponentFixture<HighAlertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HighAlertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HighAlertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
