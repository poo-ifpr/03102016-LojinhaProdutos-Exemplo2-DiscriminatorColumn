import java.util.Date;

import dao.ProdutoDAO;
import model.Produto;
import model.ProdutoImportado;
import model.ProdutoPerecivel;
import util.DateUtils;

public class MainLojinhaPRO {

	
	public static void main(String[] args) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto pote_mana = new Produto("Pote de Mana", 10);
		Produto o_doce = new ProdutoPerecivel("O doce", 5,
				DateUtils.converteData("08/10/2016"),false);
		Produto xisburgui = new ProdutoImportado("xisburgui", 11);
		//Produto suco_manga = new Produto("suco de manga", 10,
		//		DateUtils.converteData("06/10/2016"), true);
		
		produtoDAO.adicionar(pote_mana);
		produtoDAO.adicionar(o_doce);
		produtoDAO.adicionar(xisburgui);
		//produtoDAO.adicionar(suco_manga);
		
		System.out.println(pote_mana.getPrecoFinal());
		System.out.println(o_doce.getPrecoFinal());
		System.out.println(xisburgui.getPrecoFinal());
		//System.out.println(suco_manga.getPrecoFinal());
	}
	
}
