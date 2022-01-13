import {Component, OnInit} from '@angular/core';
import {ProductModel} from '../../model/product.model';
import {GlobalService} from '../../services/global.service';
import {BASE_URL, BONSAI} from '../../constants/api-routes.constants';

@Component({
  selector: 'app-bonsai',
  templateUrl: './bonsai.component.html',
  styleUrls: ['../bouquets/bouquets.component.scss']
})
export class BonsaiComponent implements OnInit {
  products: ProductModel[] = [];
  isLoaded = false;

  constructor(private globalService: GlobalService) { }

  ngOnInit(): void {
    this.globalService.client().get(`${BASE_URL}${BONSAI}`).subscribe((data: ProductModel[]) => {
      this.products = data;
      this.isLoaded = true;
    });
  }
}
