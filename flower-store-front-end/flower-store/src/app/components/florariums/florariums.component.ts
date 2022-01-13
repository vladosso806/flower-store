import {Component, OnInit} from '@angular/core';
import {ProductModel} from '../../model/product.model';
import {GlobalService} from '../../services/global.service';
import {BASE_URL, FLORARIUMS} from '../../constants/api-routes.constants';

@Component({
  selector: 'app-florariums',
  templateUrl: './florariums.component.html',
  styleUrls: ['../bouquets/bouquets.component.scss']
})
export class FlorariumsComponent implements OnInit {
  products: ProductModel[] = [];
  isLoaded = false;

  constructor(private globalService: GlobalService) { }

  ngOnInit(): void {
    this.globalService.client().get(`${BASE_URL}${FLORARIUMS}`).subscribe((data: ProductModel[]) => {
      this.products = data;
      this.isLoaded = true;
    });
  }
}
