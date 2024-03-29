package kr.or.ddit.basetech.designpattern.adapter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.basetech.designpattern.adapter.material.Adaptee;
import kr.or.ddit.basetech.designpattern.adapter.material.Adapter;
import kr.or.ddit.basetech.designpattern.adapter.material.Client;
import kr.or.ddit.basetech.designpattern.adapter.material.OtherConcrete;

class AdapterPatternTest {

	@Test
	void test() {
		Client client = new Client();
		client.setTarget(new OtherConcrete());
		client.getTarget().request();
	}
	@Test
	void testUseAdaptee() {
		Client client = new Client();
		client.setTarget(new Adapter(new Adaptee()));
		client.getTarget().request();
	}
}
