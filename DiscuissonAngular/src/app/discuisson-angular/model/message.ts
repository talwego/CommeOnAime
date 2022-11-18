export class Message {
  public get dateMessageDate(): Date | undefined  {
    return this._dateMessageDate;
  }
  public set dateMessageDate(value: Date  | undefined ) {
    this._dateMessageDate = value;
  }
  public get text(): string  | undefined  {
    return this._text;
  }
  public set text(value: string  | undefined ) {
    this._text = value;
  }
  public get sujet(): string  | undefined {
    return this._sujet;
  }
  public set sujet(value: string  | undefined ) {
    this._sujet = value;
  }
  public get id(): number | undefined  {
    return this._id;
  }
  public set id(value: number | undefined ) {
    this._id = value;
  }

  constructor(
    private _id?: number,
    private _sujet?: string,
    private _text?: string,
    private _dateMessageDate?: Date,

  ) {}
}
