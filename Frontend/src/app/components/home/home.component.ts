import { Component, OnInit } from "@angular/core";
import { StorageService } from "src/app/_services/storage.service";
import { TaskService } from "src/app/_services/task.service";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"],
})
export class HomeComponent implements OnInit {
  form: any = {
    taskName: "",
  };
  role: string = "";
  tasks: any[] = [];

  constructor(
    private storageService: StorageService,
    private taskService: TaskService
  ) {}

  ngOnInit(): void {
    if (
      this.storageService.isLoggedIn() &&
      this.storageService.getUser().roles.includes("ROLE_USER")
    ) {
      this.role = this.storageService.getUser().roles;
      this.taskService.findByName("*").subscribe({
        next: (data) => {
          this.tasks = data;
        },
      });
    }
  }

  onSubmit(): void {
    const { taskName } = this.form;
    this.taskService.findByName(taskName).subscribe({
      next: (data) => {
        this.tasks = data;
      },
      error: (err) => {
        console.log(err.error.message);
      },
    });
  }
}
