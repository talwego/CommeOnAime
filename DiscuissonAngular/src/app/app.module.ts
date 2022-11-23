import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { RouterModule } from "@angular/router";
import { AppComponent } from "./app.component";
import { AdminAdminEditComponent } from "./discuisson-angular/component/admin/admin-admin/admin-admin-edit/admin-admin-edit.component";
import { AdminAdminListComponent } from "./discuisson-angular/component/admin/admin-admin/admin-admin-list/admin-admin-list.component";
import { AdminHomeComponent } from "./discuisson-angular/component/admin/admin-home/admin-home.component";
import { AdminNutrionistEditComponent } from "./discuisson-angular/component/admin/admin-nutritionist/admin-nutrionist-edit/admin-nutrionist-edit.component";
import { AdminNutritionistListComponent } from "./discuisson-angular/component/admin/admin-nutritionist/admin-nutritionist-list/admin-nutritionist-list.component";
import { AdminUserEditComponent } from "./discuisson-angular/component/admin/admin-user/admin-user-edit/admin-user-edit.component";
import { AdminUserListComponent } from "./discuisson-angular/component/admin/admin-user/admin-user-list/admin-user-list.component";
import { BackgroundPourPageConnectionComponent } from "./discuisson-angular/component/background-pour-page-connection/background-pour-page-connection.component";
import { FooterComponent } from "./discuisson-angular/component/footer/footer.component";
import { FrigoBackgroundComponent } from "./discuisson-angular/component/frigo/frigo-background/frigo-background.component";
import { FrigoComponent } from "./discuisson-angular/component/frigo/frigo.component";
import { IngredientEditComponent } from "./discuisson-angular/component/ingredient/ingredient-edit/ingredient-edit.component";
import { IngredientListComponent } from "./discuisson-angular/component/ingredient/ingredient-list/ingredient-list.component";
import { IngredientMenuComponent } from "./discuisson-angular/component/ingredient/ingredient-menu/ingredient-menu.component";
import { LoginComponent } from "./discuisson-angular/component/login/login.component";
import { MenuComponent } from "./discuisson-angular/component/menu/menu.component";
import { MessageEditComponent } from "./discuisson-angular/component/message/message-edit/message-edit.component";
import { MessageListComponent } from "./discuisson-angular/component/message/message-list/message-list.component";
import { PageConceptComponent } from "./discuisson-angular/component/page/page-concept/page-concept.component";
import { PageHomeBackgroundComponent } from "./discuisson-angular/component/page/page-home/page-home-background/page-home-background.component";
import { PageHomeComponent } from "./discuisson-angular/component/page/page-home/page-home.component";
import { RecetteDetailsComponent } from "./discuisson-angular/component/recette/recette-details/recette-details.component";
import { RecetteEditComponent } from "./discuisson-angular/component/recette/recette-edit/recette-edit.component";
import { RecetteListComponent } from "./discuisson-angular/component/recette/recette-list/recette-list.component";
import { RegisterComponent } from "./discuisson-angular/component/register/register.component";
import { UserToVIPComponent } from "./discuisson-angular/component/user-to-vip/user-to-vip.component";
import { SertARienDirective } from "./discuisson-angular/directive/sert-arien.directive";
import { routes } from "./routes";



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
    RecetteDetailsComponent,
    UserToVIPComponent,
    FrigoBackgroundComponent,
    RegisterComponent,
    LoginComponent,
    BackgroundPourPageConnectionComponent,
    MessageListComponent,
    MessageEditComponent,
    AdminAdminEditComponent,
    AdminUserEditComponent,
    AdminNutrionistEditComponent,
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
