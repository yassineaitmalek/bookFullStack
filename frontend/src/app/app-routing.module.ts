// Angular
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
// Components
import { routes } from './app.routes';

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
