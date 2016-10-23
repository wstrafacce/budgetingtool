package br.com.grow.budgetingtool.model.enuns;

public enum InsertModeEnum {
	
	MANUAL(1), AUTO(2);
	
	private int index;

	private InsertModeEnum(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public static InsertModeEnum getInsertModeEnumByIndex(int index) {
		InsertModeEnum insertModeEnum = null;

		switch (index) {

		case 1:
			insertModeEnum = MANUAL;
			break;

		case 2:
			insertModeEnum = AUTO;
			break;

		}
		return insertModeEnum;
	}
}
