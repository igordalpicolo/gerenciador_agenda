package br.com.gerenciadoragenda.entities.enums;

public enum Team {

	FAMILY(1), 
	FRIENDS(2), 
	JOB(3);

	private int code;

	private Team(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static Team valueOf(int code) {
		for (Team value : Team.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Group code");
	}
}
