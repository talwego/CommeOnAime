import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators,
  AbstractControl,
  ValidationErrors,
} from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  form!: FormGroup;

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      genre: new FormControl(),
      age: new FormControl(),
      taille: new FormControl(),
      poids: new FormControl(),
      vegetarien: new FormControl(''),
      vegan: new FormControl(''),
      compteVIP: new FormControl(''),
      activitePhysique: new FormControl(''),
      groupeInfo: new FormGroup(
        {
          login: new FormControl('', [Validators.required]),
          groupePassword: new FormGroup(
            {
              password: new FormControl(
                '',
                Validators.pattern(
                  /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@*!-_])([a-zA-Z0-9@*!-_]{4,25})$/
                )
              ),
              confirmation: new FormControl(),
            },
            this.passwordAndConfirmationEquals
          ),
        },
        this.contientLogin
      ),
    });
  }

  contientLogin(control: AbstractControl): ValidationErrors | null {
    let password = control.get('groupePassword.password');
    return password?.value
      .toString()
      .includes(control.get('login')?.value.toString())
      ? { contientLogin: true }
      : null;
  }

  passwordAndConfirmationEquals(
    control: AbstractControl
  ): ValidationErrors | null {
    let password = control.get('password');
    if (password?.invalid) {
      return null;
    }
    return password?.value == control.get('confirmation')?.value
      ? null
      : { passwordAndConfirmationNotEquals: true };
  }

  save() {
    let user = {
      login: this.form.get('groupeInfo.login')?.value,
      password: this.form.get('groupeInfo.groupePassword.password')?.value,
    };
    if (
      this.form.get('compteVIP')?.value ||
      this.form.get('age')?.value ||
      this.form.get('genre')?.value ||
      this.form.get('taille')?.value ||
      this.form.get('poids')?.value ||
      this.form.get('vegetarien')?.value ||
      this.form.get('vegan')?.value ||
      this.form.get('activitePhysique')?.value
    ) {
      Object.assign(user, {
        age: this.form.get('age')?.value,
        genre: this.form.get('genre')?.value,
        taille: this.form.get('taille')?.value,
        poids: this.form.get('poids')?.value,
        vegetarien: this.form.get('vegetarien')?.value,
        vegan: this.form.get('vegan')?.value,
        compteVIP: this.form.get('compteVIP')?.value,
        activitePhysique: this.form.get('activitePhysique')?.value,
      });
      console.log(user);
      this.userService.create(user).subscribe((data) => {
        this.router.navigateByUrl('/home');
      });
    }
  }
}
