import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CompteForm } from './compte-form';

describe('CompteForm', () => {
  let component: CompteForm;
  let fixture: ComponentFixture<CompteForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompteForm],
    }).compileComponents();

    fixture = TestBed.createComponent(CompteForm);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
