import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Utilisateur } from '../modele/utilisateur';

@Injectable({
  providedIn: 'root',
})
export class UtilisateurService {
  private apiUrl = 'http://localhost:8080/api/utilisateurs';
  private http = inject(HttpClient);

  getAll(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(this.apiUrl);
  }

  add(utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.http.post<Utilisateur>(this.apiUrl, utilisateur);
  }
}
