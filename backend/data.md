<div class="bg-white p-6 rounded-xl shadow-md border border-slate-100">
  <h2 class="text-xl font-bold text-slate-800 mb-4">Ajout compte</h2>
  <form (ngSubmit)="enregistrer()" class="space-y-4">
    <div>
      <label class="block text-sm font-medium text-slate-700 mb-1">ID Utilisateur</label>
      <input type="number" [(ngModel)]="utilisateurId" name="utilisateurId" required
             class="w-full px-4 py-2 border border-slate-300 rounded-lg focus:ring-2 focus:ring-emerald-500 focus:outline-none">
    </div>
    <div>
      <label class="block text-sm font-medium text-slate-700 mb-1">Numéro compte</label>
      <input type="text" [(ngModel)]="compte.numeroCompte" name="numeroCompte" required
             class="w-full px-4 py-2 border border-slate-300 rounded-lg focus:ring-2 focus:ring-emerald-500 focus:outline-none">
    </div>
    <div>
      <label class="block text-sm font-medium text-slate-700 mb-1">Type compte</label>
      <input type="text" [(ngModel)]="compte.typeCompte" name="typeCompte" required
             class="w-full px-4 py-2 border border-slate-300 rounded-lg focus:ring-2 focus:ring-emerald-500 focus:outline-none">
    </div>
    <div>
      <label class="block text-sm font-medium text-slate-700 mb-1">Solde</label>
      <input type="number" [(ngModel)]="compte.solde" name="solde" required
             class="w-full px-4 py-2 border border-slate-300 rounded-lg focus:ring-2 focus:ring-emerald-500 focus:outline-none">
    </div>
    <button type="submit"
            class="w-full bg-emerald-600 hover:bg-emerald-700 text-white font-medium py-2 px-4 rounded-lg transition-colors">
      Enregistrer
    </button>
  </form>
</div>

import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { CompteService } from '../../services/compte-service';

