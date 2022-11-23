import { Compte } from "./compte";

export class Message {
  public get recepteur(): Compte | undefined {
    return this._recepteur;
  }
  public set recepteur(value: Compte | undefined) {
    this._recepteur = value;
  }
  public get envoyeur(): Compte | undefined {
    return this._envoyeur;
  }
  public set envoyeur(value: Compte | undefined) {
    this._envoyeur = value;
  }

  public get text(): string  | undefined {
    return this._text;
  }
  public set text(value: string  | undefined ) {
    this._text = value;
  }
  public get id(): number | undefined  {
    return this._id;
  }
  public set id(value: number | undefined ) {
    this._id = value;
  }

  constructor(
    private _id?: number,
    private _text?: string,
    private _envoyeur?: Compte,
    private _recepteur?: Compte,

  ) {}
}
