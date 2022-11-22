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
import { LoginComponent } from './discuisson-angular/component/login/login.component';
import { RegisterComponent } from './discuisson-angular/component/register/register.component';
import { BackgroundPourPageConnectionComponent } from './discuisson-angular/component/background-pour-page-connection/background-pour-page-connection.component';
import { SertARienDirective } from './discuisson-angular/directive/sert-arien.directive';
import { routes } from './routes';

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
    LoginComponent,
    RegisterComponent,
    BackgroundPourPageConnectionComponent,
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
