package kr.or.ddit.buyer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.buyer.dao.BuyerDAO;
import kr.or.ddit.common.exception.PKNotFoundException;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.vo.BuyerVO;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService {
	
	private final BuyerDAO dao;
	@Override
	public BuyerVO retrieveBuyer(String buyerId) {
		BuyerVO buyer = dao.selectBuyer(buyerId);
		if(buyer==null)
			throw new PKNotFoundException(String.format("%s 제조사 없음.", buyerId));
		return buyer;
	}

	@Override
	public List<BuyerVO> retrieveBuyerList(PaginationInfo paging) {
		int totalRecord = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return dao.selectBuyerList(paging);
	}

	@Override
	public void createBuyer(BuyerVO buyer) {
		
	}

	@Override
	public void modifyBuyer(BuyerVO buyer) {
		
	}

}
