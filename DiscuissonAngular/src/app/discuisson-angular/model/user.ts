import { Compte } from './compte';
import { Genre } from './genre';

export class Client extends Compte {


  public get genre(): Genre {
    return this._genre;
  }
  public set compte(value: Compte) {
    this._genre = value;
  }

  constructor(
    _id?: number,
    _login?: string,
    _password?: string,
    _genre?: Genre,
    _age?: number,
    _taille?: number,
    _poids?:number,
    _compteVIP?:boolean,
    _vegetarien?:boolean,
    _vegan?:boolean,
  ) {
    super(_id, _login, _password);
  }
}
