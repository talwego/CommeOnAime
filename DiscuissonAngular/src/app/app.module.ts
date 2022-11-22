import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { FooterComponent } from './discuisson-angular/component/footer/footer.component';
import { IngredientEditComponent } from './discuisson-angular/component/ingredient/ingredient-edit/ingredient-edit.component';
import { IngredientListComponent } from './discuisson-angular/component/ingredient/ingredient-list/ingredient-list.component';
import { IngredientMenuComponent } from './discuisson-angular/component/ingredient/ingredient-menu/ingredient-menu.component';
import { MenuComponent } from './discuisson-angular/component/menu/menu.component';
import { PageConceptComponent } from './discuisson-angular/component/page/page-concept/page-concept.component';
import { PageHomeBackgroundComponent } from './discuisson-angular/component/page/page-home/page-home-background/page-home-background.component';
import { PageHomeComponent } from './discuisson-angular/component/page/page-home/page-home.component';
import { RecetteEditComponent } from './discuisson-angular/component/recette/recette-edit/recette-edit.component';
import { RecetteListComponent } from './discuisson-angular/component/recette/recette-list/recette-list.component';
import { SertARienDirective } from './discuisson-angular/directive/sert-arien.directive';
import { routes } from './routes';
import { AdminHomeComponent } from './discuisson-angular/component/admin/admin-home/admin-home.component';
import { AdminUserListComponent } from './discuisson-angular/component/admin/admin-user/admin-user-list/admin-user-list.component';
import { AdminAdminListComponent } from './discuisson-angular/component/admin/admin-admin/admin-admin-list/admin-admin-list.component';
import { AdminNutritionistListComponent } from './discuisson-angular/component/admin/admin-nutritionist/admin-nutritionist-list/admin-nutritionist-list.component';
import { FrigoComponent } from './discuisson-angular/component/frigo/frigo.component';

@NgModule({
  declarations: [
    AppComponent,
    SertARienDirective,
    MenuComponent,
    IngredientEditComponent,
    IngredientListComponent,
    IngredientMenuComponent,
    FooterComponent,
    PageConceptComponent,
    PageHomeComponent,
    PageHomeBackgroundComponent,
    RecetteEditComponent,
    RecetteListComponent,
    AdminHomeComponent,
    AdminUserListComponent,
    AdminAdminListComponent,
    AdminNutritionistListComponent,
    FrigoComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
