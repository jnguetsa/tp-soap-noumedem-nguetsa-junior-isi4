import { Component, inject } from '@angular/core';
import { SoapResponse } from '../../modele/SoapResponse';
import { FormsModule } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { SoapService } from '../../services/soap-service';

@Component({
  selector: 'app-soap-info',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './soap-info.html',
  styleUrl: './soap-info.css',
})
export class SoapInfo {
  compteId!: number;
  resultat: SoapResponse | null = null;
  private soapService = inject(SoapService);

  consulterCategorie() {
    if (!this.compteId) return;
    this.soapService.getCategorieCompte(this.compteId).subscribe({
      next: (res) => (this.resultat = res),
      error: (err: HttpErrorResponse) => console.error(err),
    });
  }
}
