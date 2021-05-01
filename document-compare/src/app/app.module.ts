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
import { CompareResultComponent } from './compare-result/compare-result.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DragDropDirectiveDirective,
    CompareResultComponent
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
