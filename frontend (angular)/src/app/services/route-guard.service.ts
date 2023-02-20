import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router } from '@angular/router';
import { AuthService } from './auth.service';
import { SnackbarService } from './snackbar.service';
import jwt_decode from "jwt-decode";
import { GlobalConstants } from '../shared/global-constants';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService {

  constructor(public auth:AuthService, public router:Router, private snackBarService:SnackbarService) { }

  canActivate(router:ActivatedRouteSnapshot):boolean {
    let expectedRoleArray = router.data;
    expectedRoleArray = expectedRoleArray.expectedRole;

    const token:any = localStorage.getItem("token");

    var tokenPayLoad:any;
    
    try {
      tokenPayLoad = jwt_decode(token);
    } catch(err) {
      localStorage.clear();
      this.router.navigate(['/']);
    }

    let expectedRole = '';

    for (let i = 0; i < expectedRoleArray.length; i++) {
      if (expectedRoleArray[i] == tokenPayLoad.role) {
        expectedRole = tokenPayLoad.role;
      }
    }

    if (tokenPayLoad.role == 'user' || tokenPayLoad.role == 'admin') {
      if (this.auth.isAuthenticated() && tokenPayLoad.role == expectedRole) {
        return true;
      }
      this.snackBarService.openSnackBar(GlobalConstants.unauthorized, GlobalConstants.error);
      this.router.navigate(['/cafe/dashboard']);
      return false;
    }
    else {
      this.router.navigate(['/']);
      localStorage.clear();
      return false;
    }
  }
}
