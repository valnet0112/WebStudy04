package kr.or.ddit.basetech.generic.material;

import lombok.Data;

/**
 * 타입변수 T와 C 의 구체적 타입은 런타임에 SampleHouse 의 인스턴스가 생성될때 결정됨.
 *
 * @param <T>
 * @param <C>
 */
@Data
public class SampleHouse<T,C> {
	private T person;
	
	public C casting1(){
		return (C) person;
	}
}
