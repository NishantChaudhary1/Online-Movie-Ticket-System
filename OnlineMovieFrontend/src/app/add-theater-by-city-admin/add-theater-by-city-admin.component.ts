import { Component, OnInit } from '@angular/core';
import { Theater } from '../interface/theater';
import { TheaterWebService } from '../services/theater-web.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-theater-by-city-admin',
  templateUrl: './add-theater-by-city-admin.component.html',
  styleUrls: ['./add-theater-by-city-admin.component.css']
})
export class AddTheaterByCityAdminComponent implements OnInit {

  cityId:number;
  theater:Theater ;
  theaterId: null ;
 submitted = false;
  

  constructor(private TheaterService: TheaterWebService,
    private router: Router,private route:ActivatedRoute) { }

  ngOnInit() {
     this.theater = new Theater(); 

 }

  newTheater(): void {
    this.submitted = false;
    
  }

  save() {
    this.cityId=this.route.snapshot.params['cityId'];
    this.theaterId=this.route.snapshot.params['theaterId'];
    console.log(this.cityId);
    this.TheaterService.createTheaterByCityId(this.cityId,this.theaterId, this.theater)
      .subscribe(data => console.log(data), error => console.log(error));
     this.theater = new Theater();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['admin/theater/addByCity',this.cityId, this.theaterId]);
  }

}
