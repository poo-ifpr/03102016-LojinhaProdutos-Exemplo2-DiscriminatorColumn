package model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import util.DateUtils;

@Entity
@DiscriminatorValue("ProdutoPerecivel")
public class ProdutoPerecivel extends Produto {
	
	public ProdutoPerecivel(String nome, long preco, Date dataValidade, boolean importado) {
		setNome(nome);
		setPreco(preco);
		setDataValidade(dataValidade);
	}
	
	@Temporal(TemporalType.DATE)
	private Date dataValidade;
	
	public Date getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	public double getPrecoFinal(){
		double preco = getPreco();
		Date hoje = DateUtils.hoje();
		if(dataValidade != null){
			Date semana_que_vem = DateUtils.
					somar(hoje, 7);
			if(semana_que_vem.after(dataValidade)){
				preco = preco * 0.9;
			}
		}
		return Math.round(preco * 100.0) / 100.0;
	}
	
	@Override
	public String toString() {
		return "Produto [id=" + getId() + ", nome=" + getNome() + ", preco=" + getPreco() + ", dataValidade=" + getDataValidade()
				+  "]";
	}

}
