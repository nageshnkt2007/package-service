import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PackagesComponent } from './packages/packages.component';
import { FormsModule } from '@angular/forms';
import { PackageListComponent } from './packages/package-list/package-list.component';
import { PackageDetailComponent } from './packages/package-detail/package-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    PackagesComponent,
    PackageListComponent,
    PackageDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
