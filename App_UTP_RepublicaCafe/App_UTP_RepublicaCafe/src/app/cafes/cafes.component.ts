import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { SearchService } from '../search.service';

@Component({
  selector: 'app-cafes',
  templateUrl: './cafes.component.html',
  styleUrl: './cafes.component.css'
})
export class CafesComponent implements OnInit {
  filteredProducts: any[] = [];
  searchControl = new FormControl();
  products = [
      { id: "1", name: "Café Americano", flavor: "Suave", pricen: 6, price: "S/ 6.00", portions: "1 porción", imgSrc: "assets/cafes/cafe1.png" },
      { id: "2", name: "Café Latte", flavor: "Dulce", pricen: 8, price: "S/ 8.00", portions: "1 porción", imgSrc: "assets/cafes/cafe2.png" },
      { id: "3", name: "Café Expreso", flavor: "Intenso", pricen: 5, price: "S/ 5.00", portions: "1 porción", imgSrc: "assets/cafes/cafe3.png" },
      { id: "4", name: "Café Cortado", flavor: "Intenso", pricen: 7, price: "S/ 7.00", portions: "1 porción", imgSrc: "assets/cafes/cafe4.png" },
      { id: "5", name: "Café Capuchino", flavor: "Dulce", pricen: 7, price: "S/ 7.00", portions: "1 porción", imgSrc: "assets/cafes/cafe5.png" },
      { id: "6", name: "Café Bonbon", flavor: "Dulce", pricen: 8, price: "S/ 8.00", portions: "1 porción", imgSrc: "assets/cafes/cafe6.png" },
      { id: "7", name: "Vainilla Latte", flavor: "Vainilla", pricen: 9, price: "S/ 9.00", portions: "1 porción", imgSrc: "assets/cafes/cafe7.png" },
      { id: "8", name: "Cinnamon Latte", flavor: "Canela", pricen: 9, price: "S/ 9.00", portions: "1 porción", imgSrc: "assets/cafes/cafe8.png" },
      { id: "9", name: "Macchiato", flavor: "Intenso", pricen: 7, price: "S/ 7.00", portions: "1 porción", imgSrc: "assets/cafes/cafe9.png" },
      { id: "10", name: "Mocachino", flavor: "Chocolate", pricen: 10, price: "S/ 10.00", portions: "1 porción", imgSrc: "assets/cafes/cafe10.png" },
      { id: "11", name: "Chia Latte", flavor: "Vainilla", pricen: 10, price: "S/ 10.00", portions: "1 porción", imgSrc: "assets/cafes/cafe11.png" },
      { id: "12", name: "Coffee Tonic", flavor: "Refrescante", pricen: 12, price: "S/ 12.00", portions: "1 porción", imgSrc: "assets/cafes/cafe12.png" }

  ];
  constructor(private searchService: SearchService) { }

  ngOnInit(): void {
    this.filteredProducts = this.products;

    this.searchService.search$.subscribe(searchTerm => {
      this.filteredProducts = this.filterProducts(searchTerm);
    });
  }
  filterProducts2(searchTerm: string, sizeFilter?: string, priceFilter?: string, flavorFilter?: string): any[] {
    return this.products.filter(product => {
      let matchesSearchTerm = product.name.toLowerCase().includes(searchTerm.toLowerCase()) || product.id.toLowerCase().includes(searchTerm.toLowerCase());
      let matchesSizeFilter = sizeFilter ? product.portions === sizeFilter : true;
      let matchesPriceFilter = priceFilter ? this.filterByPrice(product.pricen, priceFilter) : true;
      let matchesFlavorFilter = flavorFilter ? product.flavor.toLowerCase() === flavorFilter.toLowerCase() : true;

      return matchesSearchTerm && matchesSizeFilter && matchesPriceFilter && matchesFlavorFilter;
    });
  }
  filterProducts(searchTerm: string): any[] {
    return this.products.filter(product =>
      product.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
      product.price.toLowerCase().includes(searchTerm.toLowerCase())
    );
  }
  onFilterChange() {
    const sizeFilter = (document.getElementById('sizeFilter') as HTMLSelectElement).value;
    const priceFilter = (document.getElementById('priceFilter') as HTMLSelectElement).value;
    const flavorFilter = (document.getElementById('flavorFilter') as HTMLSelectElement).value;
    this.filteredProducts = this.filterProducts2("", sizeFilter, priceFilter, flavorFilter);
  }
  filterByPrice(price: number, priceFilter: string): boolean {
    switch (priceFilter) {
      case 'low':
        return price < 5;
      case 'medium':
        return price >= 5 && price <= 7;
      case 'high':
        return price > 7;
      default:
        return true;
    }
  }
}
