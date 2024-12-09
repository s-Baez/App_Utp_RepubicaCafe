import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { SearchService } from '../search.service';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrl: './productos.component.css'
})
export class ProductosComponent implements OnInit {
  filteredProducts: any[] = [];
  searchControl = new FormControl();
  images = [
    '/assets/logo.png',
    '/assets/portada.jpeg',
    '/assets/carrito.png'
  ];
  products = [
    { id: "1", name: "Hamburguesa con papas doradas", price: "S/ 19.00", portions: "1 porciones", imgSrc: "/assets/productos/p1.jpg" },
    { id: "1", name: "Torta 5 sabores", price: "S/ 58.00", portions: "10 porciones", imgSrc: "/assets/productos/p2.jpg" },
    { id: "1", name: "Café capuchino", price: "S/ 7.00", portions: "1 porciones", imgSrc: "/assets/productos/p3.jpg" },
    { id: "1", name: "Tostadas con huevos revueltos", price: "S/ 10.00", portions: "3 porciones", imgSrc: "/assets/productos/p4.jpg" },
    { id: "1", name: "Tostadas con queso y jamón", price: "S/ 10.00", portions: "3 porciones", imgSrc: "/assets/productos/p5.jpg" },
    { id: "1", name: "Tostadas integrales con salchicha", price: "S/ 12.00", portions: "3 porciones", imgSrc: "/assets/productos/p6.jpg" },
    { id: "1", name: "Tequeños rellenos de queso", price: "S/ 12.00", portions: "6 porciones", imgSrc: "/assets/productos/p7.jpg" },
    { id: "1", name: "Pizza de pepperoni y champiñones", price: "S/ 43.00", portions: "8 porciones", imgSrc: "/assets/productos/p8.jpg" },
  ];

  constructor(private searchService: SearchService) { }

  ngOnInit(): void {
    this.filteredProducts = this.products;

    this.searchService.search$.subscribe(searchTerm => {
      this.filteredProducts = this.filterProducts(searchTerm);
    });
    // Iniciar el carrusel manualmente

  }
  filterProducts(searchTerm: string): any[] {
    return this.products.filter(product =>
      product.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
      product.price.toLowerCase().includes(searchTerm.toLowerCase())
    );
  }
}
