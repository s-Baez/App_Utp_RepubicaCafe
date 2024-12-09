import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { SearchService } from '../search.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  searchControl = new FormControl('');
  constructor(private searchService: SearchService) {
    this.searchControl.valueChanges.subscribe(value => {
      this.searchService.setSearchTerm(value ?? '');
    });
  }
}
