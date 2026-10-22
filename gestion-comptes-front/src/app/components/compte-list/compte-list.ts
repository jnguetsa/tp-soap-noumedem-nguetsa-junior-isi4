import { Component, inject } from '@angular/core';
import { Compte } from '../../modele/compte';
import { FormsModule } from '@angular/forms';
import { CurrencyPipe } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { CompteService } from '../../services/compte-service';
import { SoapService } from '../../services/soap-service';

@Component({
  selector: 'app-compte-list',
  standalone: true,
  imports: [FormsModule, CurrencyPipe],
  templateUrl: './compte-list.html',
  styleUrl: './compte-list.css',
})
export class CompteList {
  utilisateurId!: number;
  comptes: Compte[] = [];

  private compteService = inject(CompteService);
  private soapService = inject(SoapService);

  rechercher() {
    if (!this.utilisateurId) return;
    this.compteService.getByUtilisateur(this.utilisateurId).subscribe({
      next: (data) => (this.comptes = data),
      error: (err: HttpErrorResponse) => console.error(err),
    });
  }

  voirCategorieSoap(compteId?: number) {
    if (!compteId) return;
    this.soapService.getCategorieCompte(compteId).subscribe({
      next: (res) => {
        alert(
          `Numéro de compte : ${res.numeroCompte}\nCatégorie : ${res.categorie}\nMessage : ${res.message}`,
        );
      },
      error: (err: HttpErrorResponse) => console.error(err),
    });
  }
}
