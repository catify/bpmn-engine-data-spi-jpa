package com.catify.processengine.serviceproviders.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.catify.processengine.core.data.dataobjects.TimerBean;
import com.catify.processengine.serviceproviders.jpa.beans.TimerEntity;
import com.catify.processengine.serviceproviders.jpa.repositories.TimerRepository;

public class JpaTimerSpiTest {

	private JpaTimerSpi spi;
	
	private static final String ACTOR_REF = "";
	private static final String PIID = "4711";

	@Before
	public void setUp() throws Exception {
		this.spi = new JpaTimerSpi();
	}
	
	@Test
	public void testSaveTimer() {
		assertEquals(0, spi.getRepository().count());
		this.spi.saveTimer(getTimerBean(123));		
		assertEquals(1, spi.getRepository().count());
	}

	@Test
	public void testLoadDueTimers() {
		this.spi.saveTimer(getTimerBean(1000));
		this.spi.saveTimer(getTimerBean(2000));
		assertEquals(2, spi.getRepository().count());
		List<TimerBean> timers = this.spi.loadDueTimers(ACTOR_REF);
		assertNotNull(timers);
		assertEquals(2, timers.size());
	}

	@Test
	public void testDeleteTimer() {
		assertEquals(0, spi.getRepository().count());
		this.spi.saveTimer(getTimerBean(123));		
		assertEquals(1, spi.getRepository().count());
		this.spi.deleteTimer(ACTOR_REF, PIID);
		assertEquals(0, spi.getRepository().count());
	}

	@Test
	public void testJpaTimerSpi() {
		TimerRepository repository = spi.getRepository();
		assertNotNull(repository);
	}

	@Test
	public void testMapTimer() {
		TimerBean bean = getTimerBean(123);
		TimerEntity entity = spi.mapTimer(bean);
		assertNotNull(entity);
		assertEquals(123, entity.getTimeToFire());
		assertEquals(ACTOR_REF, entity.getActorRef());
		assertEquals(PIID, entity.getProcessInstanceId());
	}
	
	private TimerBean getTimerBean(long time) {
		return  new TimerBean(time, ACTOR_REF, PIID);
	}

}
