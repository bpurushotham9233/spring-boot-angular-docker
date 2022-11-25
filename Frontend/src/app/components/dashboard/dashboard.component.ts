import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthService } from "src/app/_services/auth.service";
import { StorageService } from "src/app/_services/storage.service";
import { TaskService } from "src/app/_services/task.service";

@Component({
  selector: "app-dashboard",
  templateUrl: "./dashboard.component.html",
  styleUrls: ["./dashboard.component.css"],
})
export class DashboardComponent implements OnInit {
  form: any = {
    taskName: null,
    description: null,
  };
  isCreadtedFailed: boolean = false;
  isSuccessful: boolean = true;
  isEditable: boolean = false;
  editingModel: any = [];
  errorMessage: string = "";
  tasks: any[];

  constructor(
    private storageService: StorageService,
    private router: Router,
    private taskService: TaskService
  ) {}

  ngOnInit(): void {
    if (
      !this.storageService.isLoggedIn ||
      this.storageService.getUser().roles.includes("ROLE_USER")
    ) {
      this.router.navigateByUrl("/login");
    } else {
      this.taskService.getTasks().subscribe({
        next: (data) => {
          this.tasks = data;
        },
        error: (err) => {
          console.log(err.error.message);
        },
      });
    }
  }

  onSubmit(): void {
    const { taskName, description } = this.form;
    if (!this.isEditable) {
      this.taskService.addTask(taskName, description).subscribe({
        next: (data) => {
          this.isSuccessful = true;
          this.isCreadtedFailed = false;
          window.location.reload();
        },
        error: (err) => {
          this.errorMessage = err.error.message;
          this.isCreadtedFailed = true;
        },
      });
    } else {
      this.taskService
        .updateTask(this.editingModel.id, taskName, description)
        .subscribe({
          next: (data) => {
            this.isEditable = false;
            this.editingModel = null;
            window.location.reload();
          },
          error: (err) => {
            this.errorMessage = err.error.message;
          },
        });
    }
  }

  handleEdit(id: string): void {
    this.isEditable = true;
    this.editingModel = this.tasks.find((item) => item.id === id);
    this.form.taskName = this.editingModel.name;
    this.form.description = this.editingModel.description;
  }

  handleRemove(id: string): void {
    this.taskService.removeTask(id).subscribe({
      next: (data) => {
        window.location.reload();
      },
      error: (err) => {
        console.log(err.error.message);
      },
    });
  }
}
