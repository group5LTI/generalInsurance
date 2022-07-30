import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { BuyComponent } from './buy-insurance/buy-insurance.component';
import { ContactComponent } from './contact/contact.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PaymentPageComponent } from './payment-page/payment-page.component';
import { RegisterComponent } from './register/register.component';
import { TravelComponent } from './travel-insurance/travel-insurance.component';
import { TravelPageComponent } from './travel-page/travel-page.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';

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
  path:'paymentLink',component:PaymentPageComponent
},
{
  path:'updateProfileLink',component:UpdateProfileComponent
},
{
  path:'forgotLink',component:ForgotpasswordComponent
}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
