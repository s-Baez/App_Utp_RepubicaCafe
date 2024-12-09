export class ItemCarrito {
  nombre: string='';
  precio: number=0;
  cantidad: number=0;
  isEditable?: boolean;

  constructor(nombre?: string, precio?: number, cantidad?: number) {
    if (nombre) this.nombre = nombre;
    if (precio) this.precio = precio;
    if (cantidad) this.cantidad = cantidad;
    this.isEditable = false;
  }

}
