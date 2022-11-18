import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SertARienComponent } from './discuisson-angular/component/sert-arien/sert-arien.component';
import { SertARienDirective } from './discuisson-angular/directive/sert-arien.directive';

@NgModule({
  declarations: [
    AppComponent,
    SertARienComponent,
    SertARienDirective
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
