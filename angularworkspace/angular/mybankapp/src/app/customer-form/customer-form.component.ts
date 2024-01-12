import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';




@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent {
  customer: Customer;
  responseMessage: string;

  constructor(
    private route: ActivatedRoute, 
      private router: Router, 
        private customerService: CustomerService) {
    this.customer = new Customer();
  }

  onSubmit() {
    this.customerService.save(this.customer).subscribe((response: any) => {
      alert(response);
      console.log(response)
  },result => this.gotoCustomerList());
  }

  gotoCustomerList() {
    this.router.navigate(['/customers']);
    
  }
}
