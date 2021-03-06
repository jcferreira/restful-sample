package br.com.amil.restful.mediatype.usuario;

import java.io.Serializable;

import br.com.amil.model.Beneficiario;
import br.com.amil.restful.service.BeneficiarioRest;
import br.com.caelum.vraptor.restfulie.hypermedia.HypermediaResource;
import br.com.caelum.vraptor.restfulie.relation.RelationBuilder;

public class BeneficiarioMediaType implements HypermediaResource, Serializable {

	private static final long serialVersionUID = 7530815288833592969L;
	
	private Beneficiario beneficiario;

	public BeneficiarioMediaType(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	@Override
	public void configureRelations(RelationBuilder builder) {
		builder.relation("beneficiario").at("/beneficiario");
		
		builder.relation("beneficiario").uses(BeneficiarioRest.class).listar();
		builder.relation("beneficiario").uses(BeneficiarioRest.class).buscar(beneficiario.getId());
		builder.relation("beneficiario").uses(BeneficiarioRest.class).salvar(beneficiario);
		builder.relation("beneficiario").uses(BeneficiarioRest.class).atualizar(beneficiario);
		builder.relation("beneficiario").uses(BeneficiarioRest.class).excluir(beneficiario.getId());
	}
	
}
