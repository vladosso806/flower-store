import { Component, OnInit } from '@angular/core';
import {ProductModel} from '../../model/product.model';
import {GlobalService} from '../../services/global.service';
import {BASE_URL, FLORARIUMS, FLOWER_ARRANGEMENTS} from '../../constants/api-routes.constants';

@Component({
  selector: 'app-flower-arrangements',
  templateUrl: './flower-arrangements.component.html',
  styleUrls: ['../bouquets/bouquets.component.scss']
})
export class FlowerArrangementsComponent implements OnInit {
  products: ProductModel[] = [];
  isLoaded = false;

  constructor(private globalService: GlobalService) { }

  ngOnInit(): void {
    this.globalService.client().get(`${BASE_URL}${FLOWER_ARRANGEMENTS}`).subscribe((data: ProductModel[]) => {
      this.products = data;
      this.isLoaded = true;
    });
  }
}
