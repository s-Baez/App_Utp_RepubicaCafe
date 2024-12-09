import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../product.service';
import {ItemCarrito} from "../entities/ItemCarrito";

@Component({
  selector: 'app-producto-detalle',
  templateUrl: './producto-detalle.component.html',
  styleUrls: ['./producto-detalle.component.css']
})
export class ProductoDetalleComponent implements OnInit {
  producto: any;
  cantidad: number = 1;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService
  ) { }

  ngOnInit(): void {
    //var productId = "";

    const productId = this.route.snapshot.paramMap.get('id') ?? '';
    this.producto = this.productService.getProductById(productId);
  }

  incrementarCantidad(): void {
    this.cantidad++;
  }

  decrementarCantidad(): void {
    if (this.cantidad > 1) {
      this.cantidad--;
    }
  }
  agregarCarrito(item: any) {
    let iCarrito: ItemCarrito = {
      nombre: item.nombre,
      precio: item.precio,
      cantidad: this.cantidad // Usa la cantidad actual seleccionada
    };

    // Recuperar el carrito existente o inicializarlo si está vacío
    let carrito: ItemCarrito[] = JSON.parse(localStorage.getItem("carrito") || '[]');

    // Verificar si el producto ya está en el carrito
    const productoExistente = carrito.find(producto => producto.nombre === iCarrito.nombre);
    if (productoExistente) {
      // Si ya está, simplemente actualiza la cantidad
      productoExistente.cantidad! += this.cantidad;
    } else {
      // Si no está, lo agregamos al carrito
      carrito.push(iCarrito);
    }

    // Guardar el carrito actualizado en localStorage
    localStorage.setItem("carrito", JSON.stringify(carrito));

    // Opción: mostrar un mensaje al usuario
    console.log("Producto añadido al carrito:", iCarrito);
  }
}
