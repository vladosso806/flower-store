import {Component, OnInit} from '@angular/core';
import {ProductModel} from '../../model/product.model';
import {GlobalService} from '../../services/global.service';
import {BASE_URL, POTS} from '../../constants/api-routes.constants';

@Component({
  selector: 'app-pots',
  templateUrl: './pots.component.html',
  styleUrls: ['../bouquets/bouquets.component.scss']
})
export class PotsComponent implements OnInit {
  products: ProductModel[] = [];
  isLoaded = false;

  constructor(private globalService: GlobalService) { }

  ngOnInit(): void {
    this.globalService.client().get(`${BASE_URL}${POTS}`).subscribe((data: ProductModel[]) => {
      this.products = data;
      this.isLoaded = true;
    });
  }
}
