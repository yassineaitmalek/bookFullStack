import { Component, OnInit } from '@angular/core';

@Component({
  standalone: true,
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss'],
})
export class FooterComponent implements OnInit {
  currentDate: Date = new Date();

  ngOnInit(): void {
    console.log('hofihsodfoldsjfd');
  }
}
