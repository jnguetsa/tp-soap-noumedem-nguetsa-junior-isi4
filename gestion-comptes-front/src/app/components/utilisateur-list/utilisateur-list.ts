import { Component, inject, OnInit } from '@angular/core';
import { Utilisateur } from '../../modele/utilisateur';
import { UtilisateurService } from '../../services/utilisateur-service';

@Component({
  selector: 'app-utilisateur-list',
  standalone: true,
  imports: [],
  templateUrl: './utilisateur-list.html',
  styleUrl: './utilisateur-list.css',
})
export class UtilisateurList implements OnInit {
  private userService = inject(UtilisateurService);
  utilisateurs: Utilisateur[] = [];

  ngOnInit(): void {
    this.chargerUtilisateurs();
  }

  chargerUtilisateurs() {
    this.userService.getAll().subscribe({
      next: (data) => (this.utilisateurs = data),
      error: (err) => console.error(err),
    });
  }
}
