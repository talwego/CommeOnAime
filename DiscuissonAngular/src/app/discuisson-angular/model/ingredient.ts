import { Unite } from './unite';

export class Ingredient {
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  public get name(): string | undefined {
    return this._name;
  }
  public set name(value: string | undefined) {
    this._name = value;
  }
  public get calorie(): number | undefined {
    return this._calorie;
  }
  public set calorie(value: number | undefined) {
    this._calorie = value;
  }
  public get dateDebutRecolte(): number | undefined {
    return this._dateDebutRecolte;
  }
  public set dateDebutRecolte(value: number | undefined) {
    this._dateDebutRecolte = value;
  }
  public get dateFinRecolte(): number | undefined {
    return this._dateFinRecolte;
  }
  public set dateFinRecolte(value: number | undefined) {
    this._dateFinRecolte = value;
  }
  public get vegetarien(): boolean | undefined {
    return this._vegetarien;
  }
  public set vegetarien(value: boolean | undefined) {
    this._vegetarien = value;
  }
  public get vegan(): boolean | undefined {
    return this._vegan;
  }
  public set vegan(value: boolean | undefined) {
    this._vegan = value;
  }
  public get unite(): Unite | undefined {
    return this._unite;
  }
  public set unite(value: Unite | undefined) {
    this._unite = value;
  }
  constructor(
    private _id?: number,
    private _name?: string,
    private _calorie?: number,
    private _dateDebutRecolte?: number,
    private _dateFinRecolte?: number,
    private _vegetarien?: boolean,
    private _vegan?: boolean,
    private _unite?: Unite
  ) {}
}
