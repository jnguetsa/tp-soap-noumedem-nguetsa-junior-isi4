import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SoapResponse } from '../modele/SoapResponse';

@Injectable({
  providedIn: 'root',
})
export class SoapService {
  private apiUrl = 'http://localhost:8080/api/soap';
  private http = inject(HttpClient);

  getCategorieCompte(compteId: number): Observable<SoapResponse> {
    return this.http.get<SoapResponse>(`${this.apiUrl}/compte/${compteId}/categorie`);
  }
}
