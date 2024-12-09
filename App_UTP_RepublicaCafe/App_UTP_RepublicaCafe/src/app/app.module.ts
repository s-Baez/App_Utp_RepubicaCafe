import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ProductosComponent } from './productos/productos.component';
import { FooterComponent } from './footer/footer.component';
import { CafesComponent } from './cafes/cafes.component';
import { AppRoutingModule } from './app-routing.module';
import { PostresComponent } from './postres/postres.component';
import { EspecialesComponent } from './especiales/especiales.component';
import { PizzasComponent } from './pizzas/pizzas.component';
import { TerminosComponent } from './terminos/terminos.component';
import { TiendasComponent } from './tiendas/tiendas.component';
import { EmpresaComponent } from './empresa/empresa.component';
import { TrabajaComponent } from './trabaja/trabaja.component';
import { LibroReclamacionesComponent } from './libro-reclamaciones/libro-reclamaciones.component';
import { ProductoDetalleComponent } from './producto-detalle/producto-detalle.component';
import { ProductService } from './product.service';
import { SearchService } from './search.service';
import {NgOptimizedImage} from "@angular/common";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ProductosComponent,
    FooterComponent,
    CafesComponent,
    PostresComponent,
    EspecialesComponent,
    PizzasComponent,
    TerminosComponent,
    TiendasComponent,
    EmpresaComponent,
    TrabajaComponent,
    LibroReclamacionesComponent,
    ProductoDetalleComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule,
        NgOptimizedImage
    ],
  providers: [ProductService, SearchService],
  bootstrap: [AppComponent]
})
export class AppModule { }
