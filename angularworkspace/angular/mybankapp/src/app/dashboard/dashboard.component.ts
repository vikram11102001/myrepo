import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../dashboard.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  customerID : string;
  customer: Customer;

  constructor(private dashboardService: DashboardService) { }
  
  ngOnInit(): void {
    this.customerID = '123'; 
    this.loadCustomerData();
  }

  loadCustomerData() {
    this.dashboardService.getCustomerById(this.customerID).subscribe(customer => {
      this.customer = customer;
    });
  }

}
