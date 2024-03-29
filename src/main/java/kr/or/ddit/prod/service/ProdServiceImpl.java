 package kr.or.ddit.prod.service;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.exception.PKNotFoundException;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.vo.ProdVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor   // 꼭받아야하는 생성자만 넣어줌
public class ProdServiceImpl implements ProdService {
   
   private final ProdDAO dao;
   
   @Value("#{appInfo.prodPath}")
   private Resource prodFolder;

   private File saveFolder;
   @PostConstruct
   public void init() throws IOException {
	   saveFolder = prodFolder.getFile();
   }
   
   /**
    * 상품 등록이나 수정 시 업로드된 상품 이미지 2진 데이터 저장
    */
   private void prodcessProdImage(ProdVO prod) {
      // 1. 2진 데이터 확보
      MultipartFile prodImage = prod.getProdImage();   // 존재할수도있고 없을수도 있다
      if(prodImage == null) return;   // 존재
//     if(1==1) throw new RuntimeException("강제 발생 예외");       // 실행 하고 이미지가 존재할때  강제로 예외 발생처리
       try {
 //    Resource imageFile = prodFolder.createRelative(prod.getProdImg());
    	 File imageFile = new File(saveFolder, prod.getProdImg());
         prodImage.transferTo(imageFile);     // 파일 저장
      } catch (IOException e) {
         throw new UncheckedIOException(e);
      }
   }
   
   @Override
   public ServiceResult createProd(ProdVO prod) {
      ServiceResult result = dao.insertProd(prod) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
      if(result == ServiceResult.OK) 
         prodcessProdImage(prod);   // 2진 데이터 저장 , 성공했을 때 저장을 하자
      return result;
   }

   @Override
   public List<ProdVO> retrieveProdList(PaginationInfo  paging) {
      int totalRecord = dao.selectTotalRecord(paging);
      paging.setTotalRecord(totalRecord);
      return dao.selectProdList(paging);
   }

   @Override
   public ProdVO retrieveProd(String prodId) {
      ProdVO prod = dao.selectProd(prodId);
      if(prod == null) {
         throw new PKNotFoundException(String.format("%s에 해당하는 상품 없음", prodId));
      }
      return dao.selectProd(prodId);
   }

   @Override
   public ServiceResult modifyProd(ProdVO prod) {
      ServiceResult result = dao.updateProd(prod) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
      if(result == ServiceResult.OK) 
         prodcessProdImage(prod);   // 2진 데이터 저장 , 성공했을 때 저장을 하자
      return result;
   }

}