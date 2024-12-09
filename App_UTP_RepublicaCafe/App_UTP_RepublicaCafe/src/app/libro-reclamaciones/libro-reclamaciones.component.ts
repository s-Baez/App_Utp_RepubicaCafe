import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-libro-reclamaciones',
  templateUrl: './libro-reclamaciones.component.html',
  styleUrls: ['./libro-reclamaciones.component.css']
})
export class LibroReclamacionesComponent implements OnInit {
  reclamacionForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.reclamacionForm = this.fb.group({
      nombres: ['', Validators.required],
      direccion: ['', Validators.required],
      dni: ['', Validators.required],
      correo: ['', [Validators.required, Validators.email]],
      celular: ['', Validators.required],
      comentario: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    if (this.reclamacionForm.valid) {
      console.log(this.reclamacionForm.value);
      // Aquí puedes añadir la lógica para enviar el formulario a tu servidor
      alert('Reclamación enviada con éxito');
      this.reclamacionForm.reset();
    } else {
      alert('Por favor, completa todos los campos del formulario');
    }
  }
}