@Component({
imports: [FormsModule],
selector: 'app-compte-form',
styleUrl: './compte-form.css',
templateUrl: './compte-form.html',
standalone: true,
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
import { Component, inject } from '@angular/core';
import { Compte } from '../../modele/compte';
import { FormsModule } from '@angular/forms';
import { CurrencyPipe } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { CompteService } from '../../services/compte-service';

@Component({
imports: [FormsModule, CurrencyPipe],
selector: 'app-compte-list',
styleUrl: './compte-list.css',
templateUrl: './compte-list.html',
})
export class CompteList {
utilisateurId!: number;
comptes: Compte[] = [];
private compteService = inject(CompteService);

rechercher() {
if (!this.utilisateurId) return;
this.compteService.getByUtilisateur(this.utilisateurId).subscribe({
next: (data) => (this.comptes = data),
error: (err:HttpErrorResponse) => console.error(err),
});
}
}
<div class="bg-white p-6 rounded-xl shadow-md border border-slate-100">
  <h2 class="text-xl font-bold text-slate-800 mb-4">Liste des comptes par utilisateur</h2>

  <div class="flex gap-3 mb-6">
    <input type="number" [(ngModel)]="utilisateurId" placeholder="Saisir ID Utilisateur"
           class="flex-1 px-4 py-2 border border-slate-300 rounded-lg focus:ring-2 focus:ring-emerald-500 focus:outline-none">
    <button (click)="rechercher()"
            class="bg-slate-800 hover:bg-slate-900 text-white px-5 py-2 rounded-lg transition-colors font-medium">
      Charger
    </button>
  </div>

@if (comptes.length > 0){
<div class="overflow-x-auto" >
<table class="w-full text-left border-collapse">
<thead>
<tr class="border-b border-slate-200 bg-slate-50 text-slate-600 text-sm">
<th class="p-3">ID</th>
<th class="p-3">Numéro</th>
<th class="p-3">Type</th>
<th class="p-3">Solde</th>
</tr>
</thead>
<tbody>

          @for (compte of comptes; track $index ){
            <tr  class="border-b border-slate-100 hover:bg-slate-50 text-slate-700">
              <td class="p-3 font-semibold">{{ compte.id }}</td>
              <td class="p-3">{{ compte.numeroCompte }}</td>
              <td class="p-3"><span class="bg-slate-100 text-slate-700 px-2 py-1 rounded text-xs uppercase">{{ compte.typeCompte }}</span></td>
              <td class="p-3 font-mono font-bold text-emerald-600">{{ compte.solde | currency:'EUR' }}</td>
            </tr>
          }

        </tbody>
      </table>
    </div>
}


</div>
import { Component, inject } from '@angular/core';
import { SoapResponse } from '../../modele/SoapResponse';
import { FormsModule } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { SoapService } from '../../services/soap-service';

@Component({
imports: [FormsModule],
selector: 'app-soap-info',
styleUrl: './soap-info.css',
templateUrl: './soap-info.html',
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
<div class="bg-amber-50/50 border border-amber-200 p-6 rounded-xl shadow-md">
  <h2 class="text-xl font-bold text-amber-900 mb-4">Consultation SOAP depuis l'interface</h2>

  <div class="flex gap-3 mb-6">
    <input type="number" [(ngModel)]="compteId" placeholder="Saisir ID Compte"
           class="flex-1 px-4 py-2 border border-amber-300 rounded-lg focus:ring-2 focus:ring-amber-500 focus:outline-none">
    <button (click)="consulterCategorie()"
            class="bg-amber-600 hover:bg-amber-700 text-white px-5 py-2 rounded-lg transition-colors font-medium">
      Consulter catégorie
    </button>
  </div>

@if (resultat){
<div  class="bg-white p-4 rounded-lg border border-amber-200 space-y-2 text-slate-700">
<p><strong>Numéro compte :</strong> <span class="font-mono text-slate-900">{{ resultat.numeroCompte }}</span></p>
<p><strong>Catégorie :</strong> <span class="px-2 py-0.5 bg-amber-100 text-amber-800 rounded font-semibold">{{ resultat.categorie }}</span></p>
<p><strong>Message :</strong> {{ resultat.message }}</p>
</div>
}
</div>


import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UtilisateurService } from '../../services/utilisateur-service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
imports: [FormsModule],
selector: 'app-utilisateur-form',
styleUrl: './utilisateur-form.css',
templateUrl: './utilisateur-form.html',
})
export class UtilisateurForm {
utilisateur = {
nom: '',
email: '',
};
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
<div class="bg-white p-6 rounded-xl shadow-md border border-slate-100">
  <h2 class="text-xl font-bold text-slate-800 mb-4">Ajout utilisateur</h2>
  <form (ngSubmit)="enregistrer()" class="space-y-4">
    <div>
      <label class="block text-sm font-medium text-slate-700 mb-1">Nom</label>
      <input type="text" [(ngModel)]="utilisateur.nom" name="nom" required
             class="w-full px-4 py-2 border border-slate-300 rounded-lg focus:ring-2 focus:ring-indigo-500 focus:outline-none">
    </div>
    <div>
      <label class="block text-sm font-medium text-slate-700 mb-1">Email</label>
      <input type="email" [(ngModel)]="utilisateur.email" name="email" required
             class="w-full px-4 py-2 border border-slate-300 rounded-lg focus:ring-2 focus:ring-indigo-500 focus:outline-none">
    </div>
    <button type="submit"
            class="w-full bg-indigo-600 hover:bg-indigo-700 text-white font-medium py-2 px-4 rounded-lg transition-colors">
      Enregistrer
    </button>
  </form>
</div>
import { Component, inject, OnInit } from '@angular/core';
import { Utilisateur } from '../../modele/utilisateur';
import { UtilisateurService } from '../../services/utilisateur-service';

@Component({
imports: [],
selector: 'app-utilisateur-list',
styleUrl: './utilisateur-list.css',
templateUrl: './utilisateur-list.html',
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
<div class="bg-white p-6 rounded-xl shadow-md border border-slate-100">
  <div class="flex justify-between items-center mb-4">
    <h2 class="text-xl font-bold text-slate-800">Liste des utilisateurs</h2>
    <button (click)="chargerUtilisateurs()" class="text-sm bg-slate-100 hover:bg-slate-200 text-slate-700 px-3 py-1 rounded">
      Actualiser
    </button>
  </div>

  <div class="overflow-x-auto">
    <table class="w-full text-left border-collapse">
      <thead>
      <tr class="border-b border-slate-200 bg-slate-50 text-slate-600 text-sm">
        <th class="p-3">ID</th>
        <th class="p-3">Nom</th>
        <th class="p-3">Email</th>
      </tr>
      </thead>
      <tbody>


        @for (user of utilisateurs; track $index){
          <tr  class="border-b border-slate-100 hover:bg-slate-50 text-slate-700">
            <td class="p-3 font-semibold">{{ user.id }}</td>
            <td class="p-3">{{ user.nom }}</td>
            <td class="p-3 text-slate-500">{{ user.email }}</td>
          </tr>
        }

        @if (utilisateurs.length === 0){
          <tr >
            <td colspan="3" class="p-4 text-center text-slate-400">Aucun utilisateur trouvé</td>
          </tr>
        }

      </tbody>
    </table>
  </div>
</div>
