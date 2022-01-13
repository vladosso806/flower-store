import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AppMainComponent} from './components/app-main/app-main.component';
import {HttpClientModule} from '@angular/common/http';
import {TopNavbarComponent} from './components/top-navbar/top-navbar.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatSliderModule} from '@angular/material/slider';
import {MatCarouselModule} from '@ngmodule/material-carousel';
import {CarouselMainComponent} from './components/carousel-main/carousel-main.component';
import {BouquetsComponent} from './components/bouquets/bouquets.component';
import { ProductComponent } from './components/product/product.component';
import {MatButtonModule} from '@angular/material/button';
import { FlowerArrangementsComponent } from './components/flower-arrangements/flower-arrangements.component';
import { HouseplantsComponent } from './components/houseplants/houseplants.component';
import { BonsaiComponent } from './components/bonsai/bonsai.component';
import { PotsComponent } from './components/pots/pots.component';
import { FlorariumsComponent } from './components/florariums/florariums.component';
import { GiftBasketsComponent } from './components/gift-baskets/gift-baskets.component';
import { SearchComponent } from './components/search/search.component';
import {ReactiveFormsModule} from '@angular/forms';
import { CartComponent } from './components/cart/cart.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import {MatCardModule} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";

@NgModule({
  declarations: [
    AppComponent,
    AppMainComponent,
    TopNavbarComponent,
    CarouselMainComponent,
    BouquetsComponent,
    ProductComponent,
    FlowerArrangementsComponent,
    HouseplantsComponent,
    BonsaiComponent,
    PotsComponent,
    FlorariumsComponent,
    GiftBasketsComponent,
    SearchComponent,
    CartComponent,
    SignInComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatButtonModule,
    MatCarouselModule,
    ReactiveFormsModule,
    MatCardModule,
    MatFormFieldModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
