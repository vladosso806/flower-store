import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class GlobalService {
  constructor(private readonly httpClient: HttpClient) { }

  public client = (): HttpClient => this.httpClient;
}
