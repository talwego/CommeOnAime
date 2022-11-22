import { Compte } from './compte';

export class Nutritionist extends Compte {
  constructor(_id?: number, _login?: string, _password?: string) {
    super(_id, _login, _password);
  }
}
