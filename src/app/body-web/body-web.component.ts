import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

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

  public dataType: string[] = [];
  public types = ["string", "hex", "byte", "base64"];

  public datas = this.types.map(type => {
    return {
      dulieu: type,
      otherType: this.types.filter(other => other !== type)
    };
  });

  public changeData(event: any) {
    const duLieuGoc = event.target.value;
    const search = this.datas.filter((data) => data.dulieu === duLieuGoc);
    if (search) {
      this.dataType = search[0].otherType;
    }
  }

  public click(): void {
    if (!this.kieuDuLieu1 || !this.kieuDuLieu2) {
      alert('Vui lòng chọn kiểu dữ liệu đầu ra đầu vào!');
      return;
    }

    this.encode(this.kieuDuLieu1, this.inputDuLieu).subscribe(encodedResponse => {
      const encodedData = encodedResponse.encoded;
      this.decode(this.kieuDuLieu2!, encodedData).subscribe(decodedResponse => {
        this.outputDuLieu = decodedResponse.decoded;
      });
    });
  }

  private encode(type: string, data: string): Observable<any> {
    return this.http.post<any>(`http://localhost:8080/encode?type=${type}`, data, { responseType: 'json' });
  }

  private decode(type: string, data: string): Observable<any> {
    return this.http.post<any>(`http://localhost:8080/decode?type=${type}`, data, { responseType: 'json' });
  }
}