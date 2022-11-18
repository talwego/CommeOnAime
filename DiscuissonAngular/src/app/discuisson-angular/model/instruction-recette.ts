import { Recette } from "./recette";

export class InstructionRecette {
  public get instruction(): string | undefined {
    return this._instruction;
  }
  public set instruction(value: string | undefined) {
    this._instruction = value;
  }
  public get recette(): Recette | undefined {
    return this._recette;
  }
  public set recette(value: Recette | undefined) {
    this._recette = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }



  constructor(
    private _id?: number,
    private _recette?: Recette,
    private _instruction?: string,
  ) {}

}
