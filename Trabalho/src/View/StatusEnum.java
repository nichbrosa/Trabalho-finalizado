package View;
//enum para mostragem do status do usuario
public enum StatusEnum {
	
	ESPERANDO_LOGIN ("0"),
	LOGIN_INVALIDO ("1"),
	LOGADO ("2");
	
	private String periodo;
	
	StatusEnum(String status) {
		this.periodo = status;
	}

	public String getPeriodo() {
		return periodo;
	}
}