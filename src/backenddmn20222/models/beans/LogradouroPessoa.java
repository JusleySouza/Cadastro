package backenddmn20222.models.beans;

public class LogradouroPessoa {

	private int id;
	private int idLogradouro;
	private int idPessoa;
	private String obs;
	private Logradouro logradouro;
	private PessoaFisica pessoa;

	public LogradouroPessoa(int id) {
		this.id = id;
	}

	public LogradouroPessoa(String obs) {
		super();
		this.obs = obs;
	}

	public LogradouroPessoa(int idLogradouro, int idPessoa, String obs) {
		this.idLogradouro = idLogradouro;
		this.idPessoa = idPessoa;
		this.obs = obs;
	}

	public LogradouroPessoa(int id, int idLogradouro, int idPessoa, String obs) {
		this.id = id;
		this.idLogradouro = idLogradouro;
		this.idPessoa = idPessoa;
		this.obs = obs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdLogradouro() {
		return idLogradouro;
	}

	public void setIdLogradouro(int idLogradouro) {
		this.idLogradouro = idLogradouro;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public PessoaFisica getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaFisica pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "LogradouroPessoa [id=" + id + ", idLogradouro=" + idLogradouro + ", idPessoa=" + idPessoa + ", obs="
				+ obs + "]";
	}

}
