package backenddmn20222.models.beans;

public class UsuarioPessoa {

	private int id;
	private int idUsuario;
	private int idPessoa;
	private String obs;
	private Usuario usuario;
	private PessoaFisica pessoa;

	public UsuarioPessoa() {}
	
	public UsuarioPessoa(int id) {
		this.id = id;
	}
	
	public UsuarioPessoa(String obs) {
		super();
		this.obs = obs;
	}

	public UsuarioPessoa(int idUsuario, int idPessoa, String obs) {
		this.idUsuario = idUsuario;
		this.idPessoa = idPessoa;
		this.obs = obs;
	}
	
	public UsuarioPessoa(int id, int idUsuario, int idPessoa, String obs) {
		this.id = id;
		this.idUsuario = idUsuario;
		this.idPessoa = idPessoa;
		this.obs = obs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PessoaFisica getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaFisica pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "UsuarioPessoa [id=" + id + ", idUsuario=" + idUsuario + ", idPessoa=" + idPessoa + ", obs=" + obs
				+ "]";
	}

}