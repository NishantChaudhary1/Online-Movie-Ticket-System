import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MovieAdminComponent } from './movie-admin/movie-admin.component';
import { MovieViewComponent } from './movie-view/movie-view.component';
import { TheaterAdminComponent } from './theater-admin/theater-admin.component';
import { CityAdminComponent } from './city-admin/city-admin.component';
import { AddTheaterByCityAdminComponent } from './add-theater-by-city-admin/add-theater-by-city-admin.component';
import { SearchCityComponent } from './search-city/search-city.component';
import { AdminNavComponent } from './admin-nav/admin-nav.component';
import { SearchTheaterComponent } from './search-theater/search-theater.component';
import { ShowViewComponent } from './show-view/show-view.component';
import { ShowAdminComponent } from './show-admin/show-admin.component';
import { BookingViewComponent } from './booking-view/booking-view.component';


const routes: Routes = [
  {path: '', redirectTo: '/user', pathMatch: 'full'},
  {path: 'user', component: MovieViewComponent},
  {path: 'admin', component: AdminNavComponent},
  {path: 'admin/movie', component: MovieAdminComponent},
  {path: 'admin/theater', component: TheaterAdminComponent},
  {path: 'admin/city', component: CityAdminComponent},
  {path: 'admin/show', component: ShowAdminComponent},
  {path: 'admin/theater/addByCity/:cityId/:Id', component: AddTheaterByCityAdminComponent},
  {path: 'user/searchCity', component: SearchCityComponent},
  {path: 'user/searchTheater', component: SearchTheaterComponent},
  {path: 'user/movie/show/:id', component: ShowViewComponent},
  {path: 'user/show/booking', component: BookingViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponents = [MovieViewComponent, MovieAdminComponent,
              TheaterAdminComponent, CityAdminComponent,
            SearchCityComponent, AdminNavComponent, SearchTheaterComponent,
            ShowViewComponent, ShowAdminComponent, BookingViewComponent]
