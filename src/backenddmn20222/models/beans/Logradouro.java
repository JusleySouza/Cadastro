package backenddmn20222.models.beans;

public class Logradouro {

	int id;
	String endereco;
	int numero;
	String cep;
	String complemento;

	public Logradouro(int id) {
		this.id = id;
	}

	public Logradouro(String cep) {
		super();
		this.cep = cep;
	}

	public Logradouro(String endereco, String cep, int numero,  String complemento) {
		this.endereco = endereco;
		this.numero = numero;
		this.cep = cep;
		this.complemento = complemento;
	}

	public Logradouro(int id, String endereco, String cep, int numero,  String complemento) {
		this.id = id;
		this.endereco = endereco;
		this.numero = numero;
		this.cep = cep;
		this.complemento = complemento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return "Logradouro [id=" + id + ", endereco=" + endereco + ", numero=" + numero + ", cep=" + cep
				+ ", complemento=" + complemento + "]";
	}

}
