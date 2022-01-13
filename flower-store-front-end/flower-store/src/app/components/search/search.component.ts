import {Component, OnInit} from '@angular/core';
import {ProductModel} from '../../model/product.model';
import {GlobalService} from '../../services/global.service';
import {BASE_URL, SEARCH} from '../../constants/api-routes.constants';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['../bouquets/bouquets.component.scss', '../top-navbar/top-navbar.component.css']
})
export class SearchComponent implements OnInit {

  products: ProductModel[] = [];
  isLoaded = false;
  searchCriteria = '';
  searchInput = new FormControl('');
  subs = [];

  constructor(private globalService: GlobalService) {
    this.searchInput.valueChanges.subscribe(newValue => this.searchCriteria = newValue);
  }

  ngOnInit(): void {

  }

  search(): void {
    this.isLoaded = false;
    this.subs.push(this.globalService.client().post(`${BASE_URL}${SEARCH}`, {data: this.searchCriteria})
      .subscribe((data: ProductModel[]) => {
        this.products = data;
        this.isLoaded = true;
      }));
  }
}
