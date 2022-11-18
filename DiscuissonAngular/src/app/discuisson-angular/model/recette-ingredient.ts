import { Recette } from "./recette";

export class RecetteIngredient {

  constructor(
    private _id?: number,
    private _ingredient?: Ingredient,
    private _recette?: Recette,

  ) {}


}
