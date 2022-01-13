import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-app-main',
  templateUrl: './app-main.component.html',
  styleUrls: ['./app-main.component.css']
})
export class AppMainComponent implements OnInit {
  private subs: Subscription[] = [];

  constructor(private httpClient: HttpClient) {
  }

  ngOnInit(): void {
  }
}
