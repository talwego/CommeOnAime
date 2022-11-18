import { Ingredient } from "./ingredient";
import { Recette } from "./recette";

export class RecetteIngredient {
  public get recette(): Recette  | undefined {
    return this._recette;
  }
  public set recette(value: Recette  | undefined) {
    this._recette = value;
  }
  public get ingredient(): Ingredient  | undefined {
    return this._ingredient;
  }
  public set ingredient(value: Ingredient  | undefined) {
    this._ingredient = value;
  }
  public get id(): number  | undefined {
    return this._id;
  }
  public set id(value: number  | undefined) {
    this._id = value;
  }

  constructor(
    private _id?: number,
    private _ingredient?: Ingredient,
    private _recette?: Recette,

  ) {}


}
