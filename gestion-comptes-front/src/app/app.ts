import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CompteForm } from './components/compte-form/compte-form';
import { CompteList } from './components/compte-list/compte-list';
import { SoapInfo } from './components/soap-info/soap-info';
import { UtilisateurForm } from './components/utilisateur-form/utilisateur-form';
import { UtilisateurList } from './components/utilisateur-list/utilisateur-list';

@Component({
  imports: [RouterOutlet, CompteForm, CompteList, SoapInfo, UtilisateurForm, UtilisateurList],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('gestion-comptes-front');
}
