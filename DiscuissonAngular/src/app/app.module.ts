import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { SertARienDirective } from './discuisson-angular/directive/sert-arien.directive';
import { routes } from './routes';
import { IngredientComponent } from './discuisson-angular/component/ingredient/ingredient.component';
import { RecetteComponent } from './discuisson-angular/component/recette/recette.component';
import { RecetteListComponent } from './discuisson-angular/component/recette/recette-list/recette-list.component';
import { RecetteEditComponent } from './discuisson-angular/component/recette/recette-edit/recette-edit.component';

@NgModule({
  declarations: [AppComponent, SertARienDirective, IngredientComponent, RecetteComponent, RecetteListComponent, RecetteEditComponent],
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
