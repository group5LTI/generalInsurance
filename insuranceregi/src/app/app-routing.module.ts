import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { BuyComponent } from './buy-insurance/buy-insurance.component';
import { CalPageComponent } from './cal-page/cal-page.component';
import { ClaimInsuranceComponent } from './claim-insurance/claim-insurance.component';
import { ContactComponent } from './contact/contact.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RenewInsuranceComponent } from './renew-insurance/renew-insurance.component';
import { TravelCalculatorComponent } from './travel-calculator/travel-calculator.component';
import { TravelComponent } from './travel-insurance/travel-insurance.component';
import { TravelPageComponent } from './travel-page/travel-page.component';
import { VehicleCalculatorComponent } from './vehicle-calculator/vehicle-calculator.component';

const routes: Routes = [
  {
    path:'',component:HomeComponent
  },
{
  path:'homeLink',component:HomeComponent
},
{
  path:'buyLink',component:BuyComponent
},
{
  path:'adminLink',component:AdminComponent
},
{
  path:'loginLink',component:LoginComponent
},
{
  path:'registerLink',component:RegisterComponent
},
{
  path:'dbLink',component:DashboardComponent
},
{
  path:'contactLink',component:ContactComponent
},
{
  path:'travelpageLink',component:TravelPageComponent
},
{
  path:'travelLink',component:TravelComponent
},
{
  path:'claimLink',component:ClaimInsuranceComponent
},
{
  path:'renewLink',component:RenewInsuranceComponent
},
{
  path:'calPage',component:CalPageComponent
},
{
  path:'travelCal',component:TravelCalculatorComponent
},
{
  path:'vehicleCal',component:VehicleCalculatorComponent
}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
