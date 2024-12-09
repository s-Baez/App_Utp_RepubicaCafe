import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { SearchService } from '../search.service';

@Component({
  selector: 'app-especiales',
  templateUrl: './especiales.component.html',
  styleUrl: './especiales.component.css'
})
export class EspecialesComponent implements OnInit {
  filteredProducts: any[] = [];
  searchControl = new FormControl();
  products = [
    { id: "1", name: "ALITAS REPÚBLICA", pricen: 45, price: "S/ 45.00", portions: "4 porciones", imgSrc: "/assets/especiales/especial1.png" },
    { id: "1", name: "PIQUEO REPÚBLICA", pricen: 36, price: "S/ 36.00", portions: "1 porciones", imgSrc: "/assets/especiales/especial2.png" },
    { id: "1", name: "TEQUEÑOS", pricen: 24, price: "S/ 24.00", portions: "8 porciones", imgSrc: "/assets/especiales/especial3.png" },
    { id: "1", name: "QUESADILLAS CLÁSICAS", pricen: 26, price: "S/ 26.00", portions: "1 porciones", imgSrc: "/assets/especiales/especial4.png" },
    { id: "1", name: "QUESADILLAS CON POLLO",  pricen: 30, price: "S/ 30.00", portions: "1 porciones", imgSrc: "/assets/especiales/especial5.png" },
    { id: "1", name: "DUO QUICHE", pricen: 20, price: "S/ 20.00", portions: "1 porciones", imgSrc: "/assets/especiales/especial6.png" },
    { id: "1", name: "PORCIÓN DE PAPAS NATIVAS", pricen: 16, price: "S/ 16.00", portions: "1 porciones", imgSrc: "/assets/especiales/especial7.png" },
  ];
  constructor(private searchService: SearchService) { }

  ngOnInit(): void {
    this.filteredProducts = this.products;

    this.searchService.search$.subscribe(searchTerm => {
      this.filteredProducts = this.filterProducts(searchTerm);
    });
  }
  filterProducts2(searchTerm: string, sizeFilter?: string, priceFilter?: string): any[] {
    return this.products.filter(product => {
      let matchesSearchTerm = product.name.toLowerCase().includes(searchTerm.toLowerCase()) || product.id.toLowerCase().includes(searchTerm.toLowerCase());
      let matchesSizeFilter = sizeFilter ? product.portions === sizeFilter : true;
      let matchesPriceFilter = priceFilter ? this.filterByPrice(product.pricen, priceFilter) : true;

      return matchesSearchTerm && matchesSizeFilter && matchesPriceFilter;
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
    this.filteredProducts = this.filterProducts2("", sizeFilter, priceFilter);
  }
  filterByPrice(price: number, priceFilter: string): boolean {
    switch (priceFilter) {
      case 'low':
        return price < 20;
      case 'medium':
        return price >= 20 && price <= 40;
      case 'high':
        return price > 40;
      default:
        return true;
    }
  }
}
