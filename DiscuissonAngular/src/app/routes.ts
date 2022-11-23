import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { AdminAdminEditComponent } from "./discuisson-angular/component/admin/admin-admin/admin-admin-edit/admin-admin-edit.component";
import { AdminAdminListComponent } from "./discuisson-angular/component/admin/admin-admin/admin-admin-list/admin-admin-list.component";
import { AdminHomeComponent } from "./discuisson-angular/component/admin/admin-home/admin-home.component";
import { AdminNutrionistEditComponent } from "./discuisson-angular/component/admin/admin-nutritionist/admin-nutrionist-edit/admin-nutrionist-edit.component";
import { AdminNutritionistListComponent } from "./discuisson-angular/component/admin/admin-nutritionist/admin-nutritionist-list/admin-nutritionist-list.component";
import { AdminUserEditComponent } from "./discuisson-angular/component/admin/admin-user/admin-user-edit/admin-user-edit.component";
import { AdminUserListComponent } from "./discuisson-angular/component/admin/admin-user/admin-user-list/admin-user-list.component";
import { FrigoComponent } from "./discuisson-angular/component/frigo/frigo.component";
import { IngredientEditComponent } from "./discuisson-angular/component/ingredient/ingredient-edit/ingredient-edit.component";
import { IngredientListComponent } from "./discuisson-angular/component/ingredient/ingredient-list/ingredient-list.component";
import { LoginComponent } from "./discuisson-angular/component/login/login.component";
import { MessageEditComponent } from "./discuisson-angular/component/message/message-edit/message-edit.component";
import { MessageListComponent } from "./discuisson-angular/component/message/message-list/message-list.component";
import { PageConceptComponent } from "./discuisson-angular/component/page/page-concept/page-concept.component";
import { PageHomeComponent } from "./discuisson-angular/component/page/page-home/page-home.component";
import { RecetteDetailsComponent } from "./discuisson-angular/component/recette/recette-details/recette-details.component";
import { RecetteEditComponent } from "./discuisson-angular/component/recette/recette-edit/recette-edit.component";
import { RecetteListComponent } from "./discuisson-angular/component/recette/recette-list/recette-list.component";
import { RegisterComponent } from "./discuisson-angular/component/register/register.component";
import { UserToVIPComponent } from "./discuisson-angular/component/user-to-vip/user-to-vip.component";


export const routes: Routes = [
  { path: 'home', component: PageHomeComponent },
  { path: 'concept', component: PageConceptComponent },
  { path: 'ingredient', component: IngredientListComponent },
  { path: 'ingredient/edit', component: IngredientEditComponent },
  { path: 'ingredient/edit/:id', component: IngredientEditComponent },
  { path: 'recette', component: RecetteListComponent },
  { path: 'recette/edit', component: RecetteEditComponent },
  { path: 'recette/edit/:id', component: RecetteEditComponent },
  { path: 'recette/details/:id', component: RecetteDetailsComponent },
  { path: 'admin', component: AdminHomeComponent },
  { path: 'admin/admin', component: AdminAdminListComponent },
  { path: 'admin/edit', component: AdminAdminEditComponent },
  { path: 'admin/edit/:id', component: AdminAdminEditComponent },
  { path: 'user/user', component: AdminUserListComponent },
  { path: 'user/edit', component: AdminUserEditComponent },
  { path: 'user/edit/:id', component: AdminUserEditComponent },
  {
    path: 'nutrionniste/nutrionniste',
    component: AdminNutritionistListComponent,
  },
  { path: 'nutrionniste/edit', component: AdminNutrionistEditComponent },
  { path: 'nutrionniste/edit/:id', component: AdminNutrionistEditComponent },
  { path: 'frigo', component: FrigoComponent },
  { path: 'userVIP', component: UserToVIPComponent },
  { path: 'login', component: LoginComponent },
  { path: 'inscription', component: RegisterComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'message', component: MessageListComponent },
  { path: 'message/edit', component: MessageEditComponent },
  { path: 'message/edit/:id', component: MessageEditComponent },
  { path: '**', component: PageHomeComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
