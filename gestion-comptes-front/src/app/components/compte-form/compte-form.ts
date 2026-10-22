import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { CompteService } from '../../services/compte-service';

@Component({
  selector: 'app-compte-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './compte-form.html',
  styleUrl: './compte-form.css',
})
export class CompteForm {
  utilisateurId!: number;
  compte = { numeroCompte: '', typeCompte: '', solde: 0 };
  private compteService = inject(CompteService);

  enregistrer() {
    this.compteService.add(this.utilisateurId, this.compte).subscribe({
      next: () => {
        alert('Compte ajouté avec succès');
        this.compte = { numeroCompte: '', typeCompte: '', solde: 0 };
      },
      error: (err: HttpErrorResponse) => console.error(err),
    });
  }
}
