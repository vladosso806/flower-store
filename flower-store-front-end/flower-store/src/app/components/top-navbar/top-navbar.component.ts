import {Component, OnInit} from '@angular/core';
import {CartService} from '../../services/cart.service';
import {observable, Observable, Subscriber} from 'rxjs';

@Component({
  selector: 'app-top-navbar',
  templateUrl: './top-navbar.component.html',
  styleUrls: ['./top-navbar.component.css']
})
export class TopNavbarComponent implements OnInit {

  cartQuantity;
  isLoaded = false;

  constructor(private cartService: CartService) {
    const observable = new Observable((observer: Subscriber<number>) =>
      observer.next(cartService.cartStorage.length));
    observable.subscribe(newLength => {
      this.isLoaded = false;
      this.cartQuantity = newLength;
      this.isLoaded = true;
    });
  }

  ngOnInit(): void {
  }

}
