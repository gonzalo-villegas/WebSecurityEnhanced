import { User } from '../../model/User';
import { UserService } from '../../model/user.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  templateUrl: 'dashboard.component.html'
})
export class DashboardComponent implements OnInit {
  currentUser: User;
  users: User[] = [];
  constructor(private userService: UserService ) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }
  ngOnInit() {

  }

    deleteUser(id: number) {
        this.userService.delete(id).subscribe(() => {
          this.loadAllUsers();
        });
    }

    private loadAllUsers() {
        this.userService.getAll().subscribe(users => { this.users = users; });
    }
}
