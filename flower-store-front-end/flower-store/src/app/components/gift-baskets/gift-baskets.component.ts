import { Component, OnInit } from '@angular/core';
import {ProductModel} from '../../model/product.model';
import {GlobalService} from '../../services/global.service';
import {BASE_URL, FLORARIUMS, GIFT_BASKETS} from '../../constants/api-routes.constants';

@Component({
  selector: 'app-gift-baskets',
  templateUrl: './gift-baskets.component.html',
  styleUrls: ['../bouquets/bouquets.component.scss']
})
export class GiftBasketsComponent implements OnInit {
  products: ProductModel[] = [];
  isLoaded = false;

  constructor(private globalService: GlobalService) { }

  ngOnInit(): void {
    this.globalService.client().get(`${BASE_URL}${GIFT_BASKETS}`).subscribe((data: ProductModel[]) => {
      this.products = data;
      this.isLoaded = true;
    });
  }
}
