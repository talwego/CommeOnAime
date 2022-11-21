import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { IngredientEditComponent } from './discuisson-angular/component/ingredient/ingredient-edit/ingredient-edit.component';
import { IngredientListComponent } from './discuisson-angular/component/ingredient/ingredient-list/ingredient-list.component';
import { SertARienDirective } from './discuisson-angular/directive/sert-arien.directive';
import { routes } from './routes';
import { IngredientMenuComponent } from './discuisson-angular/component/ingredient/ingredient-menu/ingredient-menu.component';
import { MenuComponent } from './discuisson-angular/component/menu/menu.component';
import { FooterComponent } from './discuisson-angular/component/footer/footer.component';
import { PageConceptComponent } from './discuisson-angular/component/page/page-concept/page-concept.component';
import { PageHomeComponent } from './discuisson-angular/component/page/page-home/page-home.component';
import { PageHomeBackgroundComponent } from './discuisson-angular/component/page/page-home/page-home-background/page-home-background.component';
import { RecetteEditComponent } from './discuisson-angular/component/recette/recette-edit/recette-edit.component';
import { RecetteListComponent } from './discuisson-angular/component/recette/recette-list/recette-list.component';


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
