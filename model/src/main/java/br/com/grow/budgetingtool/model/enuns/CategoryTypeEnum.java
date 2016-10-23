package br.com.grow.budgetingtool.model.enuns;

public enum CategoryTypeEnum {
	EXPENSE(1), INCOME(2);

	private int index;

	private CategoryTypeEnum(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static CategoryTypeEnum getCategoryTypeEnumByIndex(int index) {
		CategoryTypeEnum categoryTypeEnum = null;

		switch (index) {

		case 1:
			categoryTypeEnum = EXPENSE;
			break;

		case 2:
			categoryTypeEnum = INCOME;
			break;

		}
		return categoryTypeEnum;
	}
}
