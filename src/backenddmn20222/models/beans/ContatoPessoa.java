package backenddmn20222.models.beans;

public class ContatoPessoa {

	private int id;
	private int idContato;
	private int idPessoa;
	private String obs;
	private Contato contato;
	private PessoaFisica pessoa;

	public ContatoPessoa(int id) {
		this.id = id;
	}

	public ContatoPessoa(String obs) {
		super();
		this.obs = obs;
	}

	public ContatoPessoa(int idContato, int idPessoa, String obs) {
		this.idContato = idContato;
		this.idPessoa = idPessoa;
		this.obs = obs;
	}

	public ContatoPessoa(int id, int idContato, int idPessoa, String obs) {
		this.id = id;
		this.idContato = idContato;
		this.idPessoa = idPessoa;
		this.obs = obs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdContato() {
		return idContato;
	}

	public void setIdContato(int idContato) {
		this.idContato = idContato;
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

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public PessoaFisica getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaFisica pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "ContatoPessoa [id=" + id + ", idContato=" + idContato + ", idPessoa=" + idPessoa + ", obs=" + obs + "]";
	}

}
