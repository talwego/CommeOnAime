import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IngredientEditComponent } from './discuisson-angular/component/ingredient/ingredient-edit/ingredient-edit.component';
import { IngredientListComponent } from './discuisson-angular/component/ingredient/ingredient-list/ingredient-list.component';
import { PageConceptComponent } from './discuisson-angular/component/page/page-concept/page-concept.component';
import { PageHomeComponent } from './discuisson-angular/component/page/page-home/page-home.component';
export const routes: Routes = [
  { path: 'home', component: PageHomeComponent },
  { path: 'concept', component: PageConceptComponent },
  { path: 'ingredient', component: IngredientListComponent },
  { path: 'ingredient/edit', component: IngredientEditComponent },
  { path: 'ingredient/edit/:id', component: IngredientEditComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
