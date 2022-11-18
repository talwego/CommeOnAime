import { Compte } from './compte';
import { Genre } from './genre';





export class Nutritionist extends Compte {


  constructor(
    _id?: number,
    _login?: string,
    _password?: string,
  ) {
    super(_id, _login, _password);
  }
}
