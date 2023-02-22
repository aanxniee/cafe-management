import { Injectable } from "@angular/core";

export interface Menu {
    state:string;
    name:string;
    type:string;
    role:string;
}

const MENUITEMS = [
    {state:'dashboard', name:'Dashboard', type:'link', role:''},
    {state:'category', name:'Manage Categories', type:'link', role:'admin'},
    {state:'product', name:'Manage Products', type:'link', role:'admin'}
]

@Injectable()
export class MenuItems{
    getMenuitem():Menu[]{
        return MENUITEMS;
    }
}