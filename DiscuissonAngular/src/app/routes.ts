import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IngredientEditComponent } from './discuisson-angular/component/ingredient/ingredient-edit/ingredient-edit.component';
import { IngredientListComponent } from './discuisson-angular/component/ingredient/ingredient-list/ingredient-list.component';
import { PageConceptComponent } from './discuisson-angular/component/page/page-concept/page-concept.component';
import { PageHomeComponent } from './discuisson-angular/component/page/page-home/page-home.component';
import { RecetteEditComponent } from './discuisson-angular/component/recette/recette-edit/recette-edit.component';
import { RecetteListComponent } from './discuisson-angular/component/recette/recette-list/recette-list.component';

export const routes: Routes = [
  { path: 'home', component: PageHomeComponent },
  { path: 'concept', component: PageConceptComponent },
  { path: 'ingredient', component: IngredientListComponent },
  { path: 'ingredient/edit', component: IngredientEditComponent },
  { path: 'ingredient/edit/:id', component: IngredientEditComponent },
  { path: 'recette', component: RecetteListComponent },
  { path: 'recette/edit', component: RecetteEditComponent },
  { path: 'recette/edit/:id', component: RecetteEditComponent },
  { path: 'admin', component: AdminHomeComponent },
  { path: 'admin/admin', component: AdminAdminListComponent },
  { path: 'admin/user', component: AdminUserListComponent },
  { path: 'admin/nutrionniste', component: AdminNutritionistListComponent },
  { path: 'frigo', component: FrigoComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
