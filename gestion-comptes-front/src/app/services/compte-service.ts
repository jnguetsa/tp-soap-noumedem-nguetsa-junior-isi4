import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Compte } from '../modele/compte';

@Injectable({
  providedIn: 'root',
})
export class CompteService {
  private apiUrl = 'http://localhost:8080/api/comptes';
  private http = inject(HttpClient);

  getByUtilisateur(utilisateurId: number): Observable<Compte[]> {
    return this.http.get<Compte[]>(`${this.apiUrl}/utilisateur/${utilisateurId}`);
  }

  add(utilisateurId: number, compte: Compte): Observable<Compte> {
    return this.http.post<Compte>(`${this.apiUrl}/utilisateur/${utilisateurId}`, compte);
  }
}
