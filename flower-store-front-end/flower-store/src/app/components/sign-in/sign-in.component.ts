import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

  form = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });
  error: Error;

  constructor() {
    this.form.controls.username.setValue('');
    this.form.controls.password.setValue('');
  }

  ngOnInit(): void {
  }

  submit(): void {

  }
}
