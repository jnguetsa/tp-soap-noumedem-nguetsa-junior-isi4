import { ComponentFixture, TestBed } from '@angular/core/testing';
import { SoapInfo } from './soap-info';

describe('SoapInfo', () => {
  let component: SoapInfo;
  let fixture: ComponentFixture<SoapInfo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SoapInfo],
    }).compileComponents();

    fixture = TestBed.createComponent(SoapInfo);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
