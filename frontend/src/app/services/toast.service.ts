import { Injectable } from '@angular/core';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root',
})
export class ToastService {
  onSucess(header: string, body: string) {
    return Swal.fire({
      toast: true,
      position: 'top-end',
      icon: 'success',
      title: header,
      html: body,
      showConfirmButton: false,
      timer: 3000,
      timerProgressBar: true,
    });
  }

  onError(header: string, body: string) {
    return Swal.fire({
      toast: true,
      position: 'top-end',
      icon: 'error',
      title: header,
      html: body,
      showConfirmButton: false,
      timer: 3000,
      timerProgressBar: true,
    });
  }

  onWarning(header: string, body: string) {
    return Swal.fire({
      toast: true,
      position: 'top-end',
      icon: 'warning',
      title: header,
      html: body,
      showConfirmButton: false,
      timer: 3000,
      timerProgressBar: true,
    });
  }

  onInfo(header: string, body: string) {
    return Swal.fire({
      toast: true,
      position: 'top-end',
      icon: 'info',
      title: header,
      html: body,
      showConfirmButton: false,
      timer: 3000,
      timerProgressBar: true,
    });
  }
}
