import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

const TASK_API = "http://localhost:8080/api/task/";

@Injectable({
  providedIn: "root",
})
export class TaskService {
  constructor(private http: HttpClient) {}

  getTasks(): Observable<any> {
    return this.http.get(TASK_API + "getTasks");
  }

  addTask(name: string, description: string, image?: string): Observable<any> {
    return this.http.post(TASK_API + "addTask", { name, description, image });
  }

  removeTask(id: string): Observable<any> {
    return this.http.delete(TASK_API + `removeTask/${id}`);
  }

  updateTask(
    id: string,
    name: string,
    description: string,
    image?: string
  ): Observable<any> {
    return this.http.put(TASK_API + `updateTask/${id}`, {
      name,
      description,
      image,
    });
  }

  findByName(name: string): Observable<any> {
    return this.http.get(TASK_API + `getTaskByName/${name}`);
  }
}
