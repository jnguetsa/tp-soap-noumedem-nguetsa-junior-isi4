import { inject, Service } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Service()
export class Compte {
  private apiUrl: string = 'http://localhost:8080/api/comptes';
  private http = inject(HttpClient);
  getByUtilisateur(utilisateurId: number): Observable<Compte[]> {
    return this.http.get<Compte[]>(`${this.apiUrl}/utilisateur/${utilisateurId}`);
  }
  add(utilisateurId: number, compte: Compte): Observable<Compte> {
    return this.http.post<Compte>(`${this.apiUrl}/utilisateur/${utilisateurId}`, compte);
  }
}
