import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

import { BuyComponent } from './buy-insurance/buy-insurance.component';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule} from "@angular/common/http";
import { ContactComponent } from './contact/contact.component';
import { AdminNavComponent } from './admin-nav/admin-nav.component';
import { DashboardNavComponent } from './dashboard-nav/dashboard-nav.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeMenuComponent } from './home-menu/home-menu.component';
import { TravelComponent } from './travel-insurance/travel-insurance.component';
import { TravelPageComponent } from './travel-page/travel-page.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RenewInsuranceComponent } from './renew-insurance/renew-insurance.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { PaymentPageComponent } from './payment-page/payment-page.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { AboutUsComponent } from './about-us/about-us.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    BuyComponent,
    AdminComponent,
    HomeComponent,
    AdminNavComponent,
    HomeMenuComponent,
    DashboardNavComponent,
    DashboardComponent,
    TravelPageComponent,
    ContactComponent,
    TravelComponent,
    RenewInsuranceComponent,
    PaymentPageComponent,
    UpdateProfileComponent,
    AboutUsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
