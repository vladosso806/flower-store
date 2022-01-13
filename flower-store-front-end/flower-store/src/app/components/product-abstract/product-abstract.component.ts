import {CartService} from '../../services/cart.service';

export abstract class ProductAbstractComponent {
  protected constructor(protected cartService: CartService) {
  }

  addToCart(productId: number): void {
    this.cartService.addToCart(productId);
  }
}

