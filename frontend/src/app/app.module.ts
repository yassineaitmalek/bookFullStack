import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { KeycloakService } from 'keycloak-angular';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PagesModule } from './pages/pages.module';
import { ApiModule, Configuration } from './shared/api/books';

@NgModule({
  declarations: [],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule, // Add this line
    ApiModule.forRoot(
      () => new Configuration({ basePath: 'http://localhost:8080' })
    ),
    CommonModule,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
