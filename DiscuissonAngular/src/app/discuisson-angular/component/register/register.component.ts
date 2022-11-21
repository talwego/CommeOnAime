/*import { Component, OnInit } from '@angular/core';
import { AbstractControl, AsyncValidatorFn, FormControl, FormGroup, ValidationErrors, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, map } from 'rxjs';
import { AuthenticationService } from '../../service/authentication.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})


export class RegisterComponent implements OnInit {
  form!: FormGroup;

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
  this.form = new FormGroup({
    genre: new FormControl(),
    naissance: new FormControl(),
    taille: new FormControl(),
    poids: new FormControl(),
    vegetarien: new FormControl(''),
    vegan: new FormControl(''),
    activitePhysique: new FormControl(''),
    groupeInfo: new FormGroup(
      {
        login: new FormControl('',[Validators.required, Validators.login, Validators.minLength(2)],this.loginNotExists()),
        groupePassword: new FormGroup(
          {password: new FormControl('', Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@*!-_])([a-zA-Z0-9@*!-_]{4,25})$/)),confirmation: new FormControl(),},
          this.passwordAndConfirmationEquals
        ),
      },
      this.contientLogin
    ),
  });
}

loginNotExists(): AsyncValidatorFn {
  return (control: AbstractControl): Observable<ValidationErrors | null> => {
    return this.userService.checkLoginExists(control.value).pipe(
      map((bool) => {
        return bool ? { loginExists: true } : null;
      })
    );
  };
}

passwordAndConfirmatonEquals(control: AbstractControl): ValidationErrors | null {
  let password = control.get('password');
  if (password?.invalid) {return null;}
  return password?.value == control.get('confirmation')?.value ? null: { passwordAndConfirmationNotEquals: true };}


save() {let user = {naissance: this.form.get('naissance')?.value, compte: {login: this.form.get('login')?.value, password: this.form.get('groupeInfo.groupePassword.password')?.value,},};
  if (
    this.form.get('genre')?.value || this.form.get('taille')?.value || this.form.get('poids')?.value || this.form.get('vegetarien')?.value || this.form.get('vegan')?.value || this.form.get('activitePhysique')?.value){
    Object.assign(user, {
      caracteristiques: {
        genre: this.form.get('genre')?.value,
        taille: this.form.get('taille')?.value,
        poids: this.form.get('poids')?.value,
        vegetarien: this.form.get('vegetarien')?.value,
        vegan: this.form.get('vegan')?.value,
        activitePhysique: this.form.get('activitePhysique')?.value,
      },
    });
  }
  this.userService.inscription(user).subscribe((data) => {this.router.navigateByUrl('/home');});
}
}
*/
