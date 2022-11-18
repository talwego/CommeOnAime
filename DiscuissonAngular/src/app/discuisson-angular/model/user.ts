import { Compte } from './compte';
import { Genre } from './genre';

export class User extends Compte {

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
  public get compteVIP(): boolean | undefined {
    return this._compteVIP;
  }
  public set compteVIP(value: boolean | undefined) {
    this._compteVIP = value;
  }
  public get poids(): number | undefined {
    return this._poids;
  }
  public set poids(value: number | undefined) {
    this._poids = value;
  }
  public get taille(): number | undefined {
    return this._taille;
  }
  public set taille(value: number | undefined) {
    this._taille = value;
  }
  public get age(): number | undefined {
    return this._age;
  }
  public set age(value: number | undefined) {
    this._age = value;
  }
  public get genre(): Genre | undefined {
    return this._genre;
  }
  public set genre(value: Genre | undefined) {
    this._genre = value;
  }


  constructor(
    _id?: number,
    _login?: string,
    _password?: string,
    private _genre?: Genre,
    private _age?: number,
    private _taille?: number,
    private _poids?: number,
    private _compteVIP?: boolean,
    private _vegetarien?: boolean,
    private _vegan?: boolean,
  ) {
    super(_id, _login, _password);
  }
}
