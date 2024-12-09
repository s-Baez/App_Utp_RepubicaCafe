import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ProductService } from '../product.service';
import { SearchService } from '../search.service';

@Component({
  selector: 'app-pizzas',
  templateUrl: './pizzas.component.html',
  styleUrl: './pizzas.component.css'
})
export class PizzasComponent implements OnInit {
  filteredProducts: any[] = [];
  searchControl = new FormControl();
  products = [
    { id: "1", name: "Pizza Margherita", pricen: 40, price: "S/ 40.00", portions: "8 porciones", imgSrc: "/assets/pizzas/pizza1.png" },
    { id: "2", name: "Pizza Pepperoni", pricen: 45, price: "S/ 45.00", portions: "8 porciones", imgSrc: "/assets/pizzas/pizza2.png" },
    { id: "3", name: "Pizza Vegetariana", pricen: 38, price: "S/ 38.00", portions: "8 porciones", imgSrc: "/assets/pizzas/pizza3.png" },
    { id: "4", name: "Pizza Cuatro Quesos",  pricen: 50, price: "S/ 50.00", portions: "8 porciones", imgSrc: "/assets/pizzas/pizza4.png" },
    { id: "5", name: "Pizza BBQ", pricen: 48, price: "S/ 48.00", portions: "10 porciones", imgSrc: "/assets/pizzas/pizza5.png" },
    { id: "6", name: "Pizza Hawaiana", pricen: 46, price: "S/ 46.00", portions: "10 porciones", imgSrc: "/assets/pizzas/pizza6.png" },
    { id: "7", name: "Pizza Diavola", pricen: 52, price: "S/ 52.00", portions: "10 porciones", imgSrc: "/assets/pizzas/pizza7.png" },
    { id: "8", name: "Pizza Prosciutto", pricen: 48, price: "S/ 48.00", portions: "12 porciones", imgSrc: "/assets/pizzas/pizza8.png" },
    { id: "9", name: "Full Pizza", pricen: 53, price: "S/ 53.00", portions: "12 porciones", imgSrc: "/assets/pizzas/pizza9.png" },
    { id: "10", name: "Pizza República", pricen: 48, price: "S/ 48.00", portions: "12 porciones", imgSrc: "/assets/pizzas/pizza10.png" },
    { id: "11", name: "Pizza Tropical", pricen: 48, price: "S/ 48.00", portions: "12 porciones", imgSrc: "/assets/pizzas/pizza11.png" },
    { id: "12", name: "Pizza Caprese", pricen: 42, price: "S/ 42.00", portions: "12 porciones", imgSrc: "/assets/pizzas/pizza12.png" },

  ];
  constructor(private productService: ProductService, private searchService: SearchService) { }

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
        return price < 40;
      case 'medium':
        return price >= 40 && price <= 55;
      case 'high':
        return price > 55;
      default:
        return true;
    }
  }
}
