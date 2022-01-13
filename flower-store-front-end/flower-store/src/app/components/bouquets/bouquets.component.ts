import {Component, OnInit} from '@angular/core';
import {GlobalService} from '../../services/global.service';
import {BASE_URL, BOUQUETS} from '../../constants/api-routes.constants';
import {ProductModel} from '../../model/product.model';
import {ProductAbstractComponent} from '../product-abstract/product-abstract.component';
import {CartService} from '../../services/cart.service';

@Component({
  selector: 'app-bouquets',
  templateUrl: './bouquets.component.html',
  styleUrls: ['./bouquets.component.scss']
})
export class BouquetsComponent extends ProductAbstractComponent implements OnInit {
  bouquetsModels: ProductModel[] = [];
  isLoaded = false;

  constructor(private globalService: GlobalService, protected cartService: CartService) {
    super(cartService);
  }

  ngOnInit(): void {
    this.globalService.client().get(`${BASE_URL}${BOUQUETS}`).subscribe((data: ProductModel[]) => {
      this.bouquetsModels = data;
      this.isLoaded = true;
    });
  }
}
