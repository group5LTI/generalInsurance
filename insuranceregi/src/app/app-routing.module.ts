import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { AddTravelPlanComponent } from './add-travel-plan/add-travel-plan.component';
import { AddVehiclePlanComponent } from './add-vehicle-plan/add-vehicle-plan.component';
import { AdminVerifyClaimComponent } from './admin-verify-claim/admin-verify-claim.component';
import { AdminComponent } from './admin/admin.component';
import { BuyComponent } from './buy-insurance/buy-insurance.component';
import { ClaimInsuranceComponent } from './claim-insurance/claim-insurance.component';
import { ContactComponent } from './contact/contact.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PaymentPageComponent } from './payment-page/payment-page.component';
import { RegisterComponent } from './register/register.component';
import { RenewInsuranceComponent } from './renew-insurance/renew-insurance.component';
import { TravelComponent } from './travel-insurance/travel-insurance.component';
import { TravelPageComponent } from './travel-page/travel-page.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { ViewAllComponent } from './view-all/view-all.component';
import { ViewCustomerClaimsComponent } from './view-customer-claims/view-customer-claims.component';

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
  path:'renewLink',component:RenewInsuranceComponent
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
  path:'paymentLink',component:PaymentPageComponent
},
{
  path:'updateProfileLink',component:UpdateProfileComponent
},
{
  path:'AboutLink',component:AboutUsComponent
},
{
  path:'forgotLink',component:ForgotpasswordComponent
},
{
  path:'addVehiclePlan',component:AddVehiclePlanComponent
},
{
  path:'viewLink',component:ViewAllComponent
},
{
  path:'addTravelPlan',component:AddTravelPlanComponent
},
{
  path:'claimLink',component:ClaimInsuranceComponent
},
{
  path:'verifyClaim',component:AdminVerifyClaimComponent
},
{
  path:'viewCustomerClaim',component:ViewCustomerClaimsComponent
}



];

@NgModule({
  imports: [RouterModule.forRoot(routes ,{
    scrollPositionRestoration: 'enabled',
    anchorScrolling: 'enabled',
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
