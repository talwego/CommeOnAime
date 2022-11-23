import { InstructionRecette } from './instruction-recette';
import { RecetteIngredient } from './recette-ingredient';

export class Recette {
  public get nombrePersonne(): number | undefined {
    return this._nombrePersonne;
  }
  public set nombrePersonne(value: number | undefined) {
    this._nombrePersonne = value;
  }
  public get nombreVotant(): number | undefined {
    return this._nombreVotant;
  }
  public set nombreVotant(value: number | undefined) {
    this._nombreVotant = value;
  }
  public get recetteIngredients(): RecetteIngredient[] | undefined {
    return this._recetteIngredients;
  }
  public set recetteIngredients(value: RecetteIngredient[] | undefined) {
    this._recetteIngredients = value;
  }
  public get instructionRecettes(): InstructionRecette[] | undefined {
    return this._instructionRecettes;
  }
  public set instructionRecettes(value: InstructionRecette[] | undefined) {
    this._instructionRecettes = value;
  }
  public get isValid(): boolean | undefined {
    return this._isValid;
  }
  public set isValid(value: boolean | undefined) {
    this._isValid = value;
  }
  public get tempsDeCuisine(): Date | undefined {
    return this._tempsDeCuisine;
  }
  public set tempsDeCuisine(value: Date | undefined) {
    this._tempsDeCuisine = value;
  }
  public get note(): number | undefined {
    return this._note;
  }
  public set note(value: number | undefined) {
    this._note = value;
  }
  public get commentaires(): string | undefined {
    return this._commentaires;
  }
  public set commentaires(value: string | undefined) {
    this._commentaires = value;
  }
  public get finSaison(): number | undefined {
    return this._finSaison;
  }
  public set finSaison(value: number | undefined) {
    this._finSaison = value;
  }
  public get debutSaison(): number | undefined {
    return this._debutSaison;
  }
  public set debutSaison(value: number | undefined) {
    this._debutSaison = value;
  }
  public get calorie(): number | undefined {
    return this._calorie;
  }
  public set calorie(value: number | undefined) {
    this._calorie = value;
  }
  public get vegan(): boolean | undefined {
    return this._vegan;
  }
  public set vegan(value: boolean | undefined) {
    this._vegan = value;
  }
  public get vegetarien(): boolean | undefined {
    return this._vegetarien;
  }
  public set vegetarien(value: boolean | undefined) {
    this._vegetarien = value;
  }
  public get name(): string | undefined {
    return this._name;
  }
  public set name(value: string | undefined) {
    this._name = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }

  constructor(
    private _id?: number,
    private _name?: string,
    private _vegetarien?: boolean,
    private _vegan?: boolean,
    private _calorie?: number,
    private _debutSaison?: number,
    private _finSaison?: number,
    private _commentaires?: string,
    private _note?: number,
    private _nombreVotant?: number,
    private _nombrePersonne?: number,
    private _tempsDeCuisine?: Date,
    private _isValid?: boolean,
    private _instructionRecettes?: InstructionRecette[],
    private _recetteIngredients?: RecetteIngredient[]
  ) {}
}
