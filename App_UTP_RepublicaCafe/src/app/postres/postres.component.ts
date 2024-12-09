import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { SearchService } from '../search.service';

@Component({
  selector: 'app-postres',
  templateUrl: './postres.component.html',
  styleUrl: './postres.component.css'
})
export class PostresComponent implements OnInit {
  filteredProducts: any[] = [];
  searchControl = new FormControl();
  products = [
    { id: "1", name: "Pye de Manzana", flavor: "manzana", pricen: 40, price: "S/ 40.00", portions: "8 porciones", imgSrc: "/assets/postres/zi6oazdxir8ukuojys9w.webp" },
    { id: "1", name: "Pye de Arándanos", flavor: "arandanos", pricen: 28, price: "S/ 28.00", portions: "8 porciones", imgSrc: "/assets/postres/t8krfpehsmekxilwgxye.webp" },
    { id: "1", name: "Pye de maracuyá", flavor: "maracuya", pricen: 36, price: "S/ 36.00", portions: "8 porciones", imgSrc: "/assets/postres/ybvhg5ga7pij1ba2yjaq.webp" },
    { id: "1", name: "Pye de Limón", flavor: "fresa", pricen: 32, price: "S/ 32.00", portions: "8 porciones", imgSrc: "/assets/postres/dw37vat8ez84pblvdzh5.webp" },
    { id: "1", name: "Mousse de Maracuyá", flavor: "maracuya", pricen: 31, price: "S/ 31.00", portions: "10 porciones", imgSrc: "/assets/postres/glbxolitvthbf8fjfczf.webp" },
    { id: "1", name: "Pionono", flavor: "vainilla", pricen: 34, price: "S/ 34.00", portions: "6 porciones", imgSrc: "/assets/postres/rwafrpmn8wgotzmzicob.webp" },
    { id: "1", name: "Aljaforcitos de Manjar", flavor: "chocolate", pricen: 14.50, price: "S/ 14.50", portions: "12 porciones", imgSrc: "/assets/postres/aljaforcitos de manjar.webp" },
    { id: "1", name: "Brownies", flavor: "fresa", pricen: 15, price: "S/ 15.00", portions: "12 porciones", imgSrc: "/assets/postres/m1t7f90oltedd9n2nypw.jpg" },
    { id: "1", name: "Alfajorcitos con chocolate", flavor: "chocolate", pricen: 14.50, price: "S/ 14.50", portions: "9 porciones", imgSrc: "/assets/postres/un3yizlysyyhnbeiwi0t.webp" },
    { id: "1", name: "Enrolladitos de Hot Dog", flavor: "fresa", pricen: 14, price: "S/ 14.00", portions: "12 porciones", imgSrc: "/assets/postres/y8rlv5rtxywpgdci2cdj.webp" },
    { id: "1", name: "Alfajorcitos de Fudge", flavor: "vainilla", pricen: 14.50, price: "S/ 14.50", portions: "12 porciones", imgSrc: "/assets/postres/alfafocirtos de fudge.webp" },
    { id: "1", name: "Super brownie", flavor: "Chocolate", pricen: 13.50, price: "S/ 13.50", portions: "1 porcion", imgSrc: "/assets/postres/m0iyqkbrlkgld7pxtqq5.webp" }
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
        return price < 20;
      case 'medium':
        return price >= 20 && price <= 35;
      case 'high':
        return price > 35;
      default:
        return true;
    }
  }
}
