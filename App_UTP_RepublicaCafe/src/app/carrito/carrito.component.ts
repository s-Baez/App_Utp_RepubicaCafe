import { Component } from '@angular/core';
import {ItemCarrito} from "../entities/ItemCarrito";

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrl: './carrito.component.css'
})
export class CarritoComponent {
  listaItemsCarrito: ItemCarrito[] = [];


  ngOnInit() {
    const carritoStorage = localStorage.getItem("carrito");
    if (carritoStorage) {
      this.listaItemsCarrito = JSON.parse(carritoStorage);
    }

    // Asegurarse de que todos los productos tengan la propiedad isEditable al iniciar
    this.listaItemsCarrito.forEach(item => {
      item.isEditable = item.isEditable || false;  // Asegúrate de inicializar isEditable si no existe
    });
  }

  habilitarEdicion(index: number) {
    const producto = this.listaItemsCarrito[index];
    producto.isEditable = true;  // Habilitar el campo para editar
  }

  actualizarCantidad(index: number) {
    const producto = this.listaItemsCarrito[index];
    if (producto.cantidad && producto.cantidad > 0) {
      localStorage.setItem("carrito", JSON.stringify(this.listaItemsCarrito));
      console.log(`Cantidad actualizada para ${producto.nombre}: ${producto.cantidad}`);
      producto.isEditable = false;  // Deshabilitar el campo después de actualizar
    } else {
      alert("La cantidad debe ser mayor a cero.");
    }
  }

  eliminarProducto(index: number) {
    this.listaItemsCarrito.splice(index, 1);
    localStorage.setItem("carrito", JSON.stringify(this.listaItemsCarrito));
    console.log("Producto eliminado del carrito.");
  }
}




