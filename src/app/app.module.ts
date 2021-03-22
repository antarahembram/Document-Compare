import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { RouterModule} from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import {APP_BASE_HREF} from '@angular/common';
import { DocumentcompareService } from './documentcompare.service';
import { DragDropDirectiveDirective } from './drag-drop-directive.directive';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DragDropDirectiveDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [DocumentcompareService],
  bootstrap: [AppComponent]
})
export class AppModule { }
