import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IngredientComponent } from './discuisson-angular/component/ingredient/ingredient.component';
import { AuthGuard } from './helpers/auth.guard';
import { SecretComponent } from './secret/secret.component';

export const routes: Routes = [
  { path: 'home', component: IngredientComponent },
  { path: 'ingredient', component: IngredientComponent },

{ path: '',  component: SecretComponent,  canActivate: [AuthGuard],
},

];

@NgModule({
imports: [RouterModule.forRoot(routes)],
exports: [RouterModule],
})
export class AppRoutingModule {}
