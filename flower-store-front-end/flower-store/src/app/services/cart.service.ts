import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  public cartStorage: [{productId: number, quantity: number}];

  constructor() {
    const localStorageCart = localStorage.getItem('cart');
    this.cartStorage = localStorageCart ? JSON.parse(localStorageCart) : [];
  }

  addToCart(productId: number, quantity: number = 1): void {
    this.cartStorage.push( {productId, quantity } );
    localStorage.setItem('cart', JSON.stringify(this.cartStorage));
  }

  clearCart(): void {
    localStorage.setItem('cart', '');
    const localStorageCart = localStorage.getItem('cart');
    this.cartStorage = localStorageCart ? JSON.parse(localStorageCart) : [];
  }
}
