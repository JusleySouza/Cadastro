package backenddmn20222.models.beans;

public class Contato {

	int id;
	String telefone;
	String email;

	public Contato(int id) {
		this.id = id;
	}

	public Contato(String email) {
		this.email = email;
	}

	public Contato(String telefone, String email) {
		this.telefone = telefone;
		this.email = email;
	}

	public Contato(int id, String telefone, String email) {
		super();
		this.id = id;
		this.telefone = telefone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", telefone=" + telefone + ", email=" + email + "]";
	}

}
