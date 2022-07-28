import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FormGroup, ReactiveFormsModule } from '@angular/forms';
import { BuyComponent } from './buy-insurance/buy-insurance.component';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './home/home.component';
import { AdminNavComponent } from './admin-nav/admin-nav.component';
import { HomeMenuComponent } from './home-menu/home-menu.component';
import { DashboardNavComponent } from './dashboard-nav/dashboard-nav.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TravelPageComponent } from './travel-page/travel-page.component';
import { ContactComponent } from './contact/contact.component';
import { TravelComponent } from './travel-insurance/travel-insurance.component';

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
    TravelComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
