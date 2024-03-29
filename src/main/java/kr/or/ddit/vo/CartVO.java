package kr.or.ddit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"cartNo", "cartProd"})
public class CartVO {
	private String cartMember;
	private String cartNo;
	private String cartProd;
	private Integer cartQty;
	
	private ProdVO prod; // Has A
}
