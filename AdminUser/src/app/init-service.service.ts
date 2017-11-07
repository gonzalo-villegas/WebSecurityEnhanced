import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface ItemResponse {
  results: any;
}

@Injectable()
export class InitService {

  private urlisavalible = 'http://localhost:8081/WebSecurityEnhanced/validation/isavalible';

  results: any;
  params: {''};
  constructor(private http: HttpClient) { }

  public getDataPost (params, onSuccess, onError): void {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    try {
      this.http.post<ItemResponse>(this.urlisavalible, params)
        .subscribe(data => {
          onSuccess(data);
        }, error => {
          onError(error);
        });
    }catch (e) {
      onError(e);
    }
  }

}
