package kr.or.ddit.vo;

import java.io.IOException;
import java.io.Serializable;
import java.io.UncheckedIOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.LoginGroup;
import kr.or.ddit.validate.constraints.TelNumber;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 회원 관리용 Domain Layer
 *
 */
@Data
@EqualsAndHashCode(of = "memId")
@NoArgsConstructor
public class MemberVO implements Serializable {
	
	public MemberVO(String memId, String memPass) {
		super();
		this.memId = memId;
		this.memPass = memPass;
	}
	private int rnum;
	@NotBlank(groups = {InsertGroup.class, DeleteGroup.class, LoginGroup.class})
	private String memId;
	@NotBlank(groups = {Default.class, LoginGroup.class})
	@Size(min = 4, max = 12, groups = {Default.class, LoginGroup.class})
	private String memPass;
	@NotBlank(groups = InsertGroup.class)
	private String memName;
	@Size(min = 6, max = 6)
	@JsonIgnore
	@ToString.Exclude
	private transient String memRegno1;
	@JsonIgnore
	@ToString.Exclude
	private transient String memRegno2;
	@DateTimeFormat(iso = ISO.DATE_TIME) //json데이터를 받을때 동작함 ( json데이터를 내보낼때는 동작하지 않음)
//	@JsonFormat(shape = Shape.STRING)
	private LocalDateTime memBir;
	@NotBlank
	private String memZip;
	@NotBlank
	private String memAdd1;
	@NotBlank
	private String memAdd2;
	
	@TelNumber(regex = "\\d{2,3}\\)\\d{3,4}-\\d{4}")
	private String memHometel;
	
	@TelNumber
	private String memComtel;
	
	@NotBlank
	@TelNumber
	private String memHp;
	@Email
	private String memMail;
	private String memJob;
	private String memLike;
	private String memMemorial;
	@DateTimeFormat(iso = ISO.DATE)
//	@JsonFormat(shape = Shape.STRING)
	private LocalDate memMemorialday;
	private Integer memMileage;
	private boolean memDelete;
	
	@JsonIgnore
	private transient List<CartVO> cartList; // Has Many
	// MEMBER(1) : CART[PROD(1)](N)
	
	private String memRole;
	
	private byte[] memImg; // 데이터베이스 연결용
	private MultipartFile memImage; // 클라이언트 업로드 파일 수신용
	
	public void setMemImage(MultipartFile memImage) {
		if(memImage==null || memImage.isEmpty()) return;
		this.memImage = memImage;
		try {
			this.memImg = memImage.getBytes();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	public String getBase64Img() {
		if(memImg==null) return null;
		else 
			return Base64.getEncoder().encodeToString(memImg);
	}
}







