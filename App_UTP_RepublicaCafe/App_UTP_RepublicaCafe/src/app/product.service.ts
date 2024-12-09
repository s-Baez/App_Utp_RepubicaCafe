import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private products = [
    {
      id: '1',
      nombre: 'Café Americano',
      descripcion: 'Café solo diluido en agua caliente, con un sabor suave pero intenso.',
      precio: 6.00,
      tamanos: ['1 porciones'],
      imagen: '/assets/cafes/cafe1.png'
    },
    {
      id: '2',
      nombre: 'Café Latte',
      descripcion: 'Café expreso con abundante leche vaporizada y una fina capa de espuma.',
      precio: 8.00,
      tamanos: ['1 porción'],
      imagen: '/assets/cafes/cafe2.png'
    },
    {
      id: '3',
      nombre: 'Café Expreso',
      descripcion: 'Café concentrado de sabor fuerte y aromático, servido en una pequeña taza.',
      precio: 5.00,
      tamanos: ['1 porción'],
      imagen: '/assets/cafes/cafe3.png'
    },
    {
      id: '4',
      nombre: 'Café Cortado',
      descripcion: 'Expreso con un toque de leche caliente para suavizar su sabor intenso.',
      precio: 7.00,
      tamanos: ['1 porción'],
      imagen: '/assets/cafes/cafe4.png'
    },
    {
      id: '5',
      nombre: 'Café Capuchino',
      descripcion: 'Expreso con partes iguales de leche vaporizada y espuma, a menudo espolvoreado con cacao.',
      precio: 7.00,
      tamanos: ['1 porción'],
      imagen: '/assets/cafes/cafe5.png'
    },
    {
      id: '6',
      nombre: 'Café Bonbon',
      descripcion: 'Expreso combinado con leche condensada para un sabor dulce y cremoso.',
      precio: 8.00,
      tamanos: ['1 porción'],
      imagen: '/assets/cafes/cafe6.png'
    },
    {
      id: '7',
      nombre: 'Vainilla Latte',
      descripcion: 'Expreso con leche vaporizada y un toque de jarabe de vainilla para un sabor dulce y suave.',
      precio: 9.00,
      tamanos: ['1 porción'],
      imagen: '/assets/cafes/cafe7.png'
    },
    {
      id: '8',
      nombre: 'Cinnamon Latte',
      descripcion: 'Expreso con leche vaporizada, infusionado con canela para un toque especiado y cálido.',
      precio: 9.00,
      tamanos: ['1 porción'],
      imagen: '/assets/cafes/cafe8.png'
    },
    {
      id: '9',
      nombre: 'Macchiato',
      descripcion: 'Expreso “manchado” con un poco de espuma de leche, perfecto para los amantes del café fuerte.',
      precio: 7.00,
      tamanos: ['1 porción'],
      imagen: '/assets/cafes/cafe9.png'
    },
    {
      id: '10',
      nombre: 'Mocachino',
      descripcion: 'Expreso mezclado con chocolate caliente y leche vaporizada, una bebida dulce y reconfortante.',
      precio: 10.00,
      tamanos: ['1 porción'],
      imagen: '/assets/cafes/cafe10.png'
    },
    {
      id: '11',
      nombre: 'Chia Latte',
      descripcion: 'Bebida caliente de leche con semillas de chía y un toque de vainilla o canela, para un sabor saludable y suave.',
      precio: 10.00,
      tamanos: ['1 porción'],
      imagen: '/assets/cafes/cafe11.png'
    },
    {
      id: '12',
      nombre: 'Coffee Tonic',
      descripcion: 'Refrescante combinación de café expreso y agua tónica, ideal para los días calurosos.',
      precio: 12.00,
      tamanos: ['1 porción'],
      imagen: '/assets/cafes/cafe12.png'
    }
    // otros productos
  ];

  constructor() { }
  getProducts(): any[] {
    return this.products;
  }
  getProductById(id: string): any {
    return this.products.find(product => product.id === id);
  }
}
