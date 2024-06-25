import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';

@Component({
  selector: 'app-body-web',
  templateUrl: './body-web.component.html',
  styleUrls: ['./body-web.component.css']
})
export class BodyWebComponent {
  constructor(private http: HttpClient) {}

  inputDuLieu = '';
  outputDuLieu = '';
  kieuDuLieu1: string | null = null;
  kieuDuLieu2: string | null = null;

  public types = ["string", "hex", "byte", "base64"];
  public dataType: string[] = this.types;

  public changeData(event: any) {
    const duLieuGoc = event.target.value;
    this.dataType = this.types.filter(type => type !== duLieuGoc);
  }

  public click(): void {
    if (!this.kieuDuLieu1 || !this.kieuDuLieu2) {
      alert('Vui lòng chọn kiểu dữ liệu đầu ra đầu vào!');
      return;
    }

    this.convert(this.kieuDuLieu1, this.kieuDuLieu2, this.inputDuLieu).subscribe(
      response => {
        this.outputDuLieu = response.converted;
      },
      error => {
        alert('Đã xảy ra lỗi: ' + error.message);
      }
    );
  }

  private convert(inputType: string, outputType: string, data: string): Observable<any> {
    return this.http.post<any>(`http://localhost:8080/convert?inputType=${encodeURIComponent(inputType)}&outputType=${encodeURIComponent(outputType)}`, data, { responseType: 'json' })
      .pipe(
        catchError(error => {
          console.error('Error occurred:', error);
          return throwError(() => new Error('Có lỗi xảy ra trong quá trình chuyển đổi dữ liệu. Kiểm tra lại kiểu dữ liệu nhập và đầu vào.'));
        })
      );
  }
}
