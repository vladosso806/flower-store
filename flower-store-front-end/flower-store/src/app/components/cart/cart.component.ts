import {Component, OnInit} from '@angular/core';
import {CartService} from '../../services/cart.service';
import {GlobalService} from '../../services/global.service';
import {BASE_URL, PRODUCTS} from '../../constants/api-routes.constants';
import {ProductModel} from '../../model/product.model';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['../bouquets/bouquets.component.scss']
})
export class CartComponent implements OnInit {

  isLoaded = false;
  products = [];

  constructor(private cartService: CartService, private globalService: GlobalService) {
  }

  // array.reduce((r, a) => {
  // r[a.productId] = [...r[a.productId] || [], a];
  // return r;
// }, {});

  async ngOnInit(): Promise<any> {
    this.cartService.cartStorage.forEach(cartProduct => {
      this.globalService.client().get(`${BASE_URL}${PRODUCTS}/${cartProduct.productId}`).subscribe((data: ProductModel) => {
        this.isLoaded = false;
        this.products.push({
          product: data,
          quantity: cartProduct.quantity,
          fullPrice: data.price * cartProduct.quantity
        });
        this.isLoaded = true;
      });
    });
  }

  clearCart(): void {
    this.cartService.clearCart();
  }
}
