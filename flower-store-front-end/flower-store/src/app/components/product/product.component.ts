import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {GlobalService} from '../../services/global.service';
import {Subscription} from 'rxjs';
import {BASE_URL, BOUQUETS, PRODUCTS} from '../../constants/api-routes.constants';
import {ProductModel} from '../../model/product.model';

@Component({
  selector: 'app-bouquet',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit, OnDestroy {

  @Input() productType: string;
  private subs: Subscription[] = [];

  id: number;
  isLoaded = false;
  product: ProductModel;

  constructor(private activateRoute: ActivatedRoute, private globalService: GlobalService) {
    this.id = activateRoute.snapshot.params.id;
    console.log(this.id);
  }

  ngOnInit(): void {
    this.subs.push(this.globalService.client().get(`${BASE_URL}${PRODUCTS}/${this.id}`)
      .subscribe((data: ProductModel) => {
        this.product = data;
        this.isLoaded = true;
      }));
  }


  ngOnDestroy(): void {
    this.subs.forEach(sub => sub.unsubscribe());
  }


}
