import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { ApiModule, Configuration } from './shared/api/books';
import { FooterComponent } from './pages/footer/footer.component';

@NgModule({
  declarations: [],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, // Add this line
    ApiModule.forRoot(() => new Configuration({ basePath: '/book-service' })),

    // ApiModule.forRoot({ rootUrl: '/abb-api-agios' }),
    CommonModule,

  ],
  bootstrap: [AppComponent],
})
export class AppModule { }
