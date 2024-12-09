import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductosComponent } from './productos/productos.component';
import { CafesComponent } from './cafes/cafes.component';
import { PostresComponent } from './postres/postres.component';
import { EspecialesComponent } from './especiales/especiales.component';
import { TerminosComponent } from './terminos/terminos.component';
import { TiendasComponent } from './tiendas/tiendas.component';
import { EmpresaComponent } from './empresa/empresa.component';
import { TrabajaComponent } from './trabaja/trabaja.component';
import { LibroReclamacionesComponent } from './libro-reclamaciones/libro-reclamaciones.component';
import { PizzasComponent } from './pizzas/pizzas.component';
import { ProductoDetalleComponent } from './producto-detalle/producto-detalle.component';
import {CarritoComponent} from "./carrito/carrito.component";

const routes: Routes = [
  { path: '', component: ProductosComponent },
  { path: 'cafes', component: CafesComponent },
  { path: 'postres', component: PostresComponent },
  { path: 'especiales', component: EspecialesComponent },
  { path: 'terminos', component: TerminosComponent },
  { path: 'tiendas', component: TiendasComponent },
  { path: 'empresa', component: EmpresaComponent },
  { path: 'trabaja', component: TrabajaComponent },
  { path: 'libro-reclamaciones', component: LibroReclamacionesComponent },
  { path: 'pizzas', component: PizzasComponent },
  { path: 'producto/:id', component: ProductoDetalleComponent },
  { path: 'carrito', component: CarritoComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
