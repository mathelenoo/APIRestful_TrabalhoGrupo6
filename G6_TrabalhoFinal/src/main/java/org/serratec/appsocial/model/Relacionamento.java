package org.serratec.appsocial.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Relacionamento implements Serializable {
	@EmbeddedId
	private RelacionamentoId id;

	@ManyToOne
	@MapsId("seguidorId")
	private Usuario seguidor;

	@ManyToOne
	@MapsId("seguidoId")
	private Usuario seguido;

	private Date dataCriacao;

	// Getters e Setters

	public RelacionamentoId getId() {
		return id;
	}

	public void setId(RelacionamentoId id) {
		this.id = id;
	}

	public Usuario getSeguidor() {
		return seguidor;
	}

	public void setSeguidor(Usuario seguidor) {
		this.seguidor = seguidor;
	}

	public Usuario getSeguido() {
		return seguido;
	}

	public void setSeguido(Usuario seguido) {
		this.seguido = seguido;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Embeddable
	public static class RelacionamentoId implements Serializable {
		private Long seguidorId;
		private Long seguidoId;

		public Long getSeguidorId() {
			return seguidorId;
		}

		// Getters, Setters,

		public void setSeguidorId(Long seguidorId) {
			this.seguidorId = seguidorId;
		}

		public Long getSeguidoId() {
			return seguidoId;
		}

		public void setSeguidoId(Long seguidoId) {
			this.seguidoId = seguidoId;
		}

		@Override
		public int hashCode() {
			return Objects.hash(seguidoId, seguidorId);
		}

		// equals() e hashCode()

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RelacionamentoId other = (RelacionamentoId) obj;
			return Objects.equals(seguidoId, other.seguidoId) && Objects.equals(seguidorId, other.seguidorId);
		}

	}

}
