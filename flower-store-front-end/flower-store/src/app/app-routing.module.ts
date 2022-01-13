import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AppMainComponent} from './components/app-main/app-main.component';
import {BouquetsComponent} from './components/bouquets/bouquets.component';
import {ProductComponent} from './components/product/product.component';
import {FlowerArrangementsComponent} from './components/flower-arrangements/flower-arrangements.component';
import {HouseplantsComponent} from './components/houseplants/houseplants.component';
import {BonsaiComponent} from './components/bonsai/bonsai.component';
import {PotsComponent} from './components/pots/pots.component';
import {FlorariumsComponent} from './components/florariums/florariums.component';
import {GiftBasketsComponent} from './components/gift-baskets/gift-baskets.component';
import {SearchComponent} from './components/search/search.component';
import {CartComponent} from './components/cart/cart.component';
import {SignInComponent} from './components/sign-in/sign-in.component';

const routes: Routes = [
  {path: '', component: AppMainComponent},
  {path: 'home', component: AppMainComponent},
  {path: 'bouquets', component: BouquetsComponent},
  {path: 'bouquets/:id', component: ProductComponent},
  {path: 'flower-arrangements', component: FlowerArrangementsComponent},
  {path: 'flower-arrangements/:id', component: ProductComponent},
  {path: 'houseplants', component: HouseplantsComponent},
  {path: 'houseplants/:id', component: ProductComponent},
  {path: 'bonsai', component: BonsaiComponent},
  {path: 'bonsai/:id', component: ProductComponent},
  {path: 'pots', component: PotsComponent},
  {path: 'pots/:id', component: ProductComponent},
  {path: 'florariums', component: FlorariumsComponent},
  {path: 'florariums/:id', component: ProductComponent},
  {path: 'gift-baskets', component: GiftBasketsComponent},
  {path: 'gift-baskets/:id', component: ProductComponent},
  {path: 'search', component: SearchComponent},
  {path: 'cart', component: CartComponent},
  {path: 'sign-in', component: SignInComponent},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
