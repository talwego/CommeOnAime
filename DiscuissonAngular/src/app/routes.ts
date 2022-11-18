import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IngredientListComponent } from './discuisson-angular/component/ingredient/ingredient-list/ingredient-list.component';
export const routes: Routes = [
  { path: 'home', component: IngredientListComponent },
  { path: 'ingredient', component: IngredientListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
