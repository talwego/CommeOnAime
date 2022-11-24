import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, AbstractControl, ValidationErrors } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/discuisson-angular/service/user.service';

@Component({
  selector: 'app-page-mon-compte',
  templateUrl: './page-mon-compte.component.html',
  styleUrls: ['./page-mon-compte.component.css']
})
export class PageMonCompteComponent implements OnInit {
  form!: FormGroup;
  genre! : number
  age! : number
  taille! : number
  poids! : number
  vegetarien! : boolean
  vegan! : boolean
  compteVIP! : boolean
  activitePhysique! : number


  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {

    this.form = new FormGroup({
      genre: new FormControl(JSON.parse(sessionStorage.getItem( 'compte')!).genre),
      age: new FormControl(JSON.parse(sessionStorage.getItem( 'compte')!).age),
      taille: new FormControl(JSON.parse(sessionStorage.getItem( 'compte')!).taille),
      poids: new FormControl(JSON.parse(sessionStorage.getItem( 'compte')!).poids),
      vegetarien: new FormControl(JSON.parse(sessionStorage.getItem( 'compte')!).vegetarien),
      vegan: new FormControl(JSON.parse(sessionStorage.getItem( 'compte')!).vegan),
      compteVIP: new FormControl(JSON.parse(sessionStorage.getItem( 'compte')!).compteVIP),
      activitePhysique: new FormControl(JSON.parse(sessionStorage.getItem( 'compte')!).activitePhysique),
    });
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
      this.userService.update(user).subscribe((data) => {
        this.router.navigateByUrl('/home');
      });
    }
  }
}
