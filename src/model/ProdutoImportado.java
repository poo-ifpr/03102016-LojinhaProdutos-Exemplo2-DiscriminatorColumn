package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import util.DateUtils;

@Entity
@DiscriminatorValue("ProdutoImportado")
public class ProdutoImportado extends Produto {
	
	public ProdutoImportado(String nome, long preco) {
		setNome(nome);
		setPreco(preco);
	}
	
		public double getPrecoFinal(){
		double preco = getPreco();
		preco = preco  * 1.2;
		return Math.round(preco * 100.0) / 100.0;
	}
	
	@Override
	public String toString() {
		return "ProdutoImportado [id=" + getId() + ", nome=" + getNome() + ", preco=" + getPreco() + "]";
	}

}
