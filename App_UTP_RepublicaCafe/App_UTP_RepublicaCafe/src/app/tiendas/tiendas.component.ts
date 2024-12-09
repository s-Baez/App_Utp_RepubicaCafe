import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tiendas',
  templateUrl: './tiendas.component.html',
  styleUrl: './tiendas.component.css'
})
export class TiendasComponent implements OnInit {
  tiendas = [
    {
      nombre: "Sede Arequipa",
      direccion: "Calle bolivar 107, Arequipilla, Arequipa; Lun. a Sáb: 8:30 am. a 10:00 pm. y Dom: 9 am. a 8:00 pm.",
      mapa: "https://google.com/maps/place/Google+Per%C3%BA/@-12.0977947,-77.0402393,17z/data=!3m1!4b1!4m6!3m5!1s0x9105c92f3847675b:0x49f9d9498e2b2cfa!8m2!3d-12.0978!4d-77.037659!16s%2Fg%2F11kjf3k1vz?entry=ttu"
    },
    {
      nombre: "Sede La Molina",
      direccion: "Avenida Los Constructores 433, La Molina; Proximamente",
      mapa: "https://google.com/maps/place/Google+Per%C3%BA/@-12.0977947,-77.0402393,17z/data=!3m1!4b1!4m6!3m5!1s0x9105c92f3847675b:0x49f9d9498e2b2cfa!8m2!3d-12.0978!4d-77.037659!16s%2Fg%2F11kjf3k1vz?entry=ttu"
    },
    {
      nombre: "Sede San Juan de Miraflores",
      direccion: "Av Ramon Vargas Machuca 119, San Juan de Miraflores; Proximamente",
      mapa: "https://google.com/maps/place/Google+Per%C3%BA/@-12.0977947,-77.0402393,17z/data=!3m1!4b1!4m6!3m5!1s0x9105c92f3847675b:0x49f9d9498e2b2cfa!8m2!3d-12.0978!4d-77.037659!16s%2Fg%2F11kjf3k1vz?entry=ttu"
    },


  ];

  constructor() { }

  ngOnInit(): void {
  }
}
