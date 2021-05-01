import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-compare-result',
  templateUrl: './compare-result.component.html',
  styleUrls: ['./compare-result.component.css']
})
export class CompareResultComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  
  gotoHome()
  {
    this.router.navigateByUrl("/home");
  }

}
