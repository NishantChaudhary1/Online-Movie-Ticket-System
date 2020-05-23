import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MovieViewComponent } from './movie-view/movie-view.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { WebService } from './services/web.service';
import { MovieAdminComponent } from './movie-admin/movie-admin.component';
import { TheaterAdminComponent } from './theater-admin/theater-admin.component';
import { CityAdminComponent } from './city-admin/city-admin.component';
import { AddTheaterByCityAdminComponent } from './add-theater-by-city-admin/add-theater-by-city-admin.component';
import { SearchTheaterComponent } from './search-theater/search-theater.component';
import { SearchCityComponent } from './search-city/search-city.component';
import { FilterCityPipe } from './filter-city.pipe';
import { AdminNavComponent } from './admin-nav/admin-nav.component';
import { FilterTheaterPipe } from './filter-theater.pipe';
import { ShowViewComponent } from './show-view/show-view.component';
import { ShowAdminComponent } from './show-admin/show-admin.component';
import { BookingViewComponent } from './booking-view/booking-view.component';

@NgModule({
  declarations: [
    AppComponent,
    MovieViewComponent,
    MovieAdminComponent,
    TheaterAdminComponent,
    CityAdminComponent,
    AddTheaterByCityAdminComponent,
    SearchTheaterComponent,
    SearchCityComponent,
    FilterCityPipe,
    AdminNavComponent,
    FilterTheaterPipe,
    ShowViewComponent,
    ShowAdminComponent,
    BookingViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [WebService],
  bootstrap: [AppComponent]
})
export class AppModule { }
