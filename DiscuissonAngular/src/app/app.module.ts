import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { SertARienComponent } from './discuisson-angular/component/sert-arien/sert-arien.component';
import { SertARienDirective } from './discuisson-angular/directive/sert-arien.directive';
import { routes } from './routes';
import { IngredientComponent } from './discuisson-angular/component/ingredient/ingredient.component';

@NgModule({
  declarations: [AppComponent, SertARienComponent, SertARienDirective, IngredientComponent],
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
