package test;

import java.time.LocalDate;

import model.Ingredient;

public class TestRemplissageBDD {
	Ingredient ingredient00 = new Ingredient("ing00", 00, LocalDate.of(2020, 1, 10), LocalDate.of(2020, 12, 20), false, false);
	Ingredient ingredient01 = new Ingredient("ing01",10, LocalDate.of(2020, 1, 10), LocalDate.of(2020, 7, 20), false, true);
	Ingredient ingredient02 = new Ingredient("ing02",20, LocalDate.of(2020, 2, 10), LocalDate.of(2020, 10, 20), true, true);
	Ingredient ingredient03 = new Ingredient("ing03",30, LocalDate.of(2020, 2, 10), LocalDate.of(2020, 8, 20), true, false);
	Ingredient ingredient04 = new Ingredient("ing04",40, LocalDate.of(2020, 3, 10), LocalDate.of(2020, 11, 20), false, true);
	Ingredient ingredient05 = new Ingredient("ing05",50, LocalDate.of(2020, 3, 10), LocalDate.of(2020, 5, 20), true, false);
	Ingredient ingredient06 = new Ingredient("ing06",60, LocalDate.of(2020, 4, 10), LocalDate.of(2020, 4, 20), true, false);
	Ingredient ingredient07 = new Ingredient("ing07",70, LocalDate.of(2020, 4, 10), LocalDate.of(2020, 9, 20), false, true);
	Ingredient ingredient08 = new Ingredient("ing08",80, LocalDate.of(2020, 5, 10), LocalDate.of(2020, 10, 20), false, false);
	Ingredient ingredient09 = new Ingredient("ing09",90, LocalDate.of(2020, 5, 10), LocalDate.of(2020, 12, 20), false, true);
	Ingredient ingredient10 = new Ingredient("ing10",00, LocalDate.of(2020, 1, 10), LocalDate.of(2020, 12, 20), false, false);
	Ingredient ingredient11 = new Ingredient("ing11",10, LocalDate.of(2020, 1, 10), LocalDate.of(2020, 7, 20), true, true);
	Ingredient ingredient12 = new Ingredient("ing12",20, LocalDate.of(2020, 2, 10), LocalDate.of(2020, 10, 20), false, false);
	Ingredient ingredient13 = new Ingredient("ing13",30, LocalDate.of(2020, 2, 10), LocalDate.of(2020, 8, 20), false, true);
	Ingredient ingredient14 = new Ingredient("ing14",40, LocalDate.of(2020, 3, 10), LocalDate.of(2020, 11, 20), true, false);
	Ingredient ingredient15 = new Ingredient("ing15",50, LocalDate.of(2020, 3, 10), LocalDate.of(2020, 5, 20), true, false);
	Ingredient ingredient16 = new Ingredient("ing16",60, LocalDate.of(2020, 4, 10), LocalDate.of(2020, 4, 20), false, true);
	Ingredient ingredient17 = new Ingredient("ing17",70, LocalDate.of(2020, 4, 10), LocalDate.of(2020, 9, 20), true, false);
	Ingredient ingredient18 = new Ingredient("ing18",80, LocalDate.of(2020, 5, 10), LocalDate.of(2020, 10, 20), false, true);
	Ingredient ingredient19 = new Ingredient("ing19",90, LocalDate.of(2020, 5, 10), LocalDate.of(2020, 12, 20), false, true);
}
