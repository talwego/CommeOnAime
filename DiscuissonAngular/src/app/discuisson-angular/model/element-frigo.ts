import { Ingredient } from "./ingredient";
import { User } from "./user";

export class ElementFrigo {

  constructor(
    private _id?: number,
    private _quantite?: number,
    private _user?: User,
    private _ingredient?: Ingredient
  ) {}

}
