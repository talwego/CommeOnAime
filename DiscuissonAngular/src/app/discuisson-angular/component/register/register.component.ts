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
      genre: new FormControl('0'),
      age: new FormControl('0'),
      taille: new FormControl('0'),
      poids: new FormControl('0'),
      vegetarien: new FormControl(false),
      vegan: new FormControl(false),
      compteVIP: new FormControl(false),
      activitePhysique: new FormControl('1'),
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

  contientLogin(control: AbstractControl): ValidationErrors | null {
    let password = control.get('groupePassword.password');
    return password?.value
      .toString()
      .includes(control.get('login')?.value.toString())
      ? { contientLogin: true }
      : null;
  }

  save() {
    let user = {
      login: this.form.get('groupeInfo.login')?.value,
      password: this.form.get('groupeInfo.groupePassword.password')?.value,};
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
        this.router.navigateByUrl('/login');
      });
    }
  }
}
