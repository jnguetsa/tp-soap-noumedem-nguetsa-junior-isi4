import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UtilisateurService } from '../../services/utilisateur-service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-utilisateur-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './utilisateur-form.html',
  styleUrl: './utilisateur-form.css',
})
export class UtilisateurForm {
  utilisateur = { nom: '', email: '' };
  private utilisateurService = inject(UtilisateurService);

  enregistrer() {
    this.utilisateurService.add(this.utilisateur).subscribe({
      next: () => {
        alert('Utilisateur ajouté avec succès');
        this.utilisateur = { nom: '', email: '' };
      },
      error: (err: HttpErrorResponse) => console.error(err),
    });
  }
}
