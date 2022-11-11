package backenddmn20222.models.beans;

public class PessoaFisica {

	private int id;
	private String nome;
	private String cpf;
	private String rg;

	public PessoaFisica(int id) {
		this.id = id;
	}
	
	public PessoaFisica(String nome) {
		this.nome = nome;
	}

	public PessoaFisica(String nome, String cpf, String rg) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
	}

	public PessoaFisica(int id, String nome, String rg, String cpf) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public String toString() {
		return "PessoaFisica [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + "]";
	}


}
