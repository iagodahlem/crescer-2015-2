package br.com.cwi.crescer.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authorities {

	@EmbeddedId
	private AuthoritiesID authoritiesID;

	public AuthoritiesID getAuthoritiesID() {
		return authoritiesID;
	}

	public void setAuthoritiesID(AuthoritiesID authoritiesID) {
		this.authoritiesID = authoritiesID;
	}
	
}